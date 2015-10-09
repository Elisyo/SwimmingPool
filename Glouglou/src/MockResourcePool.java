
public class MockResourcePool extends ResourcePool<MockResource>{

	public MockResourcePool(int numberOfResource) {
		super(numberOfResource);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected MockResource createResource() {
		// TODO Auto-generated method stub
		return new MockResource();
	}


}
