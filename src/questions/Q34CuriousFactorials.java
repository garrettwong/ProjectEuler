package questions;

public class Q34CuriousFactorials {
	public static void main(String[] args) {
		long[] factArray = getFactorialArray();
		
		int sumOfAll = 0;
		
		// For each value, sum factorial cell of each digit...
		for (long i = 10; i < 2540161; i++) {
			long curVal = i;
			long sum = 0;
			
			while (curVal > 0) {
				int digit = (int) (curVal % 10);
				sum += factArray[digit];
				curVal /= 10;
			}
			if (sum == i) sumOfAll += i;
		}
		
		System.out.println(sumOfAll);
	}
	
	public static long[] getFactorialArray() {
		long[] factArray = new long[10];
		
		// 1 2 6 24 120
		factArray[0] = 1;
		factArray[1] = 1;
		for (int i = 2; i < 10; i++) {
			factArray[i] = i*factArray[i-1];
		}
		
		return factArray;
	}
}
