package questions;

import java.math.BigInteger;


/*
215 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.

What is the sum of the digits of the number 21000?
 */
public class Q16PowerDigitSum {
	public static void main(String[] args) {
		BigInteger b = new BigInteger("2");
		
		BigInteger raised = b.pow(1000);
		
		String s = raised.toString();
		
		char[] cArr = s.toCharArray();
		
		int sum = 0;
		for (char c : cArr) {
			sum += Character.getNumericValue(c);
		}
		
		System.out.println(sum);
	}
}
