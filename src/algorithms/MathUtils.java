package algorithms;

import java.util.Stack;

public class MathUtils {
	public static long factorial(int n) {
		assert (n >= 0) && (n <= 20) :  "n out of range";
		Stack<Integer> s  = new Stack<Integer>();
		while (n > 1) s.push(n--);
		long result = 1;
		while (s.size() > 0) {
			result = result * s.pop();
		}
		return result;
	}
	
	public static long fib(int n) {
		assert (n > 0) && (n <= 91) : "n out of range";
		if (( n == 1) || (n == 2)) return 1;	// Base Case
		return fib(n-1) + fib(n-2);
	}
	
	public static long fibi(int n) {
		// 91 greatest fib that fits in long
		assert (n>0) && (n<=91) : "n out of range";
		long curr, prev, past;
		if ((n == 1) || (n == 2)) return 1;
		curr = prev = 1;	// curr holds current Fib value
		for (int i = 3; i <= n; i++) {
			past = prev;
			prev = curr;
			curr = past + prev;
		}
		return curr;
	}
}
