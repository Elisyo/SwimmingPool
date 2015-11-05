package test.action;

import static org.junit.Assert.*;

import org.junit.Test;

import pool.action.Action;
import pool.exception.ActionFinishedException;

public abstract class ActionTest {
	
	protected abstract Action createAction();
	
	@Test(expected = ActionFinishedException.class, timeout = 2000)
	public void doStepWhileFinishedThrowsException() throws ActionFinishedException{
		Action action = createAction();
		while(!action.isFinished()){
			action.doStep();
			action.doStep();
			action.doStep();
		}
		assertTrue(action.isFinished());
	}
	
	

}
