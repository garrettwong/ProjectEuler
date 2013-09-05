package questions;

import java.math.BigInteger;

public class Q15LatticePaths {
	public static void main(String[] args) {
		// 0 x 0
		
		// Full enumeration
		int r = 20;
		int d = 20;
		
		BigInteger res = fact(6).divide( (fact(3).multiply(fact(3)) ) );
		System.out.println(res);
				
		long paths = latticePaths(r, d);
		System.out.println(paths);
	}
	
	protected static BigInteger fact(int n) {
		BigInteger res = new BigInteger("1");
		for (int i = 1; i <= n; i++) {
			res = res.multiply(new BigInteger(String.valueOf(i)));
		}
		return res;
	}
	
	public static long latticePaths(int r, int d) {
		// Base Case
		if (r == 1 && d == 1) return 2;
		
		long count = 2;
		
		for (int i = 1; i < r; i++) {
			// Extend to right 1x1 -> 1x2
			count = count + ((count*i)/(i+1));
			
			d--;

			// Double in Size 1x2 -> 2x2
			count *= 2;
		}
		
		return count;
	}
	/*
		Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down, there are exactly 6 routes to the bottom right corner.
		
		How many such routes are there through a 20×20 grid?
	 */
}
