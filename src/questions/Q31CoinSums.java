package questions;

public class Q31CoinSums {
	final static int[] coins = new int[] {
		1, 2, 5, 10, 20, 50, 100, 200
	};
	
	public static void main(String[] args) {
		//int answer = bruteForceNumCombinations(200);
		//System.out.println(answer);
		
		int ans2 = findChange(200, coins.length);
		System.out.println(ans2);
	}

	private static int bruteForceNumCombinations(int total) {
		int counter = 1; // start at 1 to count 200
		int sum;
		for (int a = 0; a <= 200; a++) {
			for (int b = 0; b <= 100; b++) {
				for (int c = 0; c <= 40; c++) {
					for (int d = 0; d <= 20; d++) {
						for (int e = 0; e <= 10; e++) {
							for (int f = 0; f <= 4; f++) {
								for (int g = 0; g <= 2; g++) {
										
									sum = a*1 + b*2 + c*5 + d*10 + e*20 + f*50 + g*100;
									if (sum == total) {
										counter++;
									}
										
								}
							}
						}
					}
				}
			}
		}
		return counter;
	}

	private static int findChange(int total, int numCoins) {
		if (numCoins <= 1) {
			return 1;
		}

		int result = 0;

		while (total >= 0) {
			result = result + findChange(total, numCoins-1);
			total = total - coins[numCoins-1];
		}
		return result;
	}
}
