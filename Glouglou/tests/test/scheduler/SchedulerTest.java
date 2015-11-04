package test.scheduler;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import pool.action.Action;
import pool.exception.ActionFinishedException;
import pool.exception.SchedulerInProgressException;
import pool.scheduler.Scheduler;

import test.action.OneStepAction;

public class SchedulerTest{
	
	protected Scheduler s;
	
	
	@Before
	public void instantiateMockScheduler(){
		s = new MockScheduler();
	}
	
	@Test
	public void schedulerInitializationTest(){	
		assertTrue(s.isInitialized());
		assertTrue(s.isReady());
		assertFalse(s.isFinished());
	}
	
	@Test(expected=ActionFinishedException.class)
	public void addActionToFinishedSchedulerTest()throws ActionFinishedException, SchedulerInProgressException{
		Action sampleAction1 = new OneStepAction();
		s.addAction(sampleAction1);
		sampleAction1.doStep();
		assertTrue(sampleAction1.isFinished());
		System.out.println(s.actions.get(0).isFinished());
		assertTrue(s.isFinished());
		Action sampleAction2 = new OneStepAction();
		s.addAction(sampleAction2);
	}

	@Test(expected=SchedulerInProgressException.class)
	public void addActionToSchedulerInProgressTest()throws ActionFinishedException, SchedulerInProgressException{
		Action sampleAction1 = new OneStepAction();
		Action sampleAction2 = new OneStepAction();
		Action sampleAction3 = new OneStepAction();
		s.addAction(sampleAction1);
		s.addAction(sampleAction2);
		sampleAction1.doStep();
		assertTrue(s.isInProgress());
		s.addAction(sampleAction3);
		
	}

}
