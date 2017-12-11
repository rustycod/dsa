package org.sample.search;

import java.util.Arrays;

public class TwoSumClosest {
	
	public void twoSumClosest(int[] arr, int target) {
		
		int size = arr.length;
		
		Arrays.sort(arr);
		
		int start = 0;
		int end = size - 1;
		
		int positiveDistance = Integer.MAX_VALUE;
		int negativeDistance = Integer.MIN_VALUE;
		
		while (start < end) {
			
			int currentSum = arr[start] + arr[end];
			if(currentSum > target) {
				end--;
				if(currentSum < positiveDistance) {
					positiveDistance = currentSum;
				}
			} else if(currentSum < target) {
				start++;
				if(currentSum > negativeDistance) {
					negativeDistance = currentSum;
				}				
			} 
		}
		
		System.out.println("result: "+Math.min(positiveDistance, negativeDistance * -1));
		
		
		
	}
	
	public static void main (String[] args) {
		
		TwoSumClosest obj = new TwoSumClosest();
		int[] arr = {1, 60, -10, 70, -80, 85};
		obj.twoSumClosest(arr, 0);
	}

}
