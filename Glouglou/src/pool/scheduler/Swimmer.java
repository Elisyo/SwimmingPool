package pool.scheduler;

import pool.action.ForeseeableAction;
import pool.action.FreeResourceAction;
import pool.action.TakeResourceAction;
import pool.manager.BasketPool;
import pool.manager.CubiclePool;
import pool.manager.ResourcefulUser;
import pool.resource.Basket;
import pool.resource.Cubicle;

/**
 * @author loic
 * Entity which make all actions in param
 */
public class Swimmer extends SequentialScheduler{

	private ResourcefulUser<Basket> basketUser ;
	private ResourcefulUser<Cubicle> cubicleUser;
	private String name;

	/**
	 * Create all the actions with the time
	 * @param name
	 * @param basketPool
	 * @param cubiclePool
	 * @param undressingTime
	 * @param swimmingTime
	 * @param dressingTime
	 */
	public Swimmer(String name, BasketPool basketPool, CubiclePool cubiclePool,int undressingTime, int swimmingTime, int dressingTime) {
		this.name=name;
		//initialize resourcefulUser
		this.basketUser=new ResourcefulUser<Basket>();
		this.cubicleUser=new ResourcefulUser<Cubicle>();
		//initialize the actions
		initializeActions(basketPool, cubiclePool, undressingTime, swimmingTime, dressingTime);

	}
	
	
	/**
	 * Initialize all the actions associated to a swimmer and add them to the list of actions
	 * @param basketPool
	 * @param cubiclePool
	 * @param undressingTime
	 * @param swimmingTime
	 * @param dressingTime
	 */
	private void initializeActions(BasketPool basketPool, CubiclePool cubiclePool, int undressingTime, int swimmingTime, int dressingTime) {
		this.addAction(new TakeResourceAction<Basket>(basketPool, basketUser));
		this.addAction(new TakeResourceAction<Cubicle>(cubiclePool, cubicleUser));
		this.addAction(new ForeseeableAction("undressing",undressingTime));
		this.addAction(new FreeResourceAction<Cubicle>(cubiclePool, cubicleUser));
		this.addAction(new ForeseeableAction("swimming",swimmingTime));
		this.addAction(new TakeResourceAction<Cubicle>(cubiclePool, cubicleUser));
		this.addAction(new ForeseeableAction("dressing",dressingTime));
		this.addAction(new FreeResourceAction<Cubicle>(cubiclePool, cubicleUser));
		this.addAction(new FreeResourceAction<Basket>(basketPool, basketUser));
		
	
	}

	/**
	 * @return the name of the swimmer
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name of the swimmer
	 */
	public void setName(String name) {
		this.name = name;
	}

}
