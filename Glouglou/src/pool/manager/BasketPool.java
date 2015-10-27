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
	}

	@Override
	protected Basket createResource() {
		Basket basket=new Basket();
		this.poolType=basket.description();
		return basket;
	}
	
}
