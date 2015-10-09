
/**
 * @author Loic
 *	Manage the Basket's type resource
 */
public class BasketPool extends ResourcePool<Basket>{

	/**
	 * @param pool size
	 */
	public BasketPool(int n){
		super(n);
	}

	@Override
	protected Basket createResource() {
		// TODO Auto-generated method stub
		return new Basket();
	}
	
}
