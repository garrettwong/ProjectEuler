package questions;

import java.math.BigInteger;

public class Q40ChampernownesConstant {
	public static void main(String[] args) {
		StringBuilder digits = new StringBuilder();
		
		for (int i = 1; i < 102000; i++) {
			digits.append(String.valueOf(i));
		}
		
		String dig = digits.toString();
		
		BigInteger big = new BigInteger("1");
		big = big.multiply(new BigInteger(String.valueOf(dig.charAt(10-1))));
		big = big.multiply(new BigInteger(String.valueOf(dig.charAt(100-1))));
		big = big.multiply(new BigInteger(String.valueOf(dig.charAt(1000-1))));
		big = big.multiply(new BigInteger(String.valueOf(dig.charAt(10000-1))));
		big = big.multiply(new BigInteger(String.valueOf(dig.charAt(100000-1))));

		System.out.println(big.toString());
	}
}
