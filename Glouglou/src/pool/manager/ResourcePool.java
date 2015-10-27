package pool.manager;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import pool.resource.Resource;


/**
 * @author Loïc
 * Manage all the resources
 * @param <R> resource
 */
public abstract class ResourcePool <R extends Resource> {

	private List<R> poolFree;
	private List<R> poolUsed;
	protected String poolType;

	/**
	 * Add the n resources to the poolFree
	 * @param n : number of resources
	 */
	public ResourcePool(int n){
		this.poolFree= new ArrayList<R>(n);
		this.poolUsed = new ArrayList<R>(n);
		for(int i=0;i<n;i++){
			poolFree.add(createResource());
		}
	}
	
	/**
	 * Remove the resource to the free pool and add it to the used pool
	 * @return a free resource
	 * @throws NoSuchElementException
	 */
	public R provideResource()throws NoSuchElementException{
		if(this.poolFree.isEmpty()){
			throw new NoSuchElementException("No resource available");
		}
		R r = poolFree.get(0);
		poolFree.remove(0);
		poolUsed.add(r);
		return r;
	}
	

	/**
	 * Free the resource which is in parameter and remove it to the used pool and add it to the free pool
	 * @param r
	 */
	public void freeResource(R r){
		int indexResourceUsed=this.poolUsed.indexOf(r);
		if(indexResourceUsed!=-1){
			this.poolUsed.remove(indexResourceUsed);
			this.poolFree.add(r);
		}else{
			throw new IllegalArgumentException();
		}
	}
	
	/**
	 * @return the type of the pool
	 */
	public String getPoolType() {
		return poolType;
	}
	
	/**
	 * @return a new resource Cubicle/Basket
	 */
	protected abstract R createResource();
	
}
