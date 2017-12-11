package org.sample.algo.dp;

public class MaxSumIncreasingSubSequence {

	int[] elements;
	
	public int getMaxSumIncreasingSubSequence(int[] arr) {
		
		int[] sum = new int[arr.length];
		int[] indices = new int[arr.length];
		
		// populate sum array`
		for(int i = 0; i < arr.length; i++) {
			sum[i] = arr[i];
		}
		
		// populate indices array
		for(int i = 0; i < arr.length; i++) {
			indices[i] = i;
		}
		
		
		//  processing starts here
		for (int i = 1; i < arr.length; i++) {
			for(int j = 0; j < i; j++) {
				
				if(arr[j] < arr[i]) {
					if(sum[i] < sum[j] + arr[i]) {
						sum[i] = sum[j] + arr[i];
						indices[i] = j;
					}
				}
			}
		}
		
		
		// perform one scan to find the max sum
		int maxIndex = 0; 
		int maxSum = 0;
		for(int i = 0; i < sum.length; i++) {
			if(sum[i] > maxSum) {
				maxSum = sum[i];
				maxIndex = i;
			}
		}
		
		
		// list all the elements that are making max-sum LIS
		//System.out.println("max sum is: "+maxSum);
		elements = new int[arr.length]; int count = 0; // for junit
		
		int currIndex = maxIndex;
		//System.out.println("elements: "+arr[currIndex]);
		elements[count++] = arr[currIndex]; // for junit
		
		while(true) {
			currIndex = indices[currIndex];
			//System.out.println("elements: "+arr[currIndex]);
			elements[count++] = arr[currIndex]; // for junit
			if(currIndex == indices[currIndex]) {
				break;
			}
			
		}
		
		
		return maxSum; 
	}
	
	
	
	// wrapper method to return indices as well
	
	
}
