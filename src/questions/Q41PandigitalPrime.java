package questions;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public final class Q41PandigitalPrime {
	public static void main(String[] args) {
		List<String> list = comb1("654321");
		long result = 0;

		for (int i = list.size() - 1; i >= 0; i--) {
			long val = Long.valueOf(list.get(i));
			if (isPandigital(val)) {
				if (isPrime(val)) {
					result = val;
					break;
				}
			}
		}

		System.out.println(result);
	}

	public static List<String> perm1(String s) {
		return perm1("", s);
	}

	private static List<String> perm1(String prefix, String s) {
		List<String> list = new ArrayList<String>();
		int N = s.length();
		if (N == 0)
			list.add(prefix);
		else {
			for (int i = 0; i < N; i++)
				list.addAll(perm1(prefix + s.charAt(i),
						s.substring(0, i) + s.substring(i + 1, N)));
		}
		return list;
	}

	public static List<String> comb1(String s) { return comb1("", s); }

    // print all subsets of the remaining elements, with given prefix 
    private static List<String> comb1(String prefix, String s) {
    	List<String> list = new ArrayList<String>();
    	if (s.length() > 0) {
            list.add(prefix + s.charAt(0));
            list.addAll(comb1(prefix + s.charAt(0), s.substring(1)));
            list.addAll(comb1(prefix,               s.substring(1)));
        }
        return list;
    }  
    
	public static List<BigInteger> eSieve(int upperBound) {
		List<BigInteger> list = new ArrayList<BigInteger>();

		int upperBoundSquareRoot = (int) Math.sqrt(upperBound);
		boolean[] isComposite = new boolean[upperBound + 1];
		for (int m = 2; m <= upperBoundSquareRoot; m++) {
			if (!isComposite[m]) {
				for (int k = m * m; k <= upperBound; k += m)
					isComposite[k] = true;
			}
		}
		for (int m = upperBoundSquareRoot; m <= upperBound; m++)
			if (!isComposite[m])
				list.add(new BigInteger(String.valueOf(m)));
		return list;
	}

	public static boolean isPrime(long val) {
		if (val < 2)
			return true;

		for (long i = 2; i * i <= val; i++) {
			if (val % i == 0) {
				return false;
			}
		}
		return true;
	}

	private static boolean isPandigital(long n) {
		int digits = 0;
		int count = 0;
		int temp;

		while (n > 0) {
			temp = digits;
			digits = digits | 1 << (int) ((n % 10) - 1);
			if (temp == digits) {
				return false;
			}
			count++;
			n /= 10;
		}
		return digits == (1 << count) - 1;
	}
}
