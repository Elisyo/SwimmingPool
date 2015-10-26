package pool.scheduler;

import pool.action.Action;

public class SequentialScheduler extends Scheduler{

	protected String name;

	int index =0;
	@Override
	protected Action getNextAction() {
		System.out.println(name+"'s turn");
		return this.actions.get(0);
	}

}
