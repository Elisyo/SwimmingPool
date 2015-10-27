package pool.manager;

import pool.resource.Resource;

/**
 * @author Loïc
 *
 * @param <R> resource
 */
public class ResourcefulUser <R extends Resource>{
	protected R resource;
	protected String name;
	
	/**
	 * @param name
	 */
	public ResourcefulUser(String name){
		this.name=name;
	}
	
	/**
	 * @return the resource
	 */
	public R getResource() {
		return resource;
		
	}
	
	/**
	 * @param resource
	 */
	public void setResource(R resource) {
		this.resource = resource;
		
	}
	
	/**
	 * set the resource to null
	 */
	public void resetResource() {
		this.resource = null;
		
	}

	/**
	 * @return the name of the resourceful user
	 */
	public String getName() {
		return this.name;
	}
}
