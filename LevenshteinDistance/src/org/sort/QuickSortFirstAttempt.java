package org.sort;

public class QuickSortFirstAttempt {

	public static void sort(int[] arr, int start, int end) {
		
		// base condition
		if(start >= end) return; // equal sign added as no need to sort a single element
		
		int startIndex = start;
		
		int pivotIndex = end;
		int pivot = arr[end];
		
		end--;
		
		while(start < end) {
			while(arr[start] < pivot && start < end) {
				start++;
			}
			
			while(arr[end] > pivot && start < end) {
				end--;
			}
			
			// swap
			if(start < end) { // swap only if start is smaller than end
				int temp = arr[start];
				arr[start] = arr[end];
				arr[end] = temp;				
			}
		}
		
		if(arr[end] > arr[pivotIndex]) { // swap only if arr[end] is greater than pivot
			int temp = arr[end];
			arr[end] = pivot;
			arr[pivotIndex] = temp;			
		}
		
		// recursive calls 
		sort(arr, startIndex, end - 1);
		sort(arr, end + 1, pivotIndex);
		
	}
}
