import java.util.Comparator;
import java.util.NoSuchElementException;

/**
 * Generic priority queue interface.
 * Implementations must insert elements in priority order according to
 * a provided Comparator.
 * The Maximum Capacity is 1000 and the default capacity is 10
 * 
 * @param <T> the type of elements stored in the priority queue
 */
public class MyPriorityQueue<T> implements PriorityQueueADT<T>
{
	private T[] queue;
	private Comparator<T> comparator;
	private final static int MAX_CAPACITY = 1000;
	private static final int DEFAULT_CAPACITY = 10;
	private int size;
	
	public MyPriorityQueue(Comparator<T> comparator)
	{
		this(DEFAULT_CAPACITY, comparator);
	}
	
	public MyPriorityQueue(int capacity, Comparator<T> comparator)
	{
		T[] array =  (T[]) new Object[capacity + 1];
		this.comparator = comparator;
		queue = array;
		size = 0;
	}
	
	/**
     * Inserts an item into the queue according to the priority order.
     * @param item the element to insert (cannot be null)
     * @throws IllegalArgumentException if item is null
     * @throws IllegalStateException if full
     */
	@Override
	public void enqueue(T item)
	{
		if (item == null)
		{
			throw new IllegalArgumentException();
		}
		// updated enqueue to also throw IllegalStateException to satisfy JUnit tests
		if (size() >= DEFAULT_CAPACITY)
		{
			throw new IllegalStateException();
		}
		
		// Insert item at correct position according to priority order
		queue[size] = item;
		size++;
	}

	/**
     * Removes and returns the highest-priority item.
     * @return the dequeued element
     * @throws NoSuchElementException if the queue is empty
     */
	@Override
	public T dequeue() 
	{
		if (isEmpty())
		{
			throw new NoSuchElementException();
		}
		
		// Search for the highest-priority item then remove it
		T highest = queue[0];
		int highestIndex = 0;
		for (int i = 1; i < size; i++)
		{
			if (queue[i] != null && comparator.compare(queue[i], highest) < 0)
			{
				highest = queue[i];
				highestIndex = i;
			}
		}
		queue[highestIndex] = null;
		size--;
		return highest;
	}

	/**
     * Returns (without removing) the highest-priority item.
     * @return the front element
     * @throws NoSuchElementException if the queue is empty
     */
	@Override
	public T peek() 
	{
		if (isEmpty())
		{
			throw new NoSuchElementException();
		}
		return queue[size - 1];
	}

	/**
     * Checks whether the queue has no elements.
     * @return true if empty, false otherwise
     */
	@Override
	public boolean isEmpty() 
	{
		return size == 0;
	}

	/**
     * Returns the current number of elements in the queue.
     * @return number of elements
     */
	@Override
	public int size() 
	{
		return size;
	}
	/**
     * Returns an array containing all elements in this priority queue,
     * in the current internal order (not necessarily sorted by priority).
     */
	@Override
	public Object[] toArray() 
	{
		return queue;
	}

}
