package questions;

import java.util.ArrayList;
import java.util.List;

// 41 can be written as the sum of six consecutive primes: 41 = 2+3+5+7+11+13
// This is the longest sum of conseutive primes that adds to a prime below one-hundred
// The longest sum of consecutive primes below one-thousand that adds to a prime contains 21 terms and is equal to 953
// which prime below one-million can be written as the sum of the most consecutive primes?
public class Q50ConsecutivePrimeSum {
	public static void main(String[] args) {
		List<Integer> longestPrimeSummingToAPrimeList = new ArrayList<Integer>();
		
		Integer curPrime = 2;
		int consecutivePrimeSum = 2;

		int MAX = 1000000;
		while (consecutivePrimeSum < MAX) {
			longestPrimeSummingToAPrimeList.add(curPrime);
			
			if (isPrime(consecutivePrimeSum)) {
				System.out.println("Prime: " + consecutivePrimeSum);
			}
			
			curPrime = generateNextPrime(curPrime+1);
			consecutivePrimeSum += curPrime;
		}
				
		long localMax = 0L;
		
		for (int start = 0; start < longestPrimeSummingToAPrimeList.size(); start++) {
			long curSum = 0L;
			
			int i = start;
			while (i < longestPrimeSummingToAPrimeList.size() &&
					curSum + longestPrimeSummingToAPrimeList.get(i) < MAX) {
				curSum += longestPrimeSummingToAPrimeList.get(i);
				i++;
			}
			if (curSum > localMax && isPrime(curSum)) localMax = curSum;
		}
		
		System.out.println("Max: " + localMax);
	}
	
	private static Integer generateNextPrime(int start) {
		while (true) {
			if (isPrime(start)) {
				return start;
			}
			start++;
		}
	}

	public static boolean isPrime(long n) {
		if (n == 2 || n == 3) return true;
		
		if (n % 2 == 0) return false;
		
		for (int i = 3; i < (n/2) + 1; i=i+2) {
			if ( n % i == 0) return false;
		}
		return true;
	}
}
