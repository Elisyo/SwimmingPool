package test.scheduler;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import pool.action.Action;
import pool.exception.ActionFinishedException;
import pool.exception.SchedulerInProgressException;
import pool.scheduler.FairScheduler;
import pool.scheduler.Scheduler;
import test.action.OneStepAction;
import test.action.TwoStepAction;

/**
 * @author fguilbert
 *
 */
public class FairSchedulerTest extends SchedulerTest {

	private FairScheduler s;

	@Before
	public void initialize() {
		this.s = new FairScheduler();
	}

	@Test
	public void getNextActionTest() throws ActionFinishedException, SchedulerInProgressException {
		Action a1 = new OneStepAction();
		s.addAction(a1);
		assertEquals(a1, s.getNextAction());
	}

	@Test
	public void removeFinishedActionTest() throws ActionFinishedException, SchedulerInProgressException {
		Action a1 = new OneStepAction();
		s.addAction(a1);
		Action a2 = new OneStepAction();
		s.addAction(a2);
		assertTrue(a1.isReady());
		assertTrue(a2.isReady());
		
		s.doStep();
		
		assertTrue(a1.isFinished());
		assertFalse(a2.isFinished());
		assertFalse(s.isFinished());
		assertFalse(s.getActions().isEmpty());
		
		s.doStep();
		
		assertTrue(a2.isFinished());
		assertTrue(s.getActions().isEmpty());
		assertTrue(s.isFinished());
	}
	
	@Test
	public void actionHasNext() throws ActionFinishedException, SchedulerInProgressException{
		Action a1 = new TwoStepAction();
		s.addAction(a1);
		Action a2 = new TwoStepAction();
		s.addAction(a2);
		s.doStep();
		s.doStep();
		assertEquals(a1,s.getNextAction());
	}

	@Override
	protected Scheduler createScheduler() {
		return new FairScheduler();
	}

}
