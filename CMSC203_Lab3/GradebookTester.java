import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradebookTester {
	private GradeBook grades1, grades2;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		grades1 = new GradeBook(5);
		grades2 = new GradeBook(5);
		grades1.addScore(70.2);
		grades1.addScore(70.3);
		grades2.addScore(70.4);
		grades2.addScore(70.5);
	}

	@AfterEach
	void tearDown() throws Exception {
		grades1 = grades2 = null;
	}

	@Test
	public void testAddScore()
	{
		String testString = "19.5 14.5";
		assertTrue(grades1.toString().equals(testString));
		assertEquals(grades1.getScoreSize(), grades2.getScoreSize(), .01);
	}
	
	public void testSum()
	{
		assertEquals(grades1.sum(), grades2.sum(), .01);
	}
	
	public void testMinimum()
	{
		assertEquals(grades1.minimum(), grades2.minimum(), .01);
	}
	
	public void testFinalScore()
	{
		assertEquals(grades1.finalScore(), grades2.finalScore(), .01);
	}

}
