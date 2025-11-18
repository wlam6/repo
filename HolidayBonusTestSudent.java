import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This class represents GFA test cases for a HolidayBonus object.
 * 
 * @author William Lam
 * @version 11/17/2025
 * 
 */
public class HolidayBonusTestSudent {

	private double[][] dataSet = { { 1, 6, 3 }, { 9, 5 }, { 36, 5, 8 } };

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCalculateHolidayBonusA() {
		try {
			double[] result = HolidayBonus.calculateHolidayBonus(dataSet);
			assertEquals(7000.0, result[0], .001);
			assertEquals(3000.0, result[1], .001);
			assertEquals(11000.0, result[2], .001);
		} catch (Exception e) {
			fail("This should not have caused an Exception");
		}

	}

	@Test
	public void testCalculateTotalHolidayBonusA() {
		assertEquals(21000.0, HolidayBonus.calculateTotalHolidayBonus(dataSet), .001);
	}

}
