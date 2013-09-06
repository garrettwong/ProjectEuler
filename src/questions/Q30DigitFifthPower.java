package questions;

import java.util.ArrayList;

public class Q30DigitFifthPower {
	public static void main(String[] args) {
		int power = 5;
		int total = 0;
		for (int i = 2; i < 999999; i++) {
			int sumOfDigits = 0;
			int tempI = i;
			
			// Get Digit One and Loop 4x
			ArrayList<Integer> arr = new ArrayList<Integer>();
			while ( tempI > 0) {
				int digit = tempI % 10;
				arr.add(digit);
				tempI = tempI / 10;
			}
			for (Integer num : arr) {
				int mult = num;
				for (int j = 1; j < power; j++) {
					mult*=num;
				}
				// then add mult
				sumOfDigits += mult;
			}
			if (sumOfDigits == i) {
				total+= sumOfDigits;
			}
		}
		System.out.println(total);
	}
}
