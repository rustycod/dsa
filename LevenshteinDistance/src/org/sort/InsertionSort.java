package org.sort;

public class InsertionSort {

	public static void sort(int[] arr) {
		
		for(int i = 1; i < arr.length; i++) {
			int currentIndex = i;
			while(currentIndex >= 1 && arr[currentIndex-1] > arr[currentIndex]) {
				// swap
				int temp = arr[currentIndex];
				arr[currentIndex] = arr[currentIndex-1];
				arr[currentIndex-1] = temp;
				currentIndex--;
			}
		}
	}
}
