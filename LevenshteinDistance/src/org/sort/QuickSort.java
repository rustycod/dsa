package org.sort;

// implementation of Hoare's algorithm
// Note 1: pivot is not swapped in the end. It gets swapped during while loop only
// Note 2: pivot is set to low, if it's changed to high without code change, program will fail

public class QuickSort {

	public static void sort(int[] arr, int start, int end) {
		
		// base condition
		if(start >= end) return; // equal sign added as no need to sort a single element
		
		int pivot = partition(arr, start, end);
		
		// recursive calls 
		sort(arr, start, pivot);
		sort(arr, pivot + 1, end);
		
	}
	
	public static int partition(int[] arr, int start, int end) {
		
		int pivot = arr[start];
		
		int i = start - 1;
		int j = end + 1;
		
		while(true) {
			do {
				i++;
			} while(arr[i] < pivot);
			
			do {
				j--;
			} while(arr[j] > pivot);
			
			if(i >= j) // that means array is partitioned now
				return j;
			
			// swap
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;				
		}
	}
}
