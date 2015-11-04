package test.scheduler;

import pool.action.Action;
import pool.scheduler.Scheduler;

/**
 * @author Loic
 * A sample scheduler without any actions
 */
public class MockScheduler extends Scheduler {
	
	public MockScheduler(){
	}

	@Override
	protected void removeFinishedAction() {
		for(Action action: actions){
			if(action.isFinished())
				actions.remove(action);
		}
	}

	@Override
	protected Action getNextAction() {
		return actions.get(0);
	}

}
