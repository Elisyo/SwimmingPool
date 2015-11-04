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
	public void testWaitingResource() throws ActionFinishedException{
		ResourcePoolAction<MockResource> r = createAction();
		ArrayList<MockResource> allResources = new ArrayList<MockResource>(n);
		for(int i = 0;i<n;i++){
			allResources.add(pool.provideResource());
		}
		
		assertTrue(r.isReady());
		assertFalse(r.isFinished());
		
		r.doStep();
		assertFalse(r.isReady());
		assertFalse(r.isFinished());
		
		r.doStep();
		assertFalse(r.isReady());
		assertFalse(r.isFinished());
		
		pool.freeResource(allResources.get(0));
		
		r.doStep();
		assertFalse(r.isReady());
		assertTrue(r.isFinished());
	}

}
