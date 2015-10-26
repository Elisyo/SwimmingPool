package pool.scheduler;


import pool.action.Action;

public class FairScheduler extends Scheduler{

	int index = 0;

	@Override
	public Action getNextAction() {

		Action a = actions.get(index);
		
		while(a.isFinished()){
			index++;
			a = actions.get(index);
		}
			
		if(index == actions.size() -1)
			index = 0;
		else	
			index++;
		
		return a;
	}	

}
