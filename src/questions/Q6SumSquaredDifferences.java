package questions;

public class Q6SumSquaredDifferences {
	public static void main(String[] args) {
		
		int total = 100;
		int sumOfSquares = 0;
		for (int i = 1; i <= total; i++) {
			sumOfSquares += (i*i);
		}
		
		int squareOfSums = 0;
		for (int i = 1; i <= total; i++) {
			squareOfSums += i;
		}
		squareOfSums = squareOfSums * squareOfSums;
		
		System.out.println(sumOfSquares);
		System.out.println(squareOfSums);
		System.out.println(squareOfSums - sumOfSquares);
		

		// Short Hand Notation
		int ss = 0;
		for (int i = 1; i <= total; i++) {
			ss += (i*i) * (i-1);
		}
		System.out.println(ss);
	}
}
