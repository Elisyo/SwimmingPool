package test.manager;

import pool.action.ResourcePoolAction;
import pool.manager.ResourcePool;
import pool.manager.ResourcefulUser;
import test.action.ActionTest;
import test.resource.MockResource;
import test.resource.MockResourcePool;

public abstract class ResourcePoolActionTest extends ActionTest {

	protected int n = 2;
	protected MockResourcePool pool = new MockResourcePool(n);
	protected ResourcefulUser<MockResource> user = new ResourcefulUser<MockResource>(
			"user");

	@Override
	protected ResourcePoolAction<MockResource> createAction() {
		return createAction(pool, user);
	}

	protected abstract ResourcePoolAction<MockResource> createAction(
			ResourcePool<MockResource> pool, ResourcefulUser<MockResource> user);

}
