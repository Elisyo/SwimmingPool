package test.scheduler;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import pool.action.Action;
import pool.exception.ActionFinishedException;
import pool.exception.SchedulerInProgressException;
import pool.scheduler.Scheduler;
import pool.scheduler.SequentialScheduler;

import test.action.OneStepAction;

/**
 * @author fguilbert
 *
 */
public class SchedulerTest{
	
	protected Scheduler s;
	
	
	@Before
	public void instantiateMockScheduler(){
		s = new SequentialScheduler();
	}
	
	@Test
	public void schedulerInitializationTest(){	
		assertTrue(s.isInitialized());
		assertTrue(s.isReady());
		assertFalse(s.isFinished());
	}
	
	@Test(expected=ActionFinishedException.class)
	public void addActionToFinishedSchedulerTest()throws  SchedulerInProgressException, ActionFinishedException{
		Action sampleAction1 = new OneStepAction();
		s.addAction(sampleAction1);
		System.out.println("yo");
		s.doStep();
		System.out.println("ya");
		assertTrue(sampleAction1.isFinished());
		System.out.println(sampleAction1.isFinished());
		System.out.println(s.isFinished());
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
		s.doStep();
		assertTrue(s.isInProgress());
		s.addAction(sampleAction3);
		
	}

}
