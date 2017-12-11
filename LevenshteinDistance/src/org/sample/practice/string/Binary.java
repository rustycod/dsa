package org.sample.practice.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Binary {
	
	List<String> resultList = new ArrayList<String>(); // for junit

	/**
	 * 
	 * It generates permutations of given length with numbers in it as per base
	 * 
	 * @param length lenght of the permutations generated.
	 * 		In case of 3, all permutations of length 3 will be generated
	 * 		In case of 4, all permutations of length 4 will be generated  
	 * @param level pass zero value to it. It has been kept here so that 
	 * 		no global variable required during recursive calls
	 * @param result int array containing the result of each possible permutation 
	 * @param base
	 * 		For example, base 2 is binary and it means possible numbers could be {0, 1}
	 * 		base 10 is decimal and it means possible numbers could be {0, 1, 2, 3, ...., 9}
	 * 		base 8 is octal and base 16 is hexa-decimal 
	 */
	public void binary(int length, int level, int[] result, int base) {
		
		if(level == length) {
			// print
			//print(result);
			
			// for junit
			prepareResult(result);
				
			return; // return of base case
		}
		
		for(int i = 0; i < base; i++) {
			
			result[level] = i;
			binary(length, level + 1, result, base);
		}
	}
	

	/**
	 * 
	 * It generates all possible combinations of 0 and 1 (if base is 2) of all the lengths from 1 to input arg length
	 * It doesn't include the case with empty string 
	 * 
	 * @param length maximum length of result, For example:
	 * 		In case of 3, the result will contain all the results from length 1 to 3
	 * 		In case of 4, the result will contain all the results from length 1 to 4
	 * @param level pass zero value to it. It has been kept here so that 
	 * 		no global variable required during recursive calls
	 * @param result int array containing the result of each possible combination 
	 * @param base 
	 * 		For example, base 2 is binary and it means possible numbers could be {0, 1}
	 * 		base 10 is decimal and it means possible numbers could be {0, 1, 2, 3, ...., 9}
	 * 		base 8 is octal and base 16 is hexa-decimal
	 */
	public void binaryComb(int length, int level, int[] result, int base) {
		
		if(level == length) {

			return; // return of base case
		}
		
		for(int i = 0; i < base; i++) {
			result[level] = i;
			
			// print
			//print(result, level);
			
			// for junit
			prepareResult(result, level);
			
			binaryComb(length, level + 1, result, base);
		}
	}
	
	
	// for junit
	private void prepareResult(int[] result) {
		String arrayStr = Arrays.toString (result);
		arrayStr = arrayStr.substring(1, arrayStr.length() - 1);
		arrayStr = arrayStr.replace(",", "");
		arrayStr = arrayStr.trim();
		arrayStr = arrayStr.replace(" ", "");
		resultList.add(arrayStr);
	}
	
	
	// for junit
	private void prepareResult(int[] result, int endIndex) {
		String arrayStr = Arrays.toString (result);
		arrayStr = arrayStr.replace(",", "");
		arrayStr = arrayStr.replace(" ", "");
		arrayStr = arrayStr.substring(1, endIndex + 2);
		arrayStr = arrayStr.trim();
		resultList.add(arrayStr);
	}
	
	// print
	private void print(int[] result) {
		for(int i = 0; i < result.length; i++) {
			System.out.print(result[i]);
		}
		System.out.println();
	}
	
	
	// print
	private void print(int[] result, int endIndex) {
		for(int i = 0; i < endIndex + 1; i++) {
			System.out.print(result[i]);
		}
		System.out.println();
	}
}
