package org.sample.dp;

public class LCS {
	
	public int lcsSize = 0; // for junit purpose

	public int[] findLCS(int[] inputArr) {

		int[] indexArr = new int[inputArr.length];
		
		int[] countArr = new int[inputArr.length];

		// initialize countArr to 1
		for(int i = 0; i < countArr.length; i++) {
			countArr[i] = 1;
		}
		
		int max = 1;
		int maxIndex = 0;
		
		for(int i = 1; i < inputArr.length; i++) {
			for(int j = 0; j < i; j++) {
				if(inputArr[j] < inputArr[i]) {
					if(countArr[i] < countArr[j] + 1) {
						countArr[i] = countArr[j] + 1;
						indexArr[i] = j;						
					}

					if(max < countArr[i]) {
						max = countArr[i];
						maxIndex = i;
					}
				}
			}
		}

		System.out.println("length of lcs: "+max+" with last value at index: "+maxIndex);
		lcsSize = max;
		
		// print lcs
		int[] lcsArr = new int[max];
		
		int currIndex = maxIndex;
		while(true) {

			//System.out.print(inputArr[currIndex] + " ");
			lcsArr[--max] = inputArr[currIndex];
			currIndex = indexArr[currIndex];

			if(currIndex == indexArr[currIndex]) {
				//System.out.print(inputArr[currIndex] + " ");
				lcsArr[--max] = inputArr[currIndex];
				break;
			}
		}
		
		// print lcs
		for(int i = 0; i < lcsArr.length; i++) {
			System.out.print(lcsArr[i] + " ");
		}
		System.out.println();
		
		return lcsArr;
		
	}
	
	
	public static void main(String[] args) {
		
		int[] inputArr = {10, 22, 9, 33, 21, 50, 41, 60, 80};
		LCS lcs = new LCS();
		lcs.findLCS(inputArr);
		
		int[] inputArr2 = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
		lcs.findLCS(inputArr2);
	}
}
