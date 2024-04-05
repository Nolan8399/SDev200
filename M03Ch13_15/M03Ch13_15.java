/* M03Ch13_15.java
 * Author: Nolan Renie
 * Date: 2024/04/05
*/

import java.math.BigInteger;

public class M03Ch13_15 {
	/** Main method */
	public static void main(String[] args) {
		// Create and initialize two rational numbers r1 and r2
		Rational r1 = new Rational(new BigInteger("400000"), 
			new BigInteger("200000"));
		Rational r2 = new Rational(new BigInteger("200000"), 
			new BigInteger("300000"));

		// Display results
		System.out.println(r1 + " + " + r2 + " = " + r1.add(r2));
		System.out.println(r1 + " - " + r2 + " = " + r1.subtract(r2));
		System.out.println(r1 + " * " + r2 + " = " + r1.multiply(r2));
		System.out.println(r1 + " / " + r2 + " = " + r1.divide(r2));
		System.out.println(r2 + " is " + r2.doubleValue());
	}
}