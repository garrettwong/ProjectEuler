package questions;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class Q38PandigitalMultiples {
	public static void main(String[] args) {
		long ans2 = pandigitalComputation();
		System.out.println(ans2);
	}

	private static long pandigitalComputation() {
		long largest = 0;
		for (int base = 1; base < 999999; base++) {
			StringBuilder curNum = new StringBuilder();
			int num = 1;
			while (curNum.length() < 9) {
				int temp = base * num;
				curNum.append(String.valueOf(temp));
				num++;
			}
			if (curNum.toString().length() != 9) continue;
			if (isPandigital(curNum.toString())) {
				long val = Long.valueOf(curNum.toString());
				if (val > largest) {
					largest = val;
				}
			}
		}
		return largest;
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
