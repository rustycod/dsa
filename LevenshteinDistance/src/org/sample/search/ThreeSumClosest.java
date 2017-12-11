package org.sample.search;

import java.util.Arrays;

public class ThreeSumClosest {

	public void threeSumClosest(int[] arr, int target) {
		
		Arrays.sort(arr);
		
		int size = arr.length;
		int minClosest = Integer.MAX_VALUE;
		
		for(int i=0; i < size-2; i++) {
			
			int start = i + 1;
			int end = size - 1;
			
			while(start < end) {
				
				int currentSum = arr[i] + arr[start] + arr[end];
				int currentClosest = Math.abs(currentSum - target);
				
				if(currentClosest < minClosest) {
					minClosest = currentClosest;
				}
				
				
				
			}
		}
	}
	
}
