package org.sample.algo.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * Time Complexity: O(m x n)
 * Auxiliary Space: O(m x n)
 *
 */
public class MinimumEditDistance {
	
	public List<List<Integer>> instructions = new ArrayList<List<Integer>>();

	public int getMinimumEditDistance(String str1, String str2) {
		
		int[][] result = new int[str1.length()+1][str2.length()+1];
		
		// initialize matrix
		for(int i = 0; i <= str1.length(); i++) {
			result[i][0] = i;
		}
		
		for(int j = 0; j <= str2.length(); j++) {
			result[0][j] = j;
		}
		
		
		for(int i = 1; i <= str1.length(); i++) {
			for(int j = 1; j <= str2.length(); j++) {
				if(str1.charAt(i-1) == str2.charAt(j-1)) {
					result[i][j] = result[i-1][j-1]; 
				} else {
					result[i][j] = Math.min(result[i-1][j-1], Math.min(result[i-1][j], result[i][j-1])) + 1;
				}
			}
		}
		
		
		/*for(int i = 0; i <= str1.length(); i++) {
			for(int j = 0; j <= str2.length(); j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}*/
		
		
		// trace back
		int currentRow = str1.length();
		int currentColumn = str2.length();
		
		// replace = 1, remove = 2, add = 3 
		instructions = new ArrayList<List<Integer>>();
		while(currentRow > 0 && currentColumn > 0) {
			if(result[currentRow][currentColumn] == result[currentRow-1][currentColumn-1] && str1.charAt(currentRow-1) == str2.charAt(currentColumn-1)) {
				currentRow--;
				currentColumn--;
			} else if(result[currentRow][currentColumn] == result[currentRow-1][currentColumn-1] + 1) {
				//System.out.println("replace "+str1.charAt(currentRow-1) + " in first string with "+str2.charAt(currentColumn-1) + " in second string");
				
				List<Integer> code = new ArrayList<Integer>();
				code.add(1);code.add(currentRow-1);code.add(currentColumn-1);
				instructions.add(code);
				
				currentRow--;
				currentColumn--;
				
			} else if(result[currentRow][currentColumn] == result[currentRow][currentColumn-1] + 1) {
				//System.out.println("remove "+str2.charAt(currentColumn-1) + " in second string; OR add "+str2.charAt(currentColumn-1) + " in first string");
				
				List<Integer> code = new ArrayList<Integer>();
				code.add(2);code.add(-1);code.add(currentColumn-1);
				instructions.add(code);
				
				currentColumn--;
			} else {
				//System.out.println("remove "+str1.charAt(currentRow-1) + " in first string; OR add "+ str1.charAt(currentRow-1) + " in second string");
				
				List<Integer> code = new ArrayList<Integer>();
				code.add(2);code.add(currentRow-1);code.add(-1);
				instructions.add(code);
				
				currentRow--;
			}
		}
		
		// minimum edit distance
		return result[str1.length()][str2.length()];
		
	}
}
