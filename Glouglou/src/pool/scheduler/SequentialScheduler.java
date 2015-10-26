package pool.scheduler;

import pool.action.Action;

public class SequentialScheduler extends Scheduler{

	protected String name;

	@Override
	protected Action getNextAction() {
		System.out.println(name+"'s turn");
		return this.actions.get(0);
	}

	@Override
	protected void removeFinishedAction() {
		this.actions.remove(0);
		
	}

}
