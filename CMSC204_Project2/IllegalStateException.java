public class IllegalStateException extends RuntimeException
{
	public IllegalStateException()
	{
		super("PriorityQueue is full");
	}
	public IllegalStateException(String message)
	{
		super(message);
	}
}