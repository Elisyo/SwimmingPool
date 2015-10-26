package pool.manager;
import pool.resource.Cubicle;

/**
 * @author Loic
 *	Manage the Cubicle's type resource
 */
public class CubiclePool extends ResourcePool<Cubicle>{

	/**
	 * @param pool size = number of cubicles
	 */
	public CubiclePool(int n){
		super(n);
		this.poolType="cubicle";
	}

	@Override
	protected Cubicle createResource() {
		return new Cubicle();
	}
}



