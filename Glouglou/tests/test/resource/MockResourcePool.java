package test.resource;

import pool.manager.ResourcePool;

public class MockResourcePool extends ResourcePool<MockResource>{

	public MockResourcePool(int n) {
		super(n); // n = numberOfResources
	}

	@Override
	protected MockResource createResource() {
		return new MockResource();
	}

}
