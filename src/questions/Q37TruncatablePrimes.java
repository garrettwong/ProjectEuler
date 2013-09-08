package questions;

import java.util.ArrayList;
import java.util.List;

public class Q37TruncatablePrimes {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		int sum = 0;
		int count = 0;
		for (int i = 10; i < 1000000; i++) {
			if (truncatablePrime(i)) {
				count++;
				sum+=i;
				list.add(i);
			}
		}
		
		for (int i : list) System.out.print(i + " , " );
		System.out.println(list.size());
		System.out.println(sum);
	}
	
	public static boolean truncatablePrime(int n) {
		if (!isPrime(n)) return false;
		
		String s = String.valueOf(n);
		// Truncate
		for (int i = 1; i < s.length(); i++) {
			// Truncate Left
			String left = s.substring(i, s.length());
			String right = s.substring(0, s.length()-i);
			if (!isPrime(Integer.valueOf(left)) || !isPrime(Integer.valueOf(right))) return false;
		}
		
		return true;
	}
	public static boolean isPrime(int n) {
		if (n <= 1) return false;
		if (n == 2 || n == 3) return true;
		
		if (n % 2 == 0) return false;
		
		for (int i = 3; i < (n/2) + 1; i=i+2) {
			if ( n % i == 0) return false;
		}
		return true;
	}
}
