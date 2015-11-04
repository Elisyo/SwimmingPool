package test.resource;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import pool.action.FreeResourceAction;
import pool.action.ResourcePoolAction;
import pool.exception.ActionFinishedException;
import pool.manager.ResourcePool;
import pool.manager.ResourcefulUser;
import test.manager.ResourcePoolActionTest;

public class FreeResourceTest extends ResourcePoolActionTest{

	@Override
	protected ResourcePoolAction<MockResource> createAction(
			ResourcePool<MockResource> pool, ResourcefulUser<MockResource> user) {
		return new FreeResourceAction<MockResource>(pool, user);
	}
	
	@Test
	public void freeResourceTest() throws ActionFinishedException{
		ResourcePoolAction<MockResource> r = (ResourcePoolAction<MockResource>) createAction();
		ArrayList<MockResource> allResources = new ArrayList<MockResource>(n);
		for(int i = 0;i<n;i++){
			allResources.add(pool.provideResource());
		}
		
		r.doStep();
		
		pool.freeResource(allResources.get(0));
		allResources.remove(0);
		
		r.doStep();
		pool.freeResource(allResources.get(0));
		allResources.remove(0);
		
		assertTrue(allResources.isEmpty());
	}

}
