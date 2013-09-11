package questions;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public final class Q41PandigitalPrime {
	public static void main(String[] args) {
		System.out.println(new Q41PandigitalPrime().largestPandigitalPrime());
	}

	public String largestPandigitalPrime() {
		for (int n = 9; n >= 1; n--) {
			int[] digits = new int[n];
			for (int i = 0; i < digits.length; i++)
				digits[i] = i + 1;

			int result = -1;
			do {
				if (Library.isPrime(toInteger(digits)))
					result = toInteger(digits);
			} while (Library.nextPermutation(digits));
			
			if (result != -1) {
				return Integer.toString(result);
			}
		}
		
		throw new RuntimeException("Not found");
	}


	private static int toInteger(int[] digits) {
		int result = 0;
		for (int x : digits)
			result = result * 10 + x;
		return result;
	}
}
