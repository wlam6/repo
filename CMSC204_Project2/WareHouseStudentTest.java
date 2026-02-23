import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

public class WareHouseStudentTest {

	// Simple comparator for integers (ascending)
	private static final Comparator<Integer> INT_ASC = new Comparator<Integer>() {
		@Override
		public int compare(Integer a, Integer b) {
			return a.compareTo(b);
		}
	};

	@Test
	void testWarehouse() {
		MyPriorityQueue<Integer> queue = new MyPriorityQueue<Integer>(INT_ASC);
		MyStack<String> stack = new MyStack<>();
		
		queue.enqueue(7);
		assertEquals(7, (int) queue.peek());
		assertEquals(1, queue.size());
		assertEquals(7, (int) queue.dequeue());
		assertTrue(queue.isEmpty());

		stack.push("A");
		assertEquals(1, stack.size());
		assertEquals("A", stack.peek());
		assertEquals("A", stack.pop());
		assertTrue(stack.isEmpty());
	}
}
