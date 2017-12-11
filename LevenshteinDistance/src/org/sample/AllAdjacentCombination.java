package org.sample;


public class AllAdjacentCombination {

	public static void combination(int[] numArray, int[] result,  int resultCount, int start, int end, int k, int size, int index) {
		
		// base condition
		if(size == numArray.length) {
			// print result array
			for(int i = 0; i < resultCount; i++) {
				System.out.print(result[i] + ",");
			}
			System.out.println();
			return;
		}
		 
		/*if(size <= numArray.length - 1) {
			result[index] = numArray[start];
			combination(numArray, result, resultCount + 1, start + 1, end, k, size + 1, index + 1);
		}
			
		if(size <= numArray.length - 2) {
			result[index] = 10*numArray[start] + numArray[start+1];
			combination(numArray, result, resultCount + 1, start + 2, end, k, size + 2, index + 1);
		}*/
		
		for(int i = 1; i <= k && size <= numArray.length - i; i++) {
			
			int pos = k;
			int currIndex = 0;
			while(pos > 0 && currIndex < i && start + currIndex < numArray.length) {
				result[index] += Math.pow(10, pos - 1) * numArray[start + currIndex];
				pos--;
				currIndex++;
			}
			
			if(i == 1) {
				result[index] = numArray[start];
			}
			
			if(i == 2) {
				result[index] = 10*numArray[start] + numArray[start+1];
			}
			
			combination(numArray, result, resultCount + 1, start + i, end, k, size + i, index + 1);
		}
	}
	
	public static void main(String[] args) {
		//int[] numArray = {1, 2, 3, 4};
		int[] numArray = {0, 1, 2, 3};
		int[] result = new int[numArray.length];
		combination(numArray, result, 0, 0, numArray.length - 1, 2, 0, 0);
		
	}
}
