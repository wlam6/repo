import java.util.Scanner;

public class MovieDriver_Task2 {

	public static void main(String[] args) {
		String movieTitle, movieRating, userInput;
		int ticketsSold;
		boolean enterAnother = true;
		
		Scanner input = new Scanner(System.in);
		Movie newMovie = new Movie();
		
		do
		{
			System.out.println("Enter the name of a movie");
			movieTitle = input.nextLine();
			newMovie.setTitle(movieTitle);
			
			System.out.println("Enter the rating of the movie");
			movieRating = input.nextLine();
			newMovie.setRating(movieRating);
			
			System.out.println("Enter the number of the tickets sold for this movie");
			ticketsSold = input.nextInt();
			newMovie.setSoldTickets(ticketsSold);
			input.nextLine();
		
			System.out.println(newMovie);
			System.out.println("Do you want to enter another? (y or n)");
			userInput = input.nextLine();
			if (userInput.equals("n"))
			{
				enterAnother = false;
			}
		} while (enterAnother);
		
		input.close();
	}

}

