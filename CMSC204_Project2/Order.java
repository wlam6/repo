public class Order 
{
	private int deadline;
	private int arrival;
	private String orderId;
	
	public Order(String orderId, int deadline)
	{
		this.orderId = orderId;
		this.deadline = deadline;
	}
	
	/**
     * Set the arrival minute.
     * @param arrival minute
     */
	public void setArrivalMinute(int minute)
	{
		arrival = minute;
	}
	
	/** Returns the arrival minute. */
	public int getArrivalMinute()
	{
		return arrival;
	}
	
	/** Returns the deadline minute. */
	public int getDeadlineMinute()
	{
		return deadline;
	}
}
