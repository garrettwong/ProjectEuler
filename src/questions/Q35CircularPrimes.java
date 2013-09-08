package questions;

// Answer: 55
public class Q35CircularPrimes {
	public static void main(String[] args) {
		int count = 0;
		for (int i = 2; i < 1000000; i++) {
			if (circularPrime(i) ) {
				count++;
			}
		}
		System.out.println(count);
	}
	
	public static String shiftRight(String s) {
		if (s.length() == 1) return s;
		
		char last = s.charAt(s.length()-1);
		s = s.substring(0, s.length()-1);
		return String.valueOf(last) + s;
	}
	
	public static boolean circularPrime(int n) {
		String originalNum = String.valueOf(n);
		boolean res = true;
		
		String curVal = originalNum;
		do {
			int temp = Integer.valueOf(curVal);
			if (!isPrime(temp)) {
				res = false;
			}
			curVal = shiftRight(curVal);
		} while ( !curVal.equals(originalNum) );
		return res;
	}
	
	public static boolean isPrime(int n) {
		if (n == 2 || n == 3) return true;
		
		if (n % 2 == 0) return false;
		
		for (int i = 3; i < (n/2) + 1; i=i+2) {
			if ( n % i == 0) return false;
		}
		return true;
	}
}
