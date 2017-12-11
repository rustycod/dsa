package org.sample.search;

import java.util.Arrays;

// Problem 29
public class ThreeSumVariation1 {
	
	public void printTriplets(int[] arr) {
		
		// square each element
		for(int i = 0; i < arr.length; i++) {
			arr[i] = arr[i] * arr[i];
		}

		Arrays.sort(arr);
		
		printArray(arr);
		
		int size = arr.length;
		
		for(int i = size - 1; i > 1; i--) {
			
			int start = 0;
			int end = i - 1;
			
			while (start < end) {
				if(arr[i] == arr[start] + arr[end]) {
					System.out.println(arr[i] +" ("+i+"), "+ arr[start] +" ("+start+"), "+ arr[end]+" ("+end+")");
					start++;
				} else if (arr[i] > arr[start] + arr[end]){
					start++;
				} else { 
					end--;
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
		
		ThreeSumVariation1 obj = new ThreeSumVariation1();

		// case 1
		System.out.println("case 1: ");
		int[] arr = {1, 4, 45, 6, 10, 8};
		obj.printTriplets(arr);

		// case 2
		System.out.println("case 2: ");
		int[] arr2 = {1, 3, 5, 9, 10};
		obj.printTriplets(arr2);
		
		// case 3
		System.out.println("case 3: ");
		int[] arr3 = {0, 1, 2, 4};
		obj.printTriplets(arr3);
		
	}
}
