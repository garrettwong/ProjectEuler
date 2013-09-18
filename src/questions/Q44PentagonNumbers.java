package questions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Q44PentagonNumbers {
	protected static List<Long> list = null;
	
	public static void main(String[] args) {
		List<Long> list = new ArrayList<Long>();
		
		long minDiff = Long.MAX_VALUE;
		
		int i = 0;
		long p = 0;
		while (true) {
			i += 1;
			p = pentagonNumber(i);
			for (int j = 0; j < list.size(); j++) {
				long diff = Math.abs(p-list.get(j));
				
				if (isPentagonal(diff)) {
					long sum = (p+list.get(j));
					if (isPentagonal(sum) ) {
						System.out.println(diff);
						break;
					}
				}
			}
			list.add(p);
		}
	}
	
	public static long pentagonNumber(long n) {
		return (n * ( (3*n) - 1) ) / 2;
	}
	
	public static boolean isPentagonal(long val) {
		double n = ((Math.sqrt((24*val) + 1) + 1) / 6);
		if (n == (int)n && n > 0) return true;
		else return false;
	}
}
