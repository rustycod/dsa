package org.sample;

public class BinaryStrings {
	
	private int[] intArray = new int[3];

	public void binary (int n) {
		if (n < 1) {
			printArray(intArray);
			return;
		} 
		
		intArray[n - 1] = 0;
		binary(n - 1);
		intArray[n - 1] = 1;
		binary(n - 1);
	}
	
	private void printArray (int[] intArray) {
		for (int i =0; i < intArray.length; i++) {
			System.out.print(intArray[i]);
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		BinaryStrings obj = new BinaryStrings();
		obj.binary(3);
	}
	
}

