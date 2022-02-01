import java.util.Scanner;

/**
 * The purpose of this program is to provide
 * possible solutions to computer troubles
 * the user may be experiencing. 
 * 
 * @author Nathan Assefa
 *
 */
public class WifiDiagnosis {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		System.out.print("If you have a problem with internet connectivity, this Wifi"
				+ " Diagnosis might work. \n\n" + "First Step: reboot your computer \n"
				+ "Are you able to connect with the internet? (yes or no): ");
		
		String answer = s.next();
		
		if (answer.compareTo("yes") == 0) {
			System.out.println("Rebooting your computer seemed to work");
			System.exit(0);
		
		}
		System.out.print(
				"\nSecond step: reboot your router \n" + "Now are you able to connect with the internet? (yes or no): ");
		answer = s.next();
		
		if (answer.compareTo("yes") == 0) {
			System.out.println("Rebooting your router seemed to work");
			System.exit(0);
		}
		
		System.out.println("\nThird step: make sure the cables to your router are "
				+ " plugged in firmly and your router is getting power");
		
		System.out.print("Now are you able to connect with the internet? (yes or no): ");
		answer = s.next();
		
		if (answer.compareTo("yes") == 0) {
			System.out.println("Checking the router's cables seemed to work");
			System.exit(0);
		}
		
		System.out.println("\nFourth step: move your computer closer to your router");
		System.out.print("Now are you able to connect with the internet? (yes or no): ");
		answer = s.next();
		
		if (answer.compareTo("yes") == 0) {
			System.out.println("Moving your computer closer to the router seemed to work");
			System.exit(0);
		}
		
		System.out.println("\nFifth step: contact your ISP \n" + "Make sure your ISP is hooked up to your router.");
		
		s.close();

	}

}