package pool.action;

import pool.resource.Resource;

public abstract class ResourcePoolAction  <R extends Resource> extends Action {

	@Override
	public boolean isReady() {
		return false;
	}

	@Override
	public boolean isInitialized() {
		return false;
	}

	@Override
	public boolean isFinished() {
		return false;
	}

}
