import java.util.Comparator;

public class OrderComparator implements Comparator<Order>
{
	/** Compares to see which two deadlines is earlier/later.*/
	@Override
	public int compare(Order o1, Order o2) 
	{
		// If deadlines tie, earlier arrival goes first
		if (o1.getDeadlineMinute() == o2.getDeadlineMinute())
		{
			return o1.getArrivalMinute() - o2.getArrivalMinute();
		}
		return o1.getDeadlineMinute() - o2.getDeadlineMinute();
	}
}
