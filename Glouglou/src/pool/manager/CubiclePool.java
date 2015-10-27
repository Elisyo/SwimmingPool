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
	}

	@Override
	protected Cubicle createResource() {
		Cubicle cubicle= new Cubicle();
		this.poolType=cubicle.description();
		return cubicle;
	}
}



