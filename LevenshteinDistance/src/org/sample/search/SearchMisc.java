package org.sample.search;

public class SearchMisc {

	// this is for sorted array
	// If there are two elements with same number of duplicate count,
	// first one coming in arr will the the answer
	// RC11006
	public static int findMaxDuplicate(int[] arr) {

		int maxCount = -1;
		int maxElement = -1; // not known yet
		
		int currentMax = 0;
		
		for(int i = 0; i < arr.length - 1; i++) {
			if(arr[i] == arr[i + 1]) {
				currentMax++;
			} else {
				currentMax++;
				if(currentMax > maxCount) {
					maxCount = currentMax;
					currentMax = 0;
					maxElement = arr[i];
				}
			}
		}
		
		System.out.println("maxElement is: " + maxElement + " with count: "+maxCount);
		return maxElement;
	}
	
	// RC11008
	public static int findMaxDuplicate2(int[] arr) {

		int size = arr.length;
		int max = -1;
		int maxIndex = 0;
		
		for(int i = 0; i < arr.length; i++) {
			arr[arr[i] % size] += size;
		}
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] / size > max) {
				max = arr[i] / size;
				maxIndex = i;
			}
		}
		
		return maxIndex;
	}
}
