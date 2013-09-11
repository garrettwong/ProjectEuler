package euler;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


/*
If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.

If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?


NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) contains 23 letters and 115 (one hundred and fifteen) contains 20 letters. The use of "and" when writing out numbers is in compliance with British usage.
 */
public class Q17NumberLetterCounts {
	private static final Map<Integer, String> myMap;
	static {
		Map<Integer, String>aMap = new HashMap<Integer, String>();
		aMap.put(1, "one");
		aMap.put(2, "two");
		aMap.put(3, "three");
		aMap.put(4, "four");
		aMap.put(5, "five");
		aMap.put(6, "six");
		aMap.put(7, "seven");
		aMap.put(8, "eight");
		aMap.put(9, "nine");
		aMap.put(10, "ten");
		aMap.put(11, "eleven");
		aMap.put(12, "twelve");
		aMap.put(13, "thirteen");
		aMap.put(14, "fourteen");
		aMap.put(15, "fifteen");
		aMap.put(16, "sixteen");
		aMap.put(17, "seventeen");
		aMap.put(18, "eighteen");
		aMap.put(19, "nineteen");
		aMap.put(20, "twenty");
		aMap.put(30, "thirty");
		aMap.put(40, "forty");
		aMap.put(50, "fifty");
		aMap.put(60, "sixty");
		aMap.put(70, "seventy");
		aMap.put(80, "eighty");
		aMap.put(90, "ninety");
		aMap.put(100, "one hundred");
		aMap.put(200, "two hundred");
		aMap.put(300, "three hundred");
		aMap.put(400, "four hundred");
		aMap.put(500, "five hundred");
		aMap.put(600, "six hundred");
		aMap.put(700, "seven hundred");
		aMap.put(800, "eight hundred");
		aMap.put(900, "nine hundred");
		aMap.put(1000, "one thousand");
		aMap.put(-1, "and");
		aMap.put(0,  "");
		myMap = Collections.unmodifiableMap(aMap);
	}
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		
		for (int n = 1 ; n <= 1000; n++) {
			int i = n;
			int ones = i%10;
			i /= 10;
			int tens = i%10;
			i /= 10;
			int hundreds = i%10;
			i /= 10;
			int thousands = i%10;
			
			
			sb.append(myMap.get(thousands*1000));
			sb.append(myMap.get(hundreds*100));
			if (hundreds >= 1 && n % 100 != 0 ) {
				sb.append(myMap.get(-1)); // and
			}
			if (tens > 0 && tens < 2) {
				sb.append(myMap.get((tens*10) + ones));
			} else {
				sb.append(myMap.get(tens*10));
				sb.append(myMap.get(ones*1));
			}
		}
		System.out.println(sb.toString());
		System.out.println(sb.toString().replace(" ", "").length());
		
	}
}
