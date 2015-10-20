package pool.action;

public class ForeseeableAction extends Action{
	protected String name;
	protected int totalTime;
	protected int timeRemaining;
	
	public ForeseeableAction(String name,int nbSteps){
		this.name = name;
		this.totalTime=nbSteps;
	}
	
	public ForeseeableAction(int nbSteps) {
		this.totalTime=nbSteps;
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
	public void reallyDoStep(){
		if(!isFinished())
			timeRemaining--;
	}

	@Override
	public boolean isInitialized() {
		// TODO Auto-generated method stub
		return false;
	}

}
