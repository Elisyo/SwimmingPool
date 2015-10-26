package pool.manager;

import pool.resource.Basket;

/**
 * @author Loic
 *	Manage the Basket's type resource
 */
public class BasketPool extends ResourcePool<Basket>{

	/**
	 * @param pool size = number of baskets
	 */
	public BasketPool(int n){
		super(n);
		this.poolType="basket";
	}

	@Override
	protected Basket createResource() {
		// TODO Auto-generated method stub
		return new Basket();
	}
	
}
