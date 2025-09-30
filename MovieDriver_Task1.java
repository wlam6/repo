import java.util.Scanner;

public class MovieDriver_Task1 {

	public static void main(String[] args) {
		String movieTitle, movieRating;
		int ticketsSold;
		
		Scanner input = new Scanner(System.in);
		Movie newMovie = new Movie();
		
		System.out.println("Enter the name of a movie");
		movieTitle = input.nextLine();
		newMovie.setTitle(movieTitle);
		
		System.out.println("Enter the rating of the movie");
		movieRating = input.nextLine();
		newMovie.setRating(movieRating);
		
		System.out.println("Enter the number of the tickets sold ");
		ticketsSold = input.nextInt();
		newMovie.setSoldTickets(ticketsSold);
		
		System.out.println(newMovie);
		input.close();
	}

}
