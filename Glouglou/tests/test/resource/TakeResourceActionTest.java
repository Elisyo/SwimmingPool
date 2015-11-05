package test.resource;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import pool.action.ResourcePoolAction;
import pool.action.TakeResourceAction;
import pool.exception.ActionFinishedException;
import pool.manager.ResourcePool;
import pool.manager.ResourcefulUser;
import pool.resource.Resource;
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

}
