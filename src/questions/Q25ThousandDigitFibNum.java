package euler;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Q25ThousandDigitFibNum {
	
	public static void main(String[] args) {
		int i = 1;
		while (true) {
			BigInteger res = itFib(i);
			if (numDigits(res) >= 1000) {
				System.out.println(i + "\n" + res.toString());
				break;
			}
			i++;
		}
	}
	
	private static int numDigits(BigInteger n) {
		int digits = 0;
		do {
			n = n.divide(new BigInteger("10"));
			digits++;
		} while (n.compareTo(new BigInteger("0")) == 1);
		return digits;
	}
	
	private static BigInteger itFib(int n) {
		BigInteger prev = new BigInteger("1");
		BigInteger prevPrev = new BigInteger("1");
		BigInteger cur = null;
		
		if (n < 3) return new BigInteger("1");
		
		for (int i = 2; i < n; i++) {
			cur = prev.add(prevPrev);
			prevPrev = prev;
			prev = cur;
		}
		return cur;
	}
	
	private static int fib(int n) 
	{
		if (n <= 2) {
			return 1;
		}
		return fib(n-1) + fib(n-2);
	}
	
	/*

A permutation is an ordered arrangement of objects. 
For example, 3124 is one possible permutation of the digits 1, 2, 3 
and 4. If all of the permutations are listed numerically or 
alphabetically, we call it lexicographic order. 
The lexicographic permutations of 0, 1 and 2 are:

012   021   102   120   201   210

What is the millionth lexicographic permutation of the digits 
0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?
	 
	*/
}
