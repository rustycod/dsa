package org.sample.algo.dp;

public class CoinChange {

	public int getCoinChange(int[] arr, int sum) {
		
		int[][] result = new int[arr.length + 1][sum + 1];
		
		for(int i = 0; i <= arr.length; i++) {
			result[i][0] = 1;
		}
		
		for(int i = 1; i <= arr.length; i++) {
			for(int j = 1; j <= sum; j++) {
				
				if(j < arr[i-1]) {
					result[i][j] = result[i-1][j];
				} else {
					result[i][j] = result[i-1][j] + result[i][j - arr[i-1]];
				}
			}
		}
		
		
		// print (only for explanation purpose)
		System.out.println("result: ");
		for(int i = 0; i <= arr.length; i++) {
			for(int j = 0; j <= sum; j++) {
				System.out.print(result[i][j] + "  ");
			}
			System.out.println();
		}
		
		
		return result[arr.length][sum];
	}
}
