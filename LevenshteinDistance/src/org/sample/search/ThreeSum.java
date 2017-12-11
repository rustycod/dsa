package org.sample.search;

import java.util.Arrays;

public class ThreeSum {
	
	public void printTriplets(int[] arr, int requiredSum) {
		
		Arrays.sort(arr);
		printArray(arr);
		int size = arr.length;
		
		for(int i = 0; i < size - 2; i++) {
			
			// don't process duplicates
			if(i != 0) {
				if(arr[i] == arr[i-1]) {
					continue;
				}
			}
			
			int start = i + 1;
			int end = size - 1;
			
			while (start < end) {
				if(arr[i] + arr[start] + arr[end] == requiredSum) {
					System.out.println(arr[i] +" ("+i+"), "+ arr[start] +" ("+start+"), "+ arr[end]+" ("+end+")");
					start++;
				} else if (arr[i] + arr[start] + arr[end] > requiredSum){
					end--;
				} else { // case of requiredSum < 0
					start++;
				}				
			}
		}
	}
	
	
	private void printArray(int[] arr) {
		System.out.print("array: { ");
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ",");
		}
		System.out.println("}");
	}

	
	public static void main (String[] args) {
		
		ThreeSum obj = new ThreeSum();

		// case 1
		System.out.println("case 1: ");
		int[] arr = {1, 4, 45, 6, 10, 8};
		obj.printTriplets(arr, 22);

		// case 2
		System.out.println("case 2: ");
		int[] arr2 = {1, 3, 5, 9, 10};
		obj.printTriplets(arr2, 15);
		
		// case 3
		System.out.println("case 3: ");
		int[] arr3 = {-1, 0, 1, 2, -1, -4};
		obj.printTriplets(arr3, 0);
		
	}
}
