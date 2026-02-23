/**
 * Represents a simple time-driven simulation.
 */
public class WarehouseSimulation implements SimulationInterface
{
	private MyStack<Order> returnsStack;
	private MyPriorityQueue<Order> queue;
	private OrderComparator comparator = new OrderComparator();
	private Order[] orders;
	// The simulation starts at minute 0.
	private int minute = 0;
	private int shipped = 0;
	private int arrived = 0;
	
	public WarehouseSimulation(Order[] orders)
	{
		this.orders = orders;
		returnsStack = new MyStack<Order>(orders.length);
		queue = new MyPriorityQueue<Order>(orders.length, comparator);
	}
	
	/**
     * Advance the simulation by exactly one minute.
     * This may involve:
     *  - Adding new orders to the queue
     *  - Shipping one order
     *  - Moving late orders to the returns stack
	 * @throws IllegalStateException 
	 * @throws IllegalArgumentException 
     */
	@Override
	public void tick()
	{
		// A single order is released into the system and stamped with the current minute as its arrival time.
		orders[arrived].setArrivalMinute(minute);
		queue.enqueue(orders[arrived]);
		arrived++;
		
		// The highest-priority order is shipped.
		Order order = queue.dequeue();
		shipped++;
			
		// If shipped after its deadline, the order is added to the returns stack.
		if (minute > order.getDeadlineMinute())
		{
			returnsStack.push(order);
		}

		
		// Every minute:
		minute++;
	}

	/**
     * Returns true if:
     *  - All orders have been released into the queue, AND
     *  - The queue is empty (all orders shipped).
     */
	@Override
	public boolean isFinished() 
	{
		return (orders.length == arrived) && queue.isEmpty();
	}

	/** Returns the current simulation time in minutes. */
	@Override
	public int getCurrentMinute() 
	{
		return minute;
	}

	/** Returns the total number of orders that have arrived. */
	@Override
	public int getTotalArrived() 
	{
		return arrived;
	}

	/** Returns the total number of orders that have been shipped. */
	@Override
	public int getTotalShipped() 
	{
		return shipped;
	}

	/** Returns the total number of orders that shipped late. */
	@Override
	public int getTotalLate() 
	{
		return returnsStack.size();
	}

}
