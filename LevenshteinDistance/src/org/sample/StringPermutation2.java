package org.sample;

public class StringPermutation2 {

	public static void permutation(char[] str, int start, int end) {
		
		// base case
		if (start == end) {
			System.out.println(str);
		}
		
		for(int j = start; j <= end; j++) {
			swap(str, start, j);
			permutation(str, start + 1, end);
			swap(str, j, start); // backtracking
		}
	}
	
	public static void main (String[] args) {
		/*char[] str = new char[]{'A', 'B', 'C'};
		permutation(str, 0, 2);*/
		
		char[] str = new char[]{'A', 'B', 'C', 'D'};
		permutation(str, 0, 3);
	}
	
	private static void swap(char[] str, int position1, int position2) {
		char temp = str[position1];
		str[position1] = str[position2];
		str[position2] = temp;
	}
}
