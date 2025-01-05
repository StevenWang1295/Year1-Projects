/* Name: Steven Wang
 * Email: swang177@u.rochester.edu
 * Date last modified: 9/29/2023
 * Homework2: MathLoops
 */

import java.util.Scanner;
import java.lang.Math;

public class MathLoops {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);	

		while (s.hasNextLine()) {

			String ls = s.nextLine();

			if (ls.equals("quit")) {
				break;
			}

			Scanner line = new Scanner(ls);

			String m = line.next();
			long v = line.nextLong();

			if (m.equals("prime")) {
				if (prime(v)) {
					System.out.println("true");
				} else {
					System.out.println("false");
				}
			} else if (m.equals("factors")) {
				System.out.println(factors(v));
			} else {
				System.out.println("Not a valid input");
			}		
		}
	}
	public static boolean prime(long n) {



		if ((n % 2) == 0) {			
			return false;			
		}

		for (long i = 3; i<=Math.sqrt(n); i+=2) {

			if ( (n % i) == 0) {
				return false;
			} 

		}
		return true;
	}

	public static String factors(long n) {

		String f = "";

		while ((n % 2)==0) {			
			f+= " " + 2; 
			n = n/2;
		}

		for (long i = 3; i<n+2; i+=2) {
			if (prime(i)) {
				while ((n % i) == 0) {
					f += " " + i;
					n = n/i;
				}
			}
		}

		return f;

	}

}
