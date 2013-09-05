package questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q21AmicableNumbers {
	public static void main(String[] args) {
		int sum = computeSumOfAmicableNumbers(10000);
		System.out.println(sum);
	}
	
	private static List<Integer> enumerateDivisors(int n) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i < n; i++) {
			if (n % i == 0) {
				list.add(i);
			}
		}
		return list;
	}
	
	private static int sumOfList(List<Integer> list) {
		int sum = 0;
		for (int i : list) {
			sum += i;
		}
		return sum;
	}
	
	private static Boolean isAmicableNumber(int n) {
		int friend = sumOfList(enumerateDivisors(n));
		if (sumOfList(enumerateDivisors(friend) ) == n && friend != n) {
			return true;
		}
		return false;
	}
	
	private static int computeSumOfAmicableNumbers(int max) {
		List<Integer> listOfAmicableNumbers = new ArrayList<Integer>();
		
		for (int i = 1; i < max; i++) {
			// Look if Number pair is Amicable
			if (isAmicableNumber(i) ) {
				listOfAmicableNumbers.add(i);
			}
		}
		
		return sumOfList(listOfAmicableNumbers);
	}
	
	/*
	 * 
	 * Amicable numbers
Problem 21
Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable pair and each of a and b are called amicable numbers.

For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.

Evaluate the sum of all the amicable numbers under 10000.
	 */
}
