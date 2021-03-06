package questions;

import java.util.ArrayList;

/*
The sequence of triangle numbers is generated by adding the natural numbers. So the 7th triangle number would be 1 + 2 + 3 + 4 + 5 + 6 + 7 = 28. The first ten terms would be:

1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...

Let us list the factors of the first seven triangle numbers:

 1: 1
 3: 1,3
 6: 1,2,3,6
10: 1,2,5,10
15: 1,3,5,15
21: 1,3,7,21
28: 1,2,4,7,14,28
We can see that 28 is the first triangle number to have over five divisors.

What is the value of the first triangle number to have over five hundred divisors?

 */
public class Q12HighlyDivisibleTriangleNumber {
	public static void main(String[] args) {
		// First figure out how to calculate a triangle number
		// Triangle number is established by 1+2+3
		ArrayList<Integer> tNums = new ArrayList<Integer>();
		
		int tNum = 0;
		for (int i = 1; i < 15000; i++) {
			tNum += i;
			tNums.add(tNum);
		}
		
		// Test 28
		
		
		// Second, let's figure out how to find divisors
		int highestDivisors = 0;
		for (Integer triangleNum : tNums) {
			int divisors = 0;
			for (int i = 1; i < 1234567; i++) {
				if (triangleNum % i == 0) {
					divisors++;
				}

				if (divisors > 500) {
					System.out.println("WIN: " + triangleNum);
					return;
				}
			}
			if (divisors > highestDivisors) {
				highestDivisors = divisors;
			}
		}
		System.out.println("Failed: " + highestDivisors);
		
	}
}
