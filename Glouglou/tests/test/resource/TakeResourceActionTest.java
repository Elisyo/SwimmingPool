package test.resource;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Test;

import pool.action.ResourcePoolAction;
import pool.action.TakeResourceAction;
import pool.exception.ActionFinishedException;
import pool.manager.ResourcePool;
import pool.manager.ResourcefulUser;
import test.manager.ResourcePoolActionTest;

public class TakeResourceActionTest extends ResourcePoolActionTest{

	@Override
	protected ResourcePoolAction<MockResource> createAction(
			ResourcePool<MockResource> pool, ResourcefulUser<MockResource> user) {
		return new TakeResourceAction<MockResource>(pool, user);
	}
	
	@Test
	public void testTakingResource() throws ActionFinishedException{
		ResourcePoolAction<MockResource> r = createAction();
		
		assertTrue(r.isReady());
		assertFalse(r.isFinished());
		
		r.doStep();
		assertTrue(r.isFinished());
		assertFalse(r.isReady());	
	}
	
	@Test(expected = NoSuchElementException.class, timeout = 2000)
	public void noSuchElementExceptionTest() throws ActionFinishedException{
		ResourcePool<MockResource> mockpool = pool;
		
		mockpool.provideResource();
		mockpool.provideResource();
		mockpool.provideResource();
	}

}
