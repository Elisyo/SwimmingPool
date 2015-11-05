package pool.action;


import pool.manager.ResourcePool;
import pool.manager.ResourcefulUser;
import pool.resource.Resource;

/**
 * @author Lo�c
 * Abstract class to manage the actions states
 * @param <R> resource
 */
public abstract class ResourcePoolAction<R extends Resource> extends Action {

	protected boolean isReady;
	protected boolean isFinished;
	

	protected ResourcePool<R> resources;
	protected ResourcefulUser<R> user;
	
	public ResourcePoolAction(ResourcePool<R> pool, ResourcefulUser<R> user){
		this.resources=pool;
		this.user=user;
		this.isReady = true;
		this.isFinished = false;
	}
	

	@Override
	public boolean isReady() {
		return isReady;
	}

	@Override
	public boolean isInitialized() {
		return true;
	}

	@Override
	public boolean isFinished() {
		return isFinished;
	}

}
