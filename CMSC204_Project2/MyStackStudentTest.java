import static org.junit.Assert.*;
import org.junit.Test;

public class MyStackStudentTest {

    @Test
    public void testStackFunctions() {
        MyStack<String> returns = new MyStack<>(3);

        returns.push("Order 1");
        assertEquals(1, returns.size());
        assertEquals("Order 1", returns.peek());
        assertEquals("Order 1", returns.pop());
        assertTrue(returns.isEmpty());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmpty() {
        MyStack<String> stack = new MyStack<>();
        stack.push("Order");
        stack.pop();
        stack.push(null);
    }
}
