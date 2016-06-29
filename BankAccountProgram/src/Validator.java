import java.util.Scanner;

public class Validator {

	public static double getDouble(Scanner sc, String prompt) {
		double d = 0;
		boolean isValid = false;
		while (isValid == false) {
			
			System.out.print(prompt);
			if (sc.hasNextDouble()) {
				d = sc.nextDouble();
				isValid = true;
			}
			else {
				System.out.println("Error! Please enter a proper decimal value");
			}
			sc.nextLine();
		} //end while
		return d;
	} //end getDouble
	
	public static double getDoubleWithinRange(Scanner sc, String prompt, double min, double max) {
		double d = 0;
		
		boolean isValid = false;
		while (isValid == false) {
			d = getDouble(sc, prompt);
			
			if (d <= min) {
				System.out.println("Error, number must be greater than " + min);
			}
			else if (d >= max) {
				System.out.println("Error, number must be less than " + max);
			}
			else
				isValid = true;
		} //end while
		return d;
	} //end getDoubleWithinRange
	
	public static double getDoubleWithMin(Scanner sc, String prompt, double min) {
		double d = 0;
		boolean isValid = false;
		while (isValid == false) {
			d = getDouble(sc, prompt);
			
			if (d <= min) {
				System.out.println("Error, number must be greater than" + min);
			}
			else isValid = true;
		} //end while
		return d;
	} //end getDoubleWithMin
	
	public static String getRequiredString(Scanner sc, String prompt) {
		String s = "";
		boolean isValid = false;
		while (isValid == false) {
			System.out.print(prompt);
			s = sc.nextLine();
			if (s == null || s == "") {
				System.out.println("Error! This entry is required. Please try again.");
			}
			else {
				isValid = true;
			}
		} //end while
		return s;
	} //end getRequiredString
	
	public static String getChoiceString(Scanner sc, String prompt, String s1, String s2) {
		String s = "";
		boolean isValid = false;
		while (isValid == false) {
			s = getRequiredString(sc, prompt);
			if (!s.equalsIgnoreCase(s1) &&
					!s.equalsIgnoreCase(s2)) {
				System.out.println("Error! Please enter either '" +
					s1 + "' or '" + s2 + "'. Try again.");
			}
			else
				isValid = true;
		} //end while
		return s;
	} //end getChoiceString
	
} //end Validator class
