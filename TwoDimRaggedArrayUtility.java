/*
 * Class: CMSC203 
 * Instructor: Farnaz Eivazi
 * Description: Calculates the holiday bonus for an array
 * Due: 11/17/2025
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: William Lam
*/

import java.io.*;
import java.util.Scanner;


/**
 * This class represents the 2d array utilities.
 * 
 * @author William Lam
 * @version 11/17/2025
 *  
 */
public final class TwoDimRaggedArrayUtility extends Object
{
	/**
	 * Reads a file into an array
	 * 
	 * @param file
	 * @return array of data
	 * @throws FileNotFoundException
	 */
	public static double[][] readFile(File file) throws FileNotFoundException
	{
		Scanner inputFile = new Scanner(file);
		double[][] array = new double[10][];
		int row = 0;
		
		// Use of delimiters to create a 2d array
		while (inputFile.hasNextLine() && row < 10)
		{
			String[] rowArray = inputFile.nextLine().split(" ");
			
			// Only get needed amount of rows
			array[row] = new double[rowArray.length];
			for (int c = 0; c < rowArray.length; c++)
			{
				array[row][c] = Double.parseDouble(rowArray[c]);
			}
			row++;
		}
		
		inputFile.close();
		
		// Make new array to prevent null values
		double[][] newArray = new double[row][];
		for (int r = 0; r < row; r++)
		{
			newArray[r] = array[r];
		}
		
		return newArray;
	}
	
	/**
	 * Writes an array into a file
	 * 
	 * @param array of data, file
	 * @throws FileNotFoundException
	 */
	public static void writeFile(double[][] data, File outputFile) throws FileNotFoundException
	{
		PrintWriter output = new PrintWriter(outputFile);
		
		// print a 2d array
		for (int r = 0; r < data.length; r++)
		{
			for (int c = 0; c < data[r].length; c++)
			{
				output.print(data[r][c] + " ");
			}
			output.println();
		}
		output.close();
	}
	
	/**
	 * Total of sales
	 * 
	 * @param array of data
	 * @return total of sales
	 */
	public static double getTotal(double[][] data)
	{
		double total = 0;
		for (int r = 0; r < data.length; r++)
		{
			for (int c = 0; c < data[r].length; c++)
			{
				total += data[r][c];
			}
		}
		return total;
	}
	
	/**
	 * Average of total of sales
	 * 
	 * @param array of data
	 * @return average of sales
	 */
	public static double getAverage(double[][] data)
	{
		double total = 0;
		int count = 0;
		for (int r = 0; r < data.length; r++)
		{
			for (int c = 0; c < data[r].length; c++)
			{
				total += data[r][c];
				count++;
			}
		}
		return total / count;
	}
	
	/**
	 * Total of given row
	 * 
	 * @param array of data, row
	 * @return total of the row
	 */
	public static double getRowTotal(double[][] data, int row)
	{
		double total = 0;
		for (int c = 0; c < data[row].length; c++)
		{
			total += data[row][c];
		}
		return total;
	}
	
	/**
	 * Total of given column
	 * 
	 * @param array of data, col
	 * @return total of the column
	 */
	public static double getColumnTotal(double[][] data, int col)
	{
		double total = 0;
		for (int r = 0; r < data.length; r++)
		{
			if (col < data[r].length)
			{
				total += data[r][col];
			}
		}
		return total;
	}
	
	/**
	 * Finds highest value in row
	 * 
	 * @param array of data, row
	 * @return highest value
	 */
	public static double getHighestInRow(double[][] data, int row)
	{
		double highest = data[row][0];
		for (int c = 1; c < data[row].length; c++)
		{
			if (data[row][c] > highest)
			{
				highest = data[row][c];
			}
		}
		return highest;
	}
	
