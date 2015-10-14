package pool.scheduler;

import pool.manager.BasketPool;
import pool.manager.CubiclePool;

/**
 * @author loic
 * Entity which make all actions in param
 */
public class Swimmer extends SequentialScheduler{


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
		//instanciate the action

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
