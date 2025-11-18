/*
 * Class: CMSC203 
 * Instructor: Farnaz Eivazi
 * Description: Calculates the holiday bonus for one or all stores
 * Due: 11/17/2025
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: William Lam
*/

/**
 * This class represents the Holiday Bonus.
 * 
 * @author William Lam
 * @version 11/17/2025
 *  
 */
public class HolidayBonus extends Object
{
	private static final double HIGHEST_BONUS = 5000.00, LOWEST_BONUS = 1000.00, OTHER_BONUS = 2000.00;
	
	/**
	 * Calculate the holiday bonus for a store
	 * 
	 * @param data array
	 * @return array of bonuses
	 */
	public static double[] calculateHolidayBonus(double[][] data)
	{
		double[] bonuses = new double[data.length];
		
		for (int c = 0; c < data.length; c++)
		{
			double highest = TwoDimRaggedArrayUtility.getHighestInColumn(data, c);
			double lowest = TwoDimRaggedArrayUtility.getLowestInColumn(data, c);
			
			for (int r = 0; r < data.length; r++)
			{
				if (c < data[r].length)
				{
					if (data[r][c] <= 0)
					{
						bonuses[r] += 0;
					}
					else if (data[r][c] == highest)
					{
						bonuses[r] += HIGHEST_BONUS;
					}
					else if (data[r][c] == lowest)
					{
						bonuses[r] += LOWEST_BONUS;
					}
					else
					{
						bonuses[r] += OTHER_BONUS;
					}
				}
			}
		}
		
		return bonuses;
	}
	
	/**
	 * Calculate the holiday bonus for all stores
	 * 
	 * @param data array
	 * @return array of bonuses
	 */
	public static double calculateTotalHolidayBonus(double[][] data)
	{
		double[] bonuses = calculateHolidayBonus(data);
		double total = 0;
		
		for (double bonus : bonuses)
		{
			total += bonus;
		}
		
		return total;
	}
}
