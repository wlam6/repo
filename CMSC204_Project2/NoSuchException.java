public class NoSuchException extends RuntimeException
{
	public NoSuchException()
	{
		super("PriorityQueue is empty");
	}
	public NoSuchException(String message)
	{
		super(message);
	}
}