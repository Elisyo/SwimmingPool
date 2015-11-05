package pool.action;

import pool.manager.ResourcePool;
import pool.manager.ResourcefulUser;
import pool.resource.Resource;

/**
 * @author Lo�c
 * When a user has finished a TakeResourceAction, he has to free it
 * @param <R> ressource
 */
public class FreeResourceAction <R extends Resource> extends ResourcePoolAction<R>{
	
	/**
	 * @param pool
	 * @param user
	 */
	public FreeResourceAction (ResourcePool<R> pool, ResourcefulUser<R> user){
		super(pool,user);
	}
	
	@Override
	public void reallyDoStep() {
		this.isReady=false;
		R resourceType = user.getResource();
		resources.freeResource(resourceType);
		user.resetResource();
		System.out.println(user.getName()+" freeing resource from pool "+resources.getPoolType());
		this.isFinished = true;
	}
}
