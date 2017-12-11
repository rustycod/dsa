package org.sample.algo.dp;

public class LongestCommonSubsequence {

	public String lcs(String str1, String str2) {

		int[][] result = new int[str1.length() + 1][str2.length() + 1];

		for(int row = 1; row <= str1.length(); row++) {
			for(int column = 1; column <= str2.length(); column++) {
				if(str1.charAt(row - 1) == str2.charAt(column - 1)) {
					result[row][column] = result[row-1][column-1] + 1; 
				} else {
					result[row][column] = Math.max(result[row-1][column], result[row][column-1]);
				}
			}
		}


		// print the array for explanation sake
		for(int row = 0; row <= str1.length(); row++) {
			for(int column = 0; column <= str2.length(); column++) {
				System.out.print(result[row][column] + " ");
			}
			System.out.println();
		}
		
		
		// trace back
		int currentRow = str1.length();
		int currentColumn = str2.length();
		char[] lcs = new char[result[currentRow][currentColumn]];
		int index = result[currentRow][currentColumn] - 1;
		
		while(currentRow >= 1 && currentColumn >= 1) {
			
			if(result[currentRow][currentColumn] == result[currentRow - 1][currentColumn]){
				currentRow--;
			} else if(result[currentRow][currentColumn] == result[currentRow][currentColumn-1]) {
				currentColumn--;
			} else {
				// case: result[currentRow][currentColumn] == result[currentRow - 1][currentColumn - 1] + 1
				//System.out.println("char: "+str1.charAt(currentRow - 1)); // weight array is zero-indexed
				lcs[index--] = str1.charAt(currentRow - 1);
				currentRow--;
				currentColumn--;				
			}
		}
		
		
		return new String(lcs);

	}



}
