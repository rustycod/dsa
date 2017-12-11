package org.sort;

// implementation of Lomuto's algorithm
// Note 1: pivot is swapped in the end

public class QuickSortLomuto {

	public static void sort(int[] arr, int start, int end) {
		
		// base condition
		if(start >= end) return; // equal sign added as no need to sort a single element
		
		int pivot = partition(arr, start, end);
		
		// recursive calls 
		sort(arr, start, pivot - 1);
		sort(arr, pivot + 1, end);
		
	}
	
	public static int partition(int[] arr, int start, int end) {
		
		int pivot = arr[end];
		
		int i = start - 1;

		for(int j = start; j < end; j++) {
			if(arr[j] <= pivot) {
				i++;
				
				// swap i + 1 with value at j
				int temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
			}
		}
		
		// swap i + 1 with pivot (index 0 to i has smaller or equal value to pivot, i + 1 to end - 1 have greater values, so it's time to keep pivot at right place
		int temp = arr[end];
		arr[end] = arr[i + 1];
		arr[i + 1] = temp;		
		
		return i + 1;
	}
}
