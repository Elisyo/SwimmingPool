package pool.action;


import pool.resource.Resource;

public abstract class ResourcePoolAction<R extends Resource> extends Action {

	protected boolean isReady;
	protected boolean isFinished;
	

	@Override
	public boolean isReady() {
		return isReady;
	}

	@Override
	public boolean isInitialized() {
		return true;
	}

	@Override
	public boolean isFinished() {
		return isFinished;
	}

}
