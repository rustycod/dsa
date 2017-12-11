package org.sample.algo.dp;

import java.util.Set;
import java.util.TreeSet;

/**
 * Time complexity: O ( n^2 )
 * Auxiliary Space: O ( n^2 )
 *
 */
public class LongestPalindromicSubsequence {

	public String getPalindrome(String str) {
		
		int[][] result = new int[str.length()][str.length()];
		
		for(int i = 0; i < str.length(); i++) {
			for(int j = 0; j < str.length(); j++) {
				if(i == j) {
					result[i][j] = 1;
				}
			}
		}
		
		
		for(int l = 1; l < str.length(); l++) {
			
			for(int i = 0; i < str.length() - l; i++) {
				
				int j = i + l;
				
				if(str.charAt(i) == str.charAt(j)) {
					result[i][j] = 2 + result[i+1][j-1];
				} else {
					result[i][j] = Math.max(result[i][j-1], result[i+1][j]);
				}
			}
		}
		
		
		// trace back
		int row = 0;
		int column = str.length() - 1;
		Set<Integer> palindrome = new TreeSet<>();
		while(row != column && result[row][column] != 0) {
			int max = Math.max(result[row+1][column], result[row][column-1]);
			if(result[row][column] > max) {
				palindrome.add(row);palindrome.add(column);
				row++;
				column--;
			} else if(result[row][column] == result[row+1][column]) {
				row++;
			} else {
				column--;
			}
		}
		palindrome.add(row);
		
		System.out.println("result: "+palindrome);
		StringBuffer sb = new StringBuffer();
		for(int index : palindrome) {
			sb.append(str.charAt(index));
		}

		System.out.println("str: "+sb.toString());
		return sb.toString();
		
	}
}
