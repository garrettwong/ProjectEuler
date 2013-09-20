package questions;

import java.util.HashMap;
import java.util.Map;

public class Q46GoldbachsOtherConjecture {
	public static void main(String[] args) {
		Map<Long, Integer> squaresList = new HashMap<Long, Integer>();
		Map<Long, Integer> primesList = new HashMap<Long, Integer>();
		
		boolean found = false;
		
		long square = 1;
		long prime = 1;
		long curNum = 1;
		// Generate Primes and squares
		while (!found) {
			prime = generateNextPrime(prime+1);
			
			primesList.put(prime, 1);
			squaresList.put(square*square,  1);
			square++;
			
			boolean canBe = false;
			if (!isComposite(curNum) || curNum % 2 == 0) {
				curNum+= 1;
				continue;
			}
			
			for( Map.Entry<Long, Integer> entry : primesList.entrySet())  {
				if (squaresList.containsKey( (curNum - (entry.getKey()))/2 ) ) {
					canBe = true;
					break;
				}
			}

			if (!canBe) break;
			
			curNum += 1;
		}
		System.out.println(curNum);
		
	}
	
	private static boolean isComposite(long curNum) {
		if (isPrime(curNum) ) return false;
		
		for (int i = 2; i < curNum-1; i++) {
			if (curNum % i == 0) {
				return true;
			}
		}
		return false;
	}

	private static Long generateNextPrime(long start) {
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
