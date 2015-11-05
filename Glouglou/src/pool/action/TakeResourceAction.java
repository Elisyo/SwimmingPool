package pool.action;

import java.util.NoSuchElementException;

import pool.manager.ResourcePool;
import pool.manager.ResourcefulUser;
import pool.resource.Resource;

/**
 * @author Lo�c
 * When a user try to take a resource in a pool
 * @param <R> resource
 */
public class TakeResourceAction <R extends Resource> extends ResourcePoolAction<R> {


	/**
	 * @param pool
	 * @param user
	 */
	public TakeResourceAction(ResourcePool<R> pool, ResourcefulUser<R> user) {
		super(pool,user);
	}
	
	
	@Override
	public void reallyDoStep() {
		try{
			R resourceType = resources.provideResource();
			user.setResource(resourceType);
			System.out.println(user.getName()+" trying to take resource from pool "+resources.getPoolType()+"... success");
			isFinished=true;
			System.out.println(isFinished);
			isReady = false;
		}catch(NoSuchElementException e){	
			System.out.println(user.getName()+" trying to take resource from pool "+resources.getPoolType()+"... failed");
			super.isFinished=false;
		}
		
	}

}
