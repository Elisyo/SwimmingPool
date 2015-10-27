package pool.scheduler;


import java.util.Iterator;
import pool.action.Action;

/**
 * @author Loïc
 * Scheduler which iterates on the list of actions
 */
public class FairScheduler extends Scheduler{

	protected Iterator<Action> iterator;


	@Override
	public Action getNextAction() {
	
		if(this.iterator == null) {
			this.iterator = actions.iterator();
		}
		
		if(!this.iterator.hasNext()) {
			this.iterator = actions.iterator();
		}
		return iterator.next();
	}

	@Override
	protected void removeFinishedAction() {
		this.iterator.remove();
		
	}	

}
