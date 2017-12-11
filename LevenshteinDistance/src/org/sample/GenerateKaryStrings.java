package org.sample;

public class GenerateKaryStrings {
	
	private int[] intArray = new int[3];

	public void generate (int n, int k) {
		if (n < 1) {
			printArray(intArray);
			return;
		} 
		
		for (int i = 0; i < k; i++){
			intArray[n - 1] = i;
			generate(n - 1, k);
		}

	}
	
	private void printArray (int[] intArray) {
		for (int i =0; i < intArray.length; i++) {
			System.out.print(intArray[i]);
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		GenerateKaryStrings obj = new GenerateKaryStrings();
		obj.generate(3, 3);
	}
	
}
