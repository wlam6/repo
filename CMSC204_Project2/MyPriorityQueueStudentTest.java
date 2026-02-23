import static org.junit.Assert.*;
import java.util.Comparator;
import java.util.NoSuchElementException;
import org.junit.Test;

public class MyPriorityQueueStudentTest 
{
    private static final Comparator<Integer> INT_ASC =
        new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return a.compareTo(b);
            }
        };

    @Test
    public void testFunctions() {
        MyPriorityQueue<Integer> queue = new MyPriorityQueue<>(2, INT_ASC);
        queue.enqueue(3);
        assertEquals(3, (int) queue.peek());
        assertEquals(3, (int) queue.dequeue());
        assertTrue(queue.isEmpty());
        assertEquals(0, queue.size());
        
    }
}

