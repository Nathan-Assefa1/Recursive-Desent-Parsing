import java.util.Scanner;

public class WifiDiagnosis {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		System.out.println("If you have a problem with internet connectivity, this Wifi"
				+ " Diagnosis might work. \n\n\n" + "First Step: reboot your computer \n"
				+ "Are you able to connect with the internet? (yes or no)");
		
		String answer = s.next();
		
		if (answer.compareTo("yes") == 0) {
			System.out.println("rebooting your computer seemed to work");
			System.exit(0);
		
		}
		System.out.println(
				"Second step: reboot your router \n" + "Now are you able to connect with the internet? (yes or no)");
		answer = s.next();
		
		if (answer.compareTo("yes") == 0) {
			System.out.println("rebooting your router seemed to work");
			System.exit(0);
		}
		
		System.out.println("Third step: make sure the cables to your router are "
				+ " plugged in firmly and your router is getting power");
		
		System.out.println("Now are you able to connect with the internet? (yes or no)");
		answer = s.next();
		
		if (answer.compareTo("yes") == 0) {
			System.out.println("Checking the router's cables seemed to work");
			System.exit(0);
		}
		
		System.out.println("Fourth step: move your computer closer to your router");
		System.out.println("Now are you able to connect with the internet? (yes or no)");
		answer = s.next();
		
		if (answer.compareTo("yes") == 0) {
			System.out.println("Moving your computer closer to the router seemed to work");
			System.exit(0);
		}
		
		System.out.println("Fifth step: contact your ISP \n" + "Make sure your ISP is hooked up to your router.");
		System.exit(0);

	}

}
