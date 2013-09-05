package questions;

import java.util.HashMap;
import java.util.Map;

public class Q14LongestCollatzSequence {
	public static void main(String[] args) {
		int max = 999999;
		
		int longestChainNum = -1;
		int longestChain = 0;
		
		Map<Integer, Integer> mapSeq = new HashMap<Integer, Integer>();
		
		for (int i = 2; i <= max; i++) {
			int chainCount = 0;
			
			long n = i;
			
			while (n != 1) {		
				// If Even:
				if (n % 2 == 0) {
					n = (n/2);
				} else {
					n = (3*n) + 1;
				}
				
				if ( mapSeq.containsKey(n) ) {
					chainCount += mapSeq.get(n);
					break;
				} else {
					chainCount++;
				}
				
			}

			mapSeq.put(i, chainCount);
			
			if (chainCount > longestChain) {
				longestChain = chainCount;
				longestChainNum = i;
			}
		}
		System.out.println(longestChain);
		System.out.println(longestChainNum);
		
	}
	
	/*
	 
The following iterative sequence is defined for the set of positive integers:

n → n/2 (n is even)
n → 3n + 1 (n is odd)

Using the rule above and starting with 13, we generate the following sequence:

13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.

Which starting number, under one million, produces the longest chain?

NOTE: Once the chain starts the terms are allowed to go above one million.

	 */
}
