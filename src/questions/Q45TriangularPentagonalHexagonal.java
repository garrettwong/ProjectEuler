package questions;

import java.util.HashMap;
import java.util.Map;

public class Q45TriangularPentagonalHexagonal {
	public static void main(String[] args) {
		Map<Long, Integer> tList = new HashMap<Long, Integer>();
		Map<Long, Integer> pList = new HashMap<Long, Integer>();
		Map<Long, Integer> hList = new HashMap<Long, Integer>();
		
		boolean found = false;
		
		int t = 286;
		int p = 166;
		int h = 144;
		
		while (!found) {	
			// Search
			long tNum = triangularNumber(t);
			long pNum = pentagonNumber(p);
			long hNum = hexagonalNumber(h);
			
			for (Map.Entry<Long, Integer> t1 : tList.entrySet() ) {
				Long t1Key = t1.getKey();
				if (pList.containsKey(t1Key)) {
					if (hList.containsKey(t1Key)) {
						System.out.println(t1Key);
						found = true;
					}
				}
			}
			
			tList.put(tNum, 1);
			pList.put(pNum, 1);
			hList.put(hNum, 1);
			t++;p++;h++;
		}
		
	}
	
	public static long triangularNumber(long n) {
		return n * (n+1) / 2;
	}
	public static long pentagonNumber(long n) {
		return (n * ( (3*n) - 1) ) / 2;
	}
	public static long hexagonalNumber(long n) {
		return n * (2*n-1);
	}
}
