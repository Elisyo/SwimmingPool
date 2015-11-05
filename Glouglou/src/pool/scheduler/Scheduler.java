package pool.scheduler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import pool.action.Action;
import pool.exception.ActionFinishedException;
import pool.exception.SchedulerInProgressException;

/**
 * @author loic
 * A simple scheduler of actions
 * A scheduler is an action
 */
public abstract class Scheduler extends Action{
	
	public List<Action> actions = new ArrayList<Action>();
	protected boolean isReady=true;
	protected boolean isInitialized=true;

	@Override
	public boolean isInProgress(){
		return isInitialized() && super.isInProgress();
	}
	
	@Override
	public boolean isReady() {
		return (isReady && isInitialized());
	}
	@Override
	public boolean isInitialized() {
		return this.isInitialized;
	}
	
	@Override
	public void doStep() throws ActionFinishedException{
		this.isReady=false;
		super.doStep();
	}
	
	@Override
	public boolean isFinished() {
		return(getActions().isEmpty() && (!isReady())&&(isInitialized()));
	}
	
	@Override
	public void reallyDoStep() {
		Action nextAction = getNextAction();
		try {
			nextAction.doStep();
		} catch (ActionFinishedException e) {
			System.out.println("The current action is finished");
		}
		if(nextAction.isFinished())
			removeFinishedAction();
		
	}
	
	/**
	 * Add an action to list of actions
	 * @param action
	 * @throws ActionFinishedException
	 * @throws SchedulerInProgressException 
	 */
	public void addAction(Action action) throws ActionFinishedException, SchedulerInProgressException {
		if(this.isFinished()) {
			throw new ActionFinishedException("Sorry it's too late to add actions at this scheduler !");
		}
		
		if(this.isInProgress()) {
			throw new SchedulerInProgressException("Sorry this scheduler is actually in progress then you can't add an action");
		}		
		this.actions.add(action);	
	}
	
	/**
	 * @return the list of actions
	 */
	public Collection<Action> getActions(){
		return this.actions;
	}
	
	
	
	/*
	 * ======================================== ABSTRACT ===================================
	 */

	/**
	 * Remove of the list the action which are finished
	 */
	protected abstract void removeFinishedAction();
	
	
	/**
	 * @return the next action of the list
	 */
	protected abstract Action getNextAction();
	
	
	
}
