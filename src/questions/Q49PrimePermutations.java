package questions;

import java.util.HashMap;
import java.util.Map;

public class Q49PrimePermutations {
	public static void main(String[] args) {
		String seq = "";
		long start = 1001;
		
		long curPrime = start;
		long prev = start;
		
		// Generate Primes and squares
		int count = 1;
		while (true) {
			seq += String.valueOf(start);
			
			while(count <= 3 && curPrime <= 9999) {
				curPrime = generateNextPrime(curPrime + 1);
	
				if (isPerm(String.valueOf(start), String.valueOf(curPrime)) && 
						prev + 3330 == curPrime) {
					
					count++;
					seq += String.valueOf(curPrime);
					prev = curPrime;
				}
			}
			
			if (count == 3 && !seq.equals("148748178147")) {
				System.out.println(seq);
			}
			seq = "";
			
			count = 1;
			start = generateNextPrime(start+1);
			curPrime = start;
			prev = start;
		}
	}

	private static boolean isPerm(String a, String b) {
		if(a.length() != b.length())
			return false;
		
		Map<Character, Integer> aMap = new HashMap<Character, Integer>();
		Map<Character, Integer> bMap = new HashMap<Character, Integer>();
		
		for(int i=0; i<a.length(); i++) {
			char aChar = a.charAt(i);
			char bChar = b.charAt(i);
			
			aMap.put(aChar, getVal(aMap, aChar) + 1);
			bMap.put(bChar, getVal(bMap, bChar) + 1);
		}
		
		for(int i=0; i<a.length(); i++) {
			char aChar = a.charAt(i);
			
			if(getVal(aMap, aChar) != getVal(bMap, aChar))
				return false;
		}
		
		return true;
	}

	
	private static int getVal(Map<Character, Integer> m, char k) {
		if(m.get(k) == null)
			return 0;
		
		return m.get(k);
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
		if (n == 2 || n == 3)
			return true;

		if (n % 2 == 0)
			return false;

		for (int i = 3; i < (n / 2) + 1; i = i + 2) {
			if (n % i == 0)
				return false;
		}
		return true;
	}
}
