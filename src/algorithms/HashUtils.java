package algorithms;

public class HashUtils {
	public static int hashNum(int x) {
		return x % 16;
	}
	
	public static int hashString(String x, int M) {
		char ch[];
		ch = x.toCharArray();
		int xlength = x.length();
		
		int i, sum;
		for (sum = 0, i = 0; i < xlength; i++) {
			sum += ch[i];
		}
		return sum % M;
	}
	
	public static long hashStringGood(String s, int M) {
		int intLen = s.length() / 4;
		long sum = 0;
		for (int j = 0; j < intLen; j++) {
			char c[] = s.substring(j*4, (j*4) + 4).toCharArray();
			long mult = 1;
			for (int k = 0; k < c.length; k++) {
				sum += c[k] * mult;
				mult *= 256;
			}
		}
		
		char c[] = s.substring(intLen * 4).toCharArray();
		long mult = 1;
		for (int k = 0; k < c.length; k++) {
			sum += c[k] * mult;
			mult *= 256;
		}
		return (Math.abs(sum) % M);
	}
	
	public static void main(String[] args) {
		String m = "dummy";
		System.out.println(hashString(m, 100));
	}
}
