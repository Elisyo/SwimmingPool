package pool.exception;

public class ActionFinishedException extends Exception{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Catch an exception when the action is finished and someone try to do step
	 */
	public ActionFinishedException(){
		super();
	}
	
	/**
	 * Catch an exception when the action is finished and someone try to do step
	 * @param error's message
	 */
	public ActionFinishedException(String error){
		super(error);
	}
}
