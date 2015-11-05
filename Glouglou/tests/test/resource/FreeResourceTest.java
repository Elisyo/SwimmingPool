package test.resource;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import pool.action.FreeResourceAction;
import pool.action.ResourcePoolAction;
import pool.action.TakeResourceAction;
import pool.exception.ActionFinishedException;
import pool.manager.ResourcePool;
import pool.manager.ResourcefulUser;
import test.manager.ResourcePoolActionTest;

public class FreeResourceTest extends ResourcePoolActionTest{

	@Override
	protected ResourcePoolAction<MockResource> createAction(
			ResourcePool<MockResource> pool, ResourcefulUser<MockResource> user) {
		
		user.setResource(new MockResource());
		FreeResourceAction<MockResource> r = new FreeResourceAction<MockResource>(pool, user);
		return r;
	}
	
	@Test
	public void freeResourceTest() throws ActionFinishedException{
		ResourcePoolAction<MockResource> free = createAction();
		ResourcePoolAction<MockResource> take = new TakeResourceAction<MockResource>(pool, user);
		
		take.doStep();
				
		assertTrue(free.isReady());
		assertFalse(free.isFinished());
		
		free.doStep();
		
		assertFalse(free.isReady());
		assertTrue(free.isFinished());
	}

}
