package questions;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Q22NamesScores {
	public static void main(String[] args) {
		List<String> list = readFileToList("names.txt");
		
		Collections.sort(list);

		int totalSum = 0;
		
		for (int i = 0; i < list.size(); i++) {
			String name = list.get(i);
			totalSum += alphabeticalPositionScore(name) * (i+1); 
		}
		
		System.out.println(totalSum);
	}
	
	public static int alphabeticalPositionScore(String s) {
		int score = 0;
		int upperCaseConversionForAlphabeticalPosition = 64; // ASCII Table A=65
		for (char c : s.toCharArray()) {
			score += Integer.valueOf(c) - upperCaseConversionForAlphabeticalPosition;
		}
		return score;
	}
	
	public static List<String> readFileToList(String fileName) {
		File file = new File(fileName);
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		DataInputStream dis = null;
		String[] namesArray = null;
		
		try {
			fis = new FileInputStream(file);
			
			bis = new BufferedInputStream(fis);
			dis = new DataInputStream(bis);
			
			// dis.available() returns 0 if the file doesn't have any more lines
			String line = null;
			while (dis.available() != 0) {
				line = dis.readLine();
			}
			namesArray = line.replace("\"", "").split(","); 
			
			fis.close();
			bis.close();
			dis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return Arrays.asList(namesArray);
	}
	
	/*
Using names.txt (right click and 'Save Link/Target As...'), a 46K text file containing over five-thousand first names, 
begin by sorting it into alphabetical order. Then working out the alphabetical value for each name, multiply this value 
by its alphabetical position in the list to obtain a name score.

For example, when the list is sorted into alphabetical order, COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53, 
is the 938th name in the list. So, COLIN would obtain a score of 938 × 53 = 49714.

What is the total of all the name scores in the file?
	 */
}
