package pool.action;

import java.util.NoSuchElementException;

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
		try{
			R resourceType = resources.provideResource();
			user.setResource(resourceType);
			System.out.println(user.getName()+" trying to take resource from pool "+resources.getPoolType()+"... success");
			this.isFinished=true;
		}catch(NoSuchElementException e){	
			System.out.println(user.getName()+" trying to take resource from pool "+resources.getPoolType()+"... failed");
			this.isFinished=false;
		}
		
	}

}
