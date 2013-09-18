package questions;

import java.util.HashMap;
import java.util.Map;

public class Q46GoldbachsOtherConjecture {
	public static void main(String[] args) {
		Map<Long, Integer> squaresList = new HashMap<Long, Integer>();
		Map<Long, Integer> primesList = new HashMap<Long, Integer>();
		
		boolean found = false;
		
		long square = 1;
		long prime = 1;
		long curNum = 2;
		// Generate Primes and squares
		while (!found) {
			if (curNum % 2 ==0 || !isPrime(curNum)) continue;
			
			prime = generateNextPrime(prime+1);
			primesList.put(prime, 1);
			squaresList.put(square*square,  1);
			square++;
			
			boolean canBe = false;
			
			for( Map.Entry<Long, Integer> entry : primesList.entrySet())  {
				if (curNum < entry.getKey()) break;
				if (squaresList.containsKey(curNum - entry.getKey()) ) {
					canBe = true;
					break;
				}
			}
			
			if (!canBe) break;
		}
		System.out.println(curNum);
		
	}
	
	private static Long generateNextPrime(long start) {
		while (true) {
			if (isPrime(start)) {
				return start;
			}
			start++;
		}
	}

	private static boolean isPrime(Long i) {
        if(i%2 == 0 && i!=2)
            return false;
	    else {
            if(i == 1) return false;
            for(int p=3;p<=i/2;p+=2){
                if(i%p == 0)
                    return false;
            }
            return true;
	    }
	}
}
