package pool.action;

/**
 * @author Lo�c
 * Action which need steps to be finished
 * Display each step 
 */
public class ForeseeableAction extends Action{
	protected String name;
	protected int totalTime;
	protected int timeRemaining;
	
	/**
	 * @param name of the action
	 * @param nbSteps of the action
	 */
	public ForeseeableAction(String name,int nbSteps){
		this.name = name;
		this.totalTime=nbSteps;
		this.timeRemaining=totalTime;
	}
	
	/**
	 * @param nbSteps
	 */
	public ForeseeableAction(int nbSteps) {
		this("unknown action",nbSteps);
	}

	@Override
	public boolean isReady(){
		return isInitialized() && !isFinished();
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
		return totalTime==timeRemaining;
	}
	

	/**
	 * @return the name of the action
	 */
	public String getName() {
		return name;
	}


}
