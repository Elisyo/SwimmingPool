package pool.manager;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import pool.resource.Resource;


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
	
	public R provideResource()throws NoSuchElementException{
		if(this.poolFree.isEmpty()){
			throw new NoSuchElementException("No ressource available");
		}
		R r = poolFree.get(0);
		poolFree.remove(0);
		poolUsed.add(r);
		return r;
	}
	

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
