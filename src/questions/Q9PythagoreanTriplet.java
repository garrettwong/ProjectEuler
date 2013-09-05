package questions;

public class Q9PythagoreanTriplet {
	public static void main(String[] args) {
		int sum = 1000;
		
		for (int a = 1; a < sum/2; a++) {
			for (int b = a; b < sum; b++) {
				// Therefore c > b
				for (int c = b; c < sum; c++) {
					if ( ((a*a) + (b*b) ) == (c*c) ) {
						int valueAbc = a + b + c;
						if (valueAbc == 1000) {
							System.out.println(a);
							System.out.println(b);
							System.out.println(c);
							System.out.println(a * b * c);
						}
					}		
				}
			}
		}
	}
}
