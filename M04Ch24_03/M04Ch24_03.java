/* M04Ch24_03.java
 * Author: Nolan Renie
 * Date: 2024/04/14
*/

public class M04Ch24_03 {
	public static void main(String[] args) {
		// Create a GenericStack
		GenericStack<Integer> stack = new GenericStack<>();
		final int NUMBER_OF_PRIMES = 50; // Number of prime numbers
		int count = 0;
		for (int i = 2; count < NUMBER_OF_PRIMES; i++) {
			if (isPrime(i)) {
				stack.push(i);
				count++;
			}
		}

		// Display the numbers in the stack
		System.out.println("The first 50 prime numbers in descending order: ");
		for (int i = 1; !stack.isEmpty(); i++){
			if (i % 10 == 0)
				System.out.printf("%3d\n", stack.pop());
			else
				System.out.printf("%3d ", stack.pop());
		}
		System.out.println();
	}

	/** Return true if n is a prime number, Otherwise return false */
	public static boolean isPrime(int n) {
		for (int i = 2; i <= n / 2; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}
}