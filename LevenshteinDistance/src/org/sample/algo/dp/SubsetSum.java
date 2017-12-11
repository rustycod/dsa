package org.sample.algo.dp;


/**
 * input array must contain items in increasing order
 * 
 * Timing Complexity: O(number of elements * sum)
 * Space Complexity: O(number of elements * sum) 
 * 
 *
 */
public class SubsetSum {

	public int[] getSubsetSum(int[] arr, int sum) {
		
		boolean[][] result = new boolean[arr.length + 1][sum + 1];
		
		for(int i = 0; i <= arr.length; i++) {
			result[i][0] = true;
		}
		
		for(int i = 1; i <= arr.length; i++) {
			for(int j = 1; j <= sum; j++) {
				if(arr[i-1] > j) {
					result[i][j] = result[i-1][j];
				} else {
					result[i][j] = result[i-1][j] || result[i-1][j - arr[i-1]];
				}
			}
		}
		
		
		
		// print (only for explanation purpose)
		System.out.println("result: ");
		for(int i = 0; i <= arr.length; i++) {
			for(int j = 0; j <= sum; j++) {
				if(result[i][j] == true) {
					System.out.print(result[i][j] + "  ");
				} else {
					System.out.print(result[i][j] + " ");
				}
			}
			System.out.println();
		}
		
		
		if(result[arr.length][sum] == false) {
			return new int[0]; // that means given sum doesn't exist
		}

		
		// trace items (as solution exists if flow reaches this line)
		
		int currentRow = arr.length;
		int currentColumn = sum;
		int[] selectedItems = new int[arr.length];
		int index = arr.length - 1;
		
		while(true) {
			
			if(currentRow == 0 && currentColumn == 0) {
				break;
			}
			if(result[currentRow - 1][currentColumn] == true) {
				currentRow--;
			} else {
				selectedItems[index--] = arr[currentRow - 1];
				currentColumn = currentColumn - arr[currentRow - 1];
			}
		}
		

		
		System.out.println("Possible? "+result[arr.length][sum]);
		return selectedItems;
	}
	
}
