package pool.exception;

/**
 * @author Loic
 * This exception is launched when someone try to add an action to a scheduler which is in progress
 */
public class SchedulerInProgressException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * Catch an exception when the scheduler is in progress and someone try to add an action
	 */
	public SchedulerInProgressException(){
		super();
	}
	
	/**
	 * Catch an exception when the scheduler is in progress and someone try to add an action
	 * @param error's message
	 */
	public SchedulerInProgressException(String error){
		super(error);
	}

}
