package pool.action;

import pool.resource.Resource;

public abstract class ResourcePoolAction  <R extends Resource> extends Action {

	@Override
	public boolean isReady() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isInitialized() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void reallyDoStep() {
		// TODO Auto-generated method stub
		
	}

}
