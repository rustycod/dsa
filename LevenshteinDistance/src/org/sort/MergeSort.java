package org.sort;

public class MergeSort {

	public static int[] sort(int[] arr, int start, int end) {
		
		// base case 
		if(start >= end) return arr;
		
		int mid = start + (end - start) / 2;
		

		int[] arr1 = copyArray(arr, start, mid);
		int[] arr2 = copyArray(arr, mid + 1, end);
		
		//return merge(sort(arr1, start, mid), sort(arr2, mid + 1, end));
		return merge(sort(arr1, start, mid), sort(arr2, 0, end - mid - 1)); // be careful about the start and end index of second arr being sent to sort
		// check the commented line before this for invalid code 
		
	}
	
	// merge two already sorted arrays
	public static int[] merge(int[] arr1 , int[] arr2) {
		
		int sizeMerged = arr1.length + arr2.length;
		int[] arrMerged = new int[sizeMerged];
		
		int index1 = 0;
		int index2 = 0;
		int indexMerged = 0;
		
		while(index1 < arr1.length && index2 < arr2.length) {
			if(arr1[index1] < arr2[index2]) {
				arrMerged[indexMerged++] = arr1[index1++];
			} else {
				arrMerged[indexMerged++] = arr2[index2++];
			}
		}
		
		if(index1 != arr1.length) { // arr1 still has un-merged values
			while(index1 < arr1.length) {
				arrMerged[indexMerged++] = arr1[index1++];
			}
		} else { // arr2 still has un-merged values
			while(index2 < arr2.length) {
				arrMerged[indexMerged++] = arr2[index2++];
			}
		}
		
		return arrMerged;
	}
	
	
	private static int[] copyArray(int[] arr, int start, int end) {
		
		int[] newArray = new int[end - start + 1];
		int count = 0;
		
		for(int i = start; i <= end; i++) {
			newArray[count++] = arr[i];
		}
		
		return newArray;
	}

}


