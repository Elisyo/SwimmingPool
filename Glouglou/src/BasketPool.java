
public class BasketPool extends ResourcePool<Basket>{

	public BasketPool(int n){
		super(n);
	}

	@Override
	protected Basket createResource() {
		// TODO Auto-generated method stub
		return newBasket();
	}
	
}
