package org.sample.search;

public class Binary {

	private int startIndex = -1;
	private int endIndex = -1; 
	
	public int getMaxSum(int[] arr) {
		
		int sum = 0;
		int maxSum = 0;
		
		for(int i = 0; i < arr.length; i++) {
			
			sum += arr[i];
			
			if(sum > maxSum) {
				maxSum = sum;
				endIndex = i;
			}
			
			if(sum <= 0) {
				sum = 0;
				startIndex = i;
			}
		}
		
		return maxSum;
	}
	
	
	// wrapper method to return indices as well
	public int[] getMaxSumWithIndices(int[] arr) {
		
		int[] result = new int[3];
		
		result[0] = getMaxSum(arr);
		result[1] = startIndex + 1;
		result[2] = endIndex;
		
		return result;
	}
	

}
