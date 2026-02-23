 import static org.junit.Assert.*;
import org.junit.Test;

public class WarehouseSimulationStudentTest {

    @Test
    public void lateTest() {
        Order[] orders = new Order[] {
            new Order("Order 1", 1),
            new Order("Order 2", 1),
            new Order("Order 3",  1)   // late order
        };

        WarehouseSimulation sim = new WarehouseSimulation(orders);

        while (!sim.isFinished()) {
            sim.tick();
        }
        assertEquals(1, sim.getTotalLate());
        assertEquals(3, sim.getCurrentMinute());
    }

    
}
