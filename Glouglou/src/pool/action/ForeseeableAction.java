package pool.action;

public class ForeseeableAction extends Action{
	protected String name;
	protected int totalTime;
	protected int timeRemaining;
	
	public ForeseeableAction(String name,int nbSteps){
		this.name = name;
		this.totalTime=nbSteps;
		this.timeRemaining=totalTime;
	}
	
	public ForeseeableAction(int nbSteps) {
		this(null,nbSteps);
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
		timeRemaining--;
		System.out.println(name+" ("+(totalTime-timeRemaining)+"/"+totalTime+")");
	}

	@Override
	public boolean isInitialized() {
		return true;
	}
	

	/**
	 * @return the name of the action
	 */
	public String getName() {
		return name;
	}


}
