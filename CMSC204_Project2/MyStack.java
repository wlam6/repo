import java.util.NoSuchElementException;

/**
 * Generic LIFO (last-in-first-out) stack interface.
 * Maximum number of elements allowed is 1000 and a default size of 10 if the size is 
 * not declared.
 * 
 * @param <T> the type of elements stored in the stack
 */
public class MyStack<T> implements StackADT<T>
{
	private T[] stack;
	private static final int MAX_CAPACITY = 1000; // Hard limit for this stack
	private static final int DEFAULT_CAPACITY = 10;
	private int topIndex;
	
	public MyStack()
	{
		this(DEFAULT_CAPACITY);
	}
	
	public MyStack(int capacity)
	{
		T[] array =  (T[]) new Object[capacity];
		stack = array;
		// No items, no starting index
		topIndex = -1;
	}
	
	/**
     * Pushes an item onto the top of the stack.
     * @param item the element to push 
     * @throws IllegalArgumentException if item is null 
     * @throws IllegalStateException if stack has reached max capacity
     */
	@Override
	public void push(T item)
	{
		if (item == null)
		{
			throw new IllegalArgumentException();
		}
		if (size() >= MAX_CAPACITY)
		{
			throw new IllegalStateException();
		}
		stack[topIndex + 1] = item;
		topIndex++;
	}

	/**
     * Removes and returns the top item from the stack.
     * @return the popped element
     * @throws NoSuchElementException if the stack is empty
     */
	@Override
	public T pop()
	{
		if (isEmpty())
		{
			throw new NoSuchElementException();
		}
		T topItem = stack[topIndex];
		stack[topIndex] = null;
		topIndex--;
		return topItem;
	}

	/**
     * Returns the top item of the stack without removing.
     * @return the top element
     * @throws NoSuchElementException if the stack is empty
     */
	@Override
	public T peek() 
	{
		if (isEmpty())
		{
			throw new NoSuchElementException();
		}
		return stack[topIndex];
	}

	/**
     * Checks whether the stack is empty.
     * @return true if the stack has no elements, false otherwise
     */
	@Override
	public boolean isEmpty() 
	{
		return topIndex == -1;
	}

	/**
     * Returns the current number of elements in the stack.
     * @return number of elements
     */
	@Override
	public int size() 
	{
		if (isEmpty())
		{
			return 0;
		}
		return topIndex + 1;
	}

	/**
     * Returns an array containing all elements in this stack.
     * The element at index 0 is the bottom of the stack, and the
     * element at index size()-1 is the top.
     */
	@Override
	public Object[] toArray() 
	{
		return stack;
	}

}
