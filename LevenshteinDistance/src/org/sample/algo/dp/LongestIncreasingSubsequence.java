package org.sample.algo.dp;


/**
 * Timing Complexity: O(n^2)
 * 
 * Space Complexity: O(n)
 *
 * If there are multiple LIS, this program will return only one that gets 
 * calculated first.
 */
public class LongestIncreasingSubsequence {

	public int[] getLongestIncreasingSubsequence(int[] arr) {
		
		// corner case 
		if(arr == null || arr.length == 0) {
			return new int[]{};
		}
		
		int[] lisArray = new int[arr.length];
		int[] lisIndexArray = new int[arr.length];
		
		for(int i = 0; i < lisArray.length; i++) {
			lisArray[i] = 1;
			lisIndexArray[i] = i;
		}
		
		int maxLength = 1;
		int maxLengthIndex = 0;
		
		for(int j = 1; j < arr.length; j++) {
			for(int i = 0; i < j; i++) {
				
				if(arr[j] > arr[i] && lisArray[j] < lisArray[i] + 1) {
					lisArray[j] = lisArray[i] + 1;
					lisIndexArray[j] = i;
					
					if(maxLength < lisArray[j]) {
						maxLength = lisArray[j];
						maxLengthIndex = j;
						
					}
				}
			}
		}
		
		
		int[] result = new int[maxLength];
		int lengthResult = maxLength;
		while(lisIndexArray[maxLengthIndex] != maxLengthIndex) {
			result[lengthResult - 1] = arr[maxLengthIndex];
			maxLengthIndex = lisIndexArray[maxLengthIndex];
			lengthResult--;
		}
		
		result[lengthResult - 1] = arr[maxLengthIndex];
		
		return result; 
	}
	
	
}
