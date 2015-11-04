package test.resource;

import pool.resource.Resource;

public class MockResource implements Resource{
	@Override
	public String description(){
		return "mock resource";
	}
}
