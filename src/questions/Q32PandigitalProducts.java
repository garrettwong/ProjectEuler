package questions;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Q32PandigitalProducts {
	public static void main(String[] args) {
		long ans2 = pandigitalComputation();
		System.out.println(ans2);
	}

	private static long pandigitalComputation() {
		long sum = 0;
		Map<Long, Integer> map = new HashMap<Long, Integer>();
		long prod;
		for (long m = 2; m < 100; m++) {
		    long nbegin = (m > 9) ? 123 : 1234;
		    long nend = 10000 / m + 1;
		 
		    for (long n = nbegin; n < nend; n++) {
		        prod = m * n;
		        long hodgepodge = Long.valueOf(String.format("%s%s%s", String.valueOf(prod), String.valueOf(m), String.valueOf(n)));
		        if (hodgepodge >= 1E8 &&
	        		hodgepodge < 1E9 &&
	            	isPandigital(String.valueOf(hodgepodge))) {
		            	map.put(prod, 1);
	            }
		    }
		}
		
		for (Entry<Long, Integer> entry : map.entrySet()) {
			sum += entry.getKey();
		}
		
		return sum;
	}
	
	private static boolean isPandigital(String val) {
		
		boolean isPandigital = true;
		for (int i = 1; i <= 9; i++) {
			if (!val.contains(String.valueOf(i))) {
				isPandigital = false;
				break;
			}
		}
		return isPandigital;
	}
}
