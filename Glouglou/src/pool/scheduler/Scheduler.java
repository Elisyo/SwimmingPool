package pool.scheduler;

import java.util.Collection;

import pool.action.Action;
import pool.exception.ActionFinishedException;

/**
 * @author loic
 * A simple scheduler of actions
 */
public abstract class Scheduler extends Action{
	
	protected boolean isReady;
	protected boolean isInitialized;
	
	@Override
	protected boolean isInProgress(){
		return isInitialized() && super.isInProgress();
	}
	
	@Override
	public boolean isReady() {
		return (isReady() && isInitialized());
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
		return(getAction().isEmpty() && !(isReady)&&(isInitialized()));
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
	
	/*
	 * ======================================== ABSTRACT ===================================
	 */
	
	/**
	 * Add an action to list of actions
	 * @param action
	 */
	protected abstract void addAction(Action action);
	
	/**
	 * Remove of the list the action which are finished
	 */
	protected abstract void removeFinishedAction();
	
	/**
	 * @return the next action of the list
	 */
	protected abstract Action getNextAction();
	
	/**
	 * @return the list of actions
	 */
	protected abstract Collection<Action> getAction();
	
}
