package pool.scheduler;

import pool.action.Action;

/**
 * @author Lo�c
 * Scheduler which always take the first element of the list of actions and remove it when the actions is finished
 * This scheduler pass in the next action only if the the previous is finished
 */
public class SequentialScheduler extends Scheduler{

	protected String name;

	@Override
	public Action getNextAction() {
		System.out.println(name+"'s turn");
		return this.actions.get(0);
	}

	@Override
	public void removeFinishedAction() {
		this.actions.remove(0);
		
	}

}
