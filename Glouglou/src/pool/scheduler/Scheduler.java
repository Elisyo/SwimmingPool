package pool.scheduler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import pool.action.Action;
import pool.exception.ActionFinishedException;

/**
 * @author loic
 * A simple scheduler of actions
 * A scheduler is an action
 */
public abstract class Scheduler extends Action{
	
	protected List<Action> actions = new ArrayList<Action>();
	protected boolean isReady=true;
	protected boolean isInitialized=true;

	@Override
	protected boolean isInProgress(){
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
		return(actions.isEmpty() && !(isReady())&&(isInitialized()));
	}
	
	@Override
	public void reallyDoStep() {
		Action nextAction = getNextAction();
		try {
			nextAction.doStep();
		} catch (ActionFinishedException e) {
			e.printStackTrace();
		}
		if(nextAction.isFinished())
			removeFinishedAction();
		
	}
	
	/**
	 * Add an action to list of actions
	 * @param action
	 */
	public void addAction(Action action) throws ActionFinishedException {
		if(this.isFinished()) {
			throw new ActionFinishedException("Sorry it's too late to add actions at this scheduler !");
		}
		
		if(this.isInProgress()) {
			throw new ActionFinishedException("Sorry this scheduler is actually in progress then you can't add an action");
		}		
		this.actions.add(action);	
	}
	
	/**
	 * @return the list of actions
	 */
	protected Collection<Action> getActions(){
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
