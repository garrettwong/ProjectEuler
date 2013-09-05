package questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Q23NonAbundantSums {
	public enum NumberType {
		Deficient,
		Perfect,
		Abundant
	}
	public static void main(String[] args) {
		Map<Integer, NumberType> map = new HashMap<Integer, NumberType>();
		
		int topLimit = 28123;
		
		// Populate HashMap
		for (int i = 1; i < topLimit; i++) {
			map.put(i, getNumberType(i));
		}

		int totalSum = 0;
		for (int i = 1; i < topLimit; i++) {
			
			if (!isSumOfTwoAbundantNumbers(i, map)) {
				totalSum += i;
			}
		}
		System.out.println(totalSum);
	}
	
	public static Boolean isSumOfTwoAbundantNumbers(int n, Map<Integer, NumberType> map) {
		Boolean isSum = false;
		for (Map.Entry<Integer, NumberType> entry : map.entrySet()) {
			int remainder = -1;
			if (entry.getValue() == NumberType.Abundant) {
				remainder = n - entry.getKey();
			}
			if (remainder < -1) return false;
			
			if (map.get(remainder) == NumberType.Abundant) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean isPerfectNumber(int n) {
		// sum of its proper divisors is exactly equal to the number
		List<Integer> divisors = enumerateDivisors(n);
		if ( sumOfList(divisors) == n) {
			return true;
		}
		return false;
	}
	
	public static NumberType getNumberType(int n) {
		// sum of its proper divisors is exactly equal to the number
		List<Integer> divisors = enumerateDivisors(n);
		int sum = sumOfList(divisors);
		if ( sum == n) {
			return NumberType.Abundant;
		} else if (sum < n) {
			return NumberType.Deficient;
		} else {
			return NumberType.Abundant;
		}
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
	
	/*

A perfect number is a number for which the sum of its proper divisors is exactly equal to the number. 
For example, the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.

A number n is called deficient if the sum of its proper divisors is less than n and it is called abundant if this sum exceeds n.

As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest number that can be written as the sum of two 
abundant numbers is 24. By mathematical analysis, it can be shown that all integers greater than 28123 can be written as 
the sum of two abundant numbers. However, this upper limit cannot be reduced any further by analysis even though it is known 
that the greatest number that cannot be expressed as the sum of two abundant numbers is less than this limit.

Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.

	 */
}
