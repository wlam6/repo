/* 

 * Class: CMSC203  

 * Instructor: Farnaz Eivazi

 * Description: Plays a color guessing game

 * Due: 9/15/2024

 * Platform/compiler: Eclipse

 * I pledge that I have completed the programming assignment  

* independently. I have not copied the code from a student or   * any source. I have not given my code to any student. 

 * Print your Name here: William Lam 

*/ 

import java.util.Scanner;
import java.io.*;
import java.util.Random;

public class ESPGame {

	public static void main(String[] args) throws IOException
	{
		String fileName, color, userGuess, userName, userDescription, dueDate;
		String guessingColor1 = "", guessingColor2 = "", guessingColor3 = "";
		int menuChoice, guessingNumber1, guessingNumber2, guessingNumber3;
		int colorAmount = 0, score = 0;
		String keepPlaying = "Yes";
		Scanner input = new Scanner(System.in);
		boolean exitProgram = false;
		
		Random randomNumbers = new Random();
		
		// Initial Menu
		System.out.println("CMSC203 Assignment1: Test your ESP skills!");
		System.out.println("Welcome to ESP - extrasensory perception!");
		
		do
		{
			// Score resets every game
			score = 0;
			
			System.out.println("Would you please choose one of the 4 options from the menu:\n");
			
			System.out.println("1- read and display on the screen the first 16 names of colors from a file colors.txt, "
					+ "so the player can select one of them names of colors.");
			System.out.println("2- read and display on the screen the first 10 names of colors from a file colors.txt, "
					+ "so the player can select one of them names of colors.");
			System.out.println("3- read and display on the screen the first 5 names of colors from a file colors.txt, "
					+ "so the player can select one of them names of colors.");
			System.out.println("4- Exit form a program");
			
			System.out.print("Enter the option: ");
			menuChoice = input.nextInt();
			
			// Setup to read from file, colors.txt, it goes into project folder not src
			System.out.print("Enter the filename: ");
			input.nextLine();
			fileName = input.nextLine();
			try (Scanner inputFile = new Scanner(new File(fileName)))
			{
				// Display certain amount of colors
				switch (menuChoice)
				{
					case 1:
						colorAmount = 16;
						break;
					case 2:
						colorAmount = 10;
						break;
					case 3:
						colorAmount = 5;
						break;
					default:
						exitProgram = true;
						keepPlaying = "No";
				}
				
				// Read from file all colors
				if (!exitProgram)
				{
					// Pick 3 random colors for the game:
					guessingNumber1 = randomNumbers.nextInt(colorAmount) + 1;
					guessingNumber2 = randomNumbers.nextInt(colorAmount) + 1;
					guessingNumber3 = randomNumbers.nextInt(colorAmount) + 1;
					
					System.out.println("There are sixteen colors from a file:");
					for (int i = 1; i <= colorAmount; i++)
					{
						color = inputFile.nextLine();
						System.out.println(i + " " + color);
						
						// Multiple correct colors can be the same
						if (guessingNumber1 == i)
						{
							guessingColor1 = color;
						}
						if (guessingNumber2 == i)
						{
							guessingColor2 = color;
						}
						if (guessingNumber3 == i)
						{
							guessingColor3 = color;
						}
					}
					
					// Cannot use loops since no arrays
					System.out.println("\nRound 1\n");
					System.out.println("I am thinking of a color.\nIs it one of the list colors above?\nEnter your guess: ");
					userGuess = input.nextLine();
					System.out.println("\nI was thinking of " + guessingColor1 + ".");
					// Not case sensitive
					if (userGuess.toUpperCase().equals(guessingColor1.toUpperCase()))
					{
						score++;
					}
					
					System.out.println("\nRound 2\n");
					System.out.println("I am thinking of a color.\nIs it one of the list colors above?\nEnter your guess: ");
					userGuess = input.nextLine();
					System.out.println("\nI was thinking of " + guessingColor2 + ".");
					// Not case sensitive
					if (userGuess.toUpperCase().equals(guessingColor2.toUpperCase()))
					{
						score++;
					}
					
					System.out.println("\nRound 3\n");
					System.out.println("I am thinking of a color.\nIs it one of the list colors above?\nEnter your guess: ");
					userGuess = input.nextLine();
					System.out.println("\nI was thinking of " + guessingColor3 + ".");
					// Not case sensitive
					if (userGuess.toUpperCase().equals(guessingColor3.toUpperCase()))
					{
						score++;
					}
					
					// After 3 rounds
					System.out.println("Game Over");
					System.out.println("You guessed " + score + " out of 3 colors correctly.");
					System.out.println("\nWould you like to continue a Game? Type Yes/No");
					keepPlaying = input.nextLine();
				}
				inputFile.close();
			}
		} while (keepPlaying.toUpperCase().equals("YES")); // Also not case sensitive
		
		// After game ends
		System.out.print("\nEnter your name: ");
		userName = input.nextLine();
		System.out.print("Describe yourself: ");
		userDescription = input.nextLine();
		System.out.print("Due Date: ");
		dueDate = input.nextLine();
		
		// Print to a newly created file
		try (FileWriter fwriter = new FileWriter("EspGameResults.txt"); PrintWriter outputFile = new PrintWriter(fwriter))
		{
			outputFile.println("Game Over");
			outputFile.println("You guessed " + score + " out of 3 colors correctly.");
			outputFile.println("Due Date: " + dueDate);
			outputFile.println("Username: " + userName);
			outputFile.println("User Description: " + userDescription);
			outputFile.println("Date: " + dueDate);
			outputFile.close();
		}
		
		input.close();
	}

}
