package questions;

public class Q39IntegerRightTriangles {
	public static void main(String[] args) {
		int maxCt = 0;
		int maxP = 0;
		
		for (int  p= 100; p <= 1000; p++) {
			int count = 0;
			for (int c = 10; c <= 600; c++) {
				double a = 0.0;
				for (int b = 10; b <= c; b++) {
					a = getTriangleSideLength(b, c);
					
					if (isInt(a) && (a+b+c) == p) {
						count++;
					}
				}
			}
			if (count > maxCt) {
				maxCt = count;
				maxP = p;
			}
		}
		System.out.println(maxP);
	}
	
	public static boolean isRightTriangle(int a, int b, int c) {
		if ((a*a) + (b*b) == (c*c) ) return true;
		return false;
	}
	
	public static double getTriangleSideLength(int b, int c) {
		return Math.sqrt((c*c) - (b*b));
	}
	
	public static boolean isInt(double n) {
		return n%1 == 0;
	}
}
