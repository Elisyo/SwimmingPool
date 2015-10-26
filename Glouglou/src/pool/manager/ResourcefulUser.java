package pool.manager;

import pool.resource.Resource;

public class ResourcefulUser <R extends Resource>{
	protected R resource;
	protected String name;
	
	public ResourcefulUser(String name){
		this.name=name;
	}
	
	public R getResource() {
		return resource;
		
	}
	
	public void setResource(R resource) {
		this.resource = resource;
		
	}
	
	public void resetResource() {
		this.resource = null;
		
	}

	public String getName() {
		return this.name;
	}
}
