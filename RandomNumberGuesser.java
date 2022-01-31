import java.util.Scanner;

public class RandomNumberGuesser {

	public static void main(String[] args) {
		boolean again = false;
		Scanner s = new Scanner(System.in);

		do {
			boolean found = false;
			again = false;
			RNG.resetCount();    
			RNG r = new RNG();
			int num = RNG.rand();
			int min = 0;
			int max = 100;
			
			
			System.out.println("\nRandom Number Generator");
			System.out.println("Enter your first guess: ");
			int input = s.nextInt();
			
			while (found != true) {
				while(input >= max || input <= min ) {
					System.out.println("  >>> Guess must be between " + min + " and " + max + ". Try Again");
					input = s.nextInt();
				}
				if (input > num) {
					System.out.println("Number of guesses is " + RNG.getCount());
					System.out.println("Your guess it too high");
					max = input;
					System.out.println("Enter your next guess between " + min + " and " + max);
					input = s.nextInt();
					r = new RNG();
				} else if (input < num) {
					System.out.println("Number of guesses is " + RNG.getCount());
					System.out.println("Your guess it too low");
					min = input;
					System.out.println("Enter your next guess between " + min + " and " + max);
					input = s.nextInt();
					r = new RNG();
				} else if (input == num) {
					System.out.println("Number of guesses is " + RNG.getCount());
					System.out.println("Congratulations, you guessed correctly");
					System.out.println("Try again? (yes or no)");
					String a = s.next();
					if (a.equals("yes")) {
						again = true;
						found = true;
					}
					if (a.equals("no")) {
						System.out.println("Thanks for playing.... \n"
								+ "Programmer: Nathan Assefa");
						break;
					}
				}
			}
		} while (again == true);
		s.close();

	}
}
