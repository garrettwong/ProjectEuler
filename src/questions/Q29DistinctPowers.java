package questions;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;


public class Q29DistinctPowers {
	public static void main(String[] args) {
		System.out.println(distinctPowers(100, 100));
	}
	
	public static int distinctPowers(int a, int b) {
		int distinctPowers = 0;
		
		assert a >= 2 && b >= 2: "inputs must be >= 2";
		
		Map<BigInteger, Integer> map = new HashMap<BigInteger, Integer>();
		
		// a is the base max, b is the exponent max
		for (int i = 2; i <= a; i++) {
			for (int j = 2; j <= b; j++) {
				BigInteger val = new BigInteger(String.valueOf(i));
				for (int k = 1; k < j; k++) {
					val = val.multiply(new BigInteger(String.valueOf(i)));
				}
				
				if (!map.containsKey(val)) {
					map.put(val, 1);
				}
			}
		}
		
		distinctPowers = map.size();
		return distinctPowers;
	}
}
