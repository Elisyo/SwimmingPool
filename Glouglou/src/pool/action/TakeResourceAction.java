package pool.action;

import pool.manager.ResourcePool;
import pool.manager.ResourcefulUser;
import pool.resource.Resource;

public class TakeResourceAction <R extends Resource> extends ResourcePoolAction<Resource> {

	private ResourcePool<R> resources;
	private ResourcefulUser<R> user;
	
	public TakeResourceAction(ResourcePool<R> pool, ResourcefulUser<R> user) {
		this.resources=pool;
		this.user=user;
	}
	
	
	@Override
	public void reallyDoStep() {
		R resourceType = resources.provideResource();
		user.setResource(resourceType);
	}

}
