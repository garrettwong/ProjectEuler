package questions;

import java.util.ArrayList;
import java.util.List;

public class Q33DigitCancelingFractions {
	public static class Fraction {
		public double num;
		public double den;
		
		public Fraction() {}
		public Fraction(double n, double d) {
			num = n;
			den = d;
		}
		
		public double gcd() {
			double temp;
			double n1 = Math.abs(num);
			double n2 = Math.abs(den);
			while (n1 > 0) {
				temp = n1;
				n1 = n2 % n1;
				n2 = temp;
			}
			return n2;
		}
		public double reduceDenominator() {
			return this.den/gcd();
		}
	}
	
	public static void main(String[] args) {
		Fraction ans2 = compute();
		System.out.println(ans2.reduceDenominator());
	}

	private static Fraction compute() {
		List<Fraction> list = new ArrayList<Fraction>();
		for (double n = 10; n < 100; n++) {
			for (double d = 10; d < 100; d++) {
				if (n >= d) continue;
				Fraction f = new Fraction(n, d);
				
				if (digitCanceling(n, d) ) {
					list.add(f);
				}
			}
		}
		
		Fraction result = new Fraction(1, 1);
		for (Fraction d : list) {
			result.num *= d.num;
			result.den *= d.den;
		}
		return result;
	}
	
	private static boolean digitCanceling(double num, double den) {
		// Num and Den share a digit
		assert num < 100 && den < 100 && num > 0 && den > 0: "Invalid Data Range";
		boolean digitCanceling = false;
		
		// Find actual value
		double actual = num/den;
		
		// if no common numbers throw out
		double onesN = num % 10.0;
		double tensN = (int)(num/10.0);
		
		double onesD = den % 10.0;
		double tensD = (int)(den/10.0);
		
		// Canceling 0 is bad
		if (tensN == 0 || tensD == 0) return false;
		
		double reducedN = -1;
		double reducedD = -1;
		
		// Cancel Choices
		if (onesN == tensD ) {
			reducedN = tensN;
			reducedD = onesD;
		} else if (onesD == tensN ) {
			reducedN = onesN;
			reducedD = tensD;
		} else {
			return false;
		}
		
		if (reducedN == 0 || reducedD == 0) {
			return false;
		}
		
		double digitCanceledVal = reducedN / reducedD;
		if (digitCanceledVal == actual) {
			digitCanceling = true;
		}
		return digitCanceling;
	}
}
/*
The fraction 49/98 is a curious fraction, as an inexperienced mathematician in attempting to simplify it may incorrectly believe that 49/98 = 4/8, which is correct, is obtained by cancelling the 9s.

We shall consider fractions like, 30/50 = 3/5, to be trivial examples.

There are exactly four non-trivial examples of this type of fraction, less than one in value, and containing two digits in the numerator and denominator.

If the product of these four fractions is given in its lowest common terms, find the value of the denominator.
 */
