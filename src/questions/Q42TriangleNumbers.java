package questions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Q42TriangleNumbers {
	public static void main(String[] args) throws IOException {
		Map<Integer, Integer> tNumMap = createTriangleNumbers(50);
		
		String filename = "words.txt";
		BufferedReader br = new BufferedReader(new FileReader(filename));
		String line = null;
		StringBuilder sb = new StringBuilder();
		while ( (line = br.readLine() ) != null) {
			sb.append(line);
		}
		br.close();
		String res = sb.toString();
		
		
		int totalTNums = 0;
		// Iterate through each word in words array
		String[] arr = res.split(",");
		for (String word : arr) {
			int tNumValue = 0;
			
			// Iterate through each character in char array
			for (char c : word.toCharArray()) {
				if (c != '"') {
					tNumValue += (c - 64); // Convert ASCII value to Alphabetic Position, A=65
				}
			}
			
			// Increment Map
			if (tNumMap.containsKey(tNumValue)) {
				totalTNums++;
			}
		}
		System.out.println(totalTNums);
	}

	public static Map<Integer, Integer> createTriangleNumbers(int size) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < size; i++) {
			double tNum = 0.5 * i * (i + 1);
			map.put((int) tNum, 1);
		}

		return map;
	}
}
