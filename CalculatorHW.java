/* Name: Steven Wang
 * Email: swang177@u.rochester.edu
 * Date last modified: 9/18/2023
 * Homework2: CalculatorHW
 */

 
import java.util.Scanner;

public class CalculatorHW {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		while (s.hasNextLine()) {
			String line = s.nextLine();

			if (line.length() == 0) {
				break; 
			}
			Scanner lineScanner = new Scanner(line);	

			double value = lineScanner.nextDouble();
			String src = lineScanner.next().toLowerCase();
			lineScanner.next();
			String dest = lineScanner.next().toLowerCase();
			String err = "***Unable to convert from " + src + " to " + dest + "***";

			// The calculator itself
			if (src.equals("f")) {
				if (dest.equals("f")) {
					double output = (value);
					System.out.printf("%.3f \n", output);
				} else if (dest.equals("c")) {
					double output = ( (5.0/9.0) * (value-32.0) );
					System.out.printf("%.3f \n", output);
				} else {
					System.out.println(err);
				}
			} else if (src.equals("c")) {
				if (dest.equals("c")) {
					double output = (value);
					System.out.printf("%.3f \n", output);
				} else if (dest.equals("f")) {
					double output = ( ( (9.0/5.0) * value )+32.0 );
					System.out.printf("%.3f \n", output);
				} else {
					System.out.println(err);
				}
			} else if (src.equals("kg")) {
				if (dest.equals("kg")) {
					double output = (value);
					System.out.printf("%.3f \n", output);
				} else if (dest.equals("lb")) {
					double output = (2.20462*value);
					System.out.printf("%.3f \n", output);
				} else {
					System.out.println(err);
				}
			} else if (src.equals("lb")) {
				if (dest.equals("lb")) {
					double output = (value);
					System.out.printf("%.3f \n", output);
				} else if (dest.equals("kg")) {
					double output = (0.453592*value);
					System.out.printf("%.3f \n", output);
				} else {
					System.out.println(err);
				}
			} else if (src.equals("m")) {
				if (dest.equals("m")) {
					double output = (value);
					System.out.printf("%.3f \n", output);
				} else if (dest.equals("ft")) {
					double output = (3.28084*value);
					System.out.printf("%.3f \n", output);
				} else {
					System.out.println(err);
				}
			} else if (src.equals("ft")) {
				if (dest.equals("ft")) {
					double output = (value);
					System.out.printf("%.3f \n", output);
				} else if (dest.equals("m")) {
					double output = (0.3048*value);
					System.out.printf("%.3f \n", output);
				} else {
					System.out.println(err);
				}
			} else if (src.equals("h")) {
				if (dest.equals("h")) {
					double output = (value);
					System.out.printf("%.3f \n", output);
				} else if (dest.equals("min")) {
					double output = (60.0*value);
					System.out.printf("%.3f \n", output);
				} else {
					System.out.println(err);
				}
			} else if (src.equals("min")) {
				if (dest.equals("min")) {
					double output = (value);
					System.out.printf("%.3f \n", output);
				} else if (dest.equals("h")) {
					double output = ( (1/60.0) *value);
					System.out.printf("%.3f \n", output);
				} else {
					System.out.println(err);
				}
			} else {
				System.out.println(err);
			}
		} 
		System.out.println("Okay, see ya!");
	}
}
