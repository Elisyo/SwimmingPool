package test.action;

import static org.junit.Assert.*;

import org.junit.Test;

import pool.action.Action;
import pool.action.ForeseeableAction;
import pool.exception.ActionFinishedException;
import test.action.ActionTest;

public class ForeasableActionTest extends ActionTest{

	@Override
	protected Action createAction() {
		// TODO Auto-generated method stub
		return new ForeseeableAction(2);
	}
	
	@Test
	public void foreasableTest() throws ActionFinishedException{
		Action action = new ForeseeableAction(2);
		
		assertTrue(action.isReady());
		assertFalse(action.isFinished());
		assertTrue(action.isInitialized());
		
		action.doStep();
		
		assertFalse(action.isReady());
		assertFalse(action.isFinished());
		assertFalse(action.isInitialized());
		
		action.doStep();
		
		assertTrue(action.isFinished());
		assertFalse(action.isReady());
		assertFalse(action.isInitialized());
	}


}
