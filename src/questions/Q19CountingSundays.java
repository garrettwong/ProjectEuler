package questions;

import java.math.BigInteger;

public class Q19CountingSundays {
	public static void main(String[] args) {
		long numSundays = countSundays(1900, 2001) - countSundays(1900, 1901);
		System.out.println(numSundays);
	}
	
	public static long countSundays(int yearStart, int yearEnd) {
		// Monday
		int day = 0;
		long numSundays = 0; 
		
		// For each Month
		for (int curYear = yearStart; curYear < yearEnd; curYear++) {
			for (int i = 1; i <= 12; i++) {
				int daysInMonth;
				
				switch (i) {
					case 2:
						if (curYear % 100 == 0 && curYear % 400 != 0) daysInMonth = 28;
						else {
							daysInMonth = (curYear % 4 == 0) ? 29 : 28;
						}
						break;
					case 4:
					case 6:
					case 9:
					case 11:
						daysInMonth = 30;
						break;
					default:
						daysInMonth = 31;
						break;
				}
				day = (day + daysInMonth) % 7;
				if (day == 6) // Sunday 
				{
					numSundays++;
				}
			}
		}
		return numSundays;
	}
}
