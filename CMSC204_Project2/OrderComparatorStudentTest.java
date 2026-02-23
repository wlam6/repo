import static org.junit.Assert.*;
import org.junit.Test;
public class OrderComparatorStudentTest {

    @Test
    public void sameDeadlineDifferentArrival() {
        OrderComparator comparator = new OrderComparator();
        Order o1 = new Order("Order 1",  1);
        o1.setArrivalMinute(1);
        Order o2  = new Order("Order 2",  1);
        o2.setArrivalMinute(2);
        assertTrue("Earlier arrival should come first when deadlines tie", comparator.compare(o1, o2) < 0);
    }
}
