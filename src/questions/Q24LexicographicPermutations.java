package euler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Q24LexicographicPermutations {
	static List<String> permList = null;
	
	public static void main(String[] args) {
		permList = new ArrayList<String>();
		lexicographicPermutation("0123456789");
		Collections.sort(permList);
		System.out.println( permList.get(999999) );
	}
	
	public static void lexicographicPermutation(String n) {
		permutation("", n);
	}
	
	private static void permutation(String prefix, String str) {
	    int len = str.length();
	    if (len == 0) permList.add(prefix);
	    else {
	        for (int i = 0; i < len; i++)
	            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, len));
	    }
	}
	
	/*

A permutation is an ordered arrangement of objects. 
For example, 3124 is one possible permutation of the digits 1, 2, 3 
and 4. If all of the permutations are listed numerically or 
alphabetically, we call it lexicographic order. 
The lexicographic permutations of 0, 1 and 2 are:

012   021   102   120   201   210

What is the millionth lexicographic permutation of the digits 
0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?
	 
	*/
}
