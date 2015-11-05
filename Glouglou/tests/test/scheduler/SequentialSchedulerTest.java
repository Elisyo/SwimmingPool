package test.scheduler;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import pool.action.Action;
import pool.exception.ActionFinishedException;
import pool.exception.SchedulerInProgressException;
import pool.scheduler.SequentialScheduler;
import test.action.OneStepAction;


public class SequentialSchedulerTest extends SchedulerTest{

	private SequentialScheduler s;
	
	@Before
	public void initialize(){
		this.s=new SequentialScheduler();
	}
	
	@Test
	public void getNextActionTest() throws ActionFinishedException, SchedulerInProgressException{
		Action a1 = new OneStepAction();
		s.addAction(a1);
		assertEquals(a1,s.getNextAction());
	}

	@Test
	public void removeFinishedActionTest() throws ActionFinishedException, SchedulerInProgressException{
		Action a1 = new OneStepAction();
		s.addAction(a1);
		s.doStep();
		assertTrue(s.getActions().isEmpty());
		
	}
	
}
