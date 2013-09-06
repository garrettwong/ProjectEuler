package questions;

public class Q27QuadraticPrimes {

	public static void main(String[] args) {
		int primes = 0;
		int largestNoPrimes = 0;
		int prodOfCoeffs = 0;
		
		// Key points: B must be prime < 1000
		
		// B could be negative (-999, 999)
		for (int a = -999; a < 999; a++) {
			for (int b = -999; b < 999; b++) {
				int n = 0;
				while (isPrime(Math.abs(n*n + a*n + b))) {
					n++;
				}
				if (n > largestNoPrimes) {
					largestNoPrimes = n;
					prodOfCoeffs = productOfCoefficients(a,  b);
				}
			}
		}
		
		System.out.println(prodOfCoeffs);
	}
	
	public static int primeGen(int n) {
		assert n > 0 && n < 41: "Invalid Range";
		int numPrimes = 0;
		
		// Function: n^2 + n + 41
		for (int i = 0; i < n; i++) {
			int value = (i*i) + (i) + 41;
			if (isPrime(value)) {
				numPrimes++;
			}
		}
		
		return numPrimes;
	}
	
	public static int primeGen(int n, int a, int b) {
		int numPrimes = 0;
		
		// Function: n^2 + n + 41
		for (int i = 0; i < n; i++) {
			int value = (i*i) + (a*i) + b;
			if (isPrime(value)) {
				numPrimes++;
			}
		}
		
		return numPrimes;
	}
	
	public static boolean isPrime(int n) {
		if (n % 2 == 0) return false;
		
		for (int i = 3; i < (n/2) + 1; i=i+2) {
			if ( n % i == 0) return false;
		}
		return true;
	}
	
	public static int productOfCoefficients(int a, int b) {
		return a*b;
	}

}
