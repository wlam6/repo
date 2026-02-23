public class IllegalArgumentException extends RuntimeException
{
	public IllegalArgumentException()
	{
		super("Provided item is null");
	}
	public IllegalArgumentException(String message)
	{
		super(message);
	}
}