	/**
	 * Highest row index
	 * 
	 * @param array of data, row
	 * @return highest row index
	 */
	public static int getHighestInRowIndex(double[][] data, int row)
	{
		int highestIndex = 0;
		double highest = data[row][0];
		for (int c = 1; c < data[row].length; c++)
		{
			if (data[row][c] > highest)
			{
				highest = data[row][c];
				highestIndex = c;
			}
		}
		return highestIndex;
	}
	
	/**
	 * Finds lowest in row
	 * 
	 * @param array of data, row
	 * @return lowest in row
	 */
	public static double getLowestInRow(double[][] data, int row)
	{
		double lowest = data[row][0];
		for (int c = 1; c < data[row].length; c++)
		{
			if (data[row][c] < lowest)
			{
				lowest = data[row][c];
			}
		}
		return lowest;
	}
	
	/**
	 * Finds index of lowest value in row
	 * 
	 * @param array of data, row
	 * @return index of lowest value in row
	 */
	public static int getLowestInRowIndex(double[][] data, int row)
	{
		int lowestIndex = 0;
		double lowest = data[row][0];
		for (int c = 1; c < data[row].length; c++)
		{
			if (data[row][c] < lowest)
			{
				lowest = data[row][c];
				lowestIndex = c;
			}
		}
		return lowestIndex;
	}
	
	/**
	 * Finds index of highest value in column
	 * 
	 * @param array of data, col
	 * @return index of highest value in column
	 */
	public static double getHighestInColumn(double[][] data, int col)
	{
		double highest = data[0][col];
		for (int r = 1; r < data.length; r++)
		{
			if (col < data[r].length && data[r][col] > highest)
			{
				highest = data[r][col];
			}
		}
		return highest;
	}
	
	/**
	 * Finds index of highest value in column but its index
	 * 
	 * @param array of data, col
	 * @return index of highest value in column but its index
	 */
	public static double getHighestInColumnIndex(double[][] data, int col)
	{
		int highestIndex = 0;
		double highest = data[0][col];
		for (int r = 1; r < data.length; r++)
		{
			if (col < data[r].length && data[r][col] > highest)
			{
				highest = data[r][col];
				highestIndex = r;
			}
		}
		return highestIndex;
	}
	
	/**
	 * Finds index of lowest value in column
	 * 
	 * @param array of data, col
	 * @return index of lowest value in column
	 */
	public static double getLowestInColumn(double[][] data, int col)
	{
		double lowest = data[0][col];
		for (int r = 1; r < data.length; r++)
		{
			if (col < data[r].length && data[r][col] < lowest)
			{
				lowest = data[r][col];
			}
		}
		return lowest;
	}
	
	/**
	 * Finds index of lowest value in column but its index
	 * 
	 * @param array of data, col
	 * @return index of lowest value in column but its index
	 */
	public static double getLowestInColumnIndex(double[][] data, int col)
	{
		int lowestIndex = 0;
		double lowest = data[0][col];
		for (int r = 1; r < data.length; r++)
		{
			if (col < data[r].length && data[r][col] < lowest)
			{
				lowest = data[r][col];
				lowestIndex = r;
			}
		}
		return lowestIndex;
	}
	
	/**
	 * Finds index of highest value in array
	 * 
	 * @param array of data
	 * @return index of highest value in array
	 */
	public static double getHighestInArray(double[][] data)
	{
		double highest = data[0][0];
		for (int r = 0; r < data.length; r++)
		{
			for (int c = 0; c < data[r].length; c++)
			{
				if (data[r][c] > highest)
				{
					highest = data[r][c];
				}
			}
		}
		return highest;
	}
	
	/**
	 * Finds index of lowest value in array
	 * 
	 * @param array of data
	 * @return index of lowest value in array
	 */
	public static double getLowestInArray(double[][] data)
	{
		double lowest = data[0][0];
		for (int r = 0; r < data.length; r++)
		{
			for (int c = 0; c < data[r].length; c++)
			{
				if (data[r][c] < lowest)
				{
					lowest = data[r][c];
				}
			}
		}
		return lowest;
	}
}
