package questions;

public class Q36DoubleBasePalindromes {
	public static void main(String[] args) {
		int sum = 0;
		
		for (int i = 1; i < 1000000; i++) {
			if (isPalindrome(String.valueOf(i)) && isPalindrome(Integer.toBinaryString(i))) {
				sum += i;
			}
		}
		System.out.println(sum);
	}
	
	public static boolean isPalindrome(String s) {
		int sLen = s.length();
		if (sLen == 1) return true;
		
		String temp = s;
		s = new StringBuilder(s).reverse().toString();
		return s.equals(temp);
	}
}
