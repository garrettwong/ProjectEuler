package questions;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class Q26ReciprocalCycles {
	public static void main(String[] args) {
		int longestDec = 0, largestNum = 0;
		String pattern = "";
		
		Pattern p = Pattern.compile("^0\\.[0-9]*([0-9]{7,}?)\\1+[0-9]*$");
		for ( int i = 1; i < 999; i++) {
			int len = 0;
			int num = 0;
			
			BigDecimal base = new BigDecimal(String.valueOf(1));
			BigDecimal frac = new BigDecimal(String.valueOf(i));
			BigDecimal dRep = base.divide(frac, 10000, RoundingMode.DOWN);
			
			String sRep = dRep.toString();
			
			Matcher matches = p.matcher(sRep);

			while (matches.find() ) {
				String str = matches.group(1);
				len = str.length();
				num = i;
			}
			
			if (len > longestDec) {
				longestDec = len;
				largestNum = num;
			}
		}
		System.out.println(longestDec);
		System.out.println(largestNum);
	}
}
