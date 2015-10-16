package pool.action;

public class SwimmingAction extends ForeseeableAction{
	protected int totalTime;
	protected int timeRemaining;
	
	public SwimmingAction(int totalTime){
		this.totalTime = totalTime;
		timeRemaining = totalTime;
	}
	
	@Override
	public boolean isReady(){
		return totalTime==timeRemaining;
	}
	
	@Override
	public boolean isFinished(){
		return timeRemaining==0;
	}
	
	@Override
	public boolean isInProgress(){
		return timeRemaining < totalTime;
	}
	
	@Override
	public void reallyDoStep(){
		if(!isFinished())
			timeRemaining--;
	}
}

//need to do in foreseebleAction