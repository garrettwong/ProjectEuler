package questions;

import java.math.BigInteger;

public class Q20FactorialDigitSum {
	public static void main(String[] args) {
		BigInteger big = factorialDigitSum(100);
		int sum = SumOfDigits(big.toString());
		System.out.println(sum);
	}
	
	public static BigInteger factorialDigitSum(int factorial) {
		BigInteger bigInt = new BigInteger(String.valueOf(factorial));
		for (int i = factorial-1; i > 0; i--) {
			bigInt = bigInt.multiply(new BigInteger(String.valueOf(i)));
		}
		return bigInt;
	}
	
	public static int SumOfDigits(String s) {
		int sum = 0;
		for (char c : s.toCharArray() ) {
			sum += Character.getNumericValue(c);
		}
		return sum;
	}
}
