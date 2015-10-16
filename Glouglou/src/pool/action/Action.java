package pool.action;

import java.util.ArrayList;
import java.util.List;

import pool.exception.ActionFinishedException;

/**
 * @author Loic
 * Defines the differents states of an action
 */
public abstract class Action {
	
	
	/**
	 * @return if the action is in progress or not
	 */
	protected boolean isInProgress(){
		return !isReady()&&!isFinished();
	}
	
	
	/**
	 * Launch an action step and verify if the action isn't finished 
	 * @throws ActionFinishedException 
	 */
	public void doStep() throws ActionFinishedException{
		if(!isFinished())
			reallyDoStep();
		else
			throw new ActionFinishedException("Can't do more step");

	}
	
	/**
	 * the list of actions
	 */
	protected List<ForeseeableAction> listActions = new ArrayList<>();
	
	/*
	 * ======================================== ABSTRACT ===================================
	 */
	
	/**
	 * @return if the action is ready (initialize and not finished)
	 */
	public abstract boolean isReady();
	
	/**
	 * @return if the action is initialized
	 */
	public abstract boolean isInitialized();
	
	
	/**
	 * @return if the action is finished (not ready)
	 */
	public abstract boolean isFinished();
	
	
	/**
	 * launch one step of the action
	 */
	public abstract void reallyDoStep();
	
}
