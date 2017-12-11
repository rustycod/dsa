package org.sample.algo.dp;


/**
 * 
 * Time Complexity: O(n^3)
 * Auxiliary Space: O(n^2)
 *
 */
public class MatrixMultiplicationCost {
	
	public int findCost(int[] arr) {
		
		int[][] result = new int[arr.length][arr.length];
		int[][] subMatrix = new int[arr.length][arr.length]; // to track partitions 
		
		for(int l = 2; l < arr.length; l++) {
			
			for(int i = 0; i < arr.length - l; i++) {
				int j = i + l;
				
				int minCost = Integer.MAX_VALUE;
				int part = -1;
				for(int k = i + 1; k < j; k++) {
					int cost = result[i][k] + result[k][j] + arr[i]*arr[k]*arr[j];
					
					if(minCost > cost) {
						minCost = cost;
						part = k;
					}
				}
				
				result[i][j] = minCost;
				subMatrix[i][j] = part;
			}
		}
		
		
		System.out.println("submatrix: ");
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr.length; j++) {
				System.out.print(subMatrix[i][j] + " ");
			}
			System.out.println();
		}
		
		
		//System.out.println("submatrix: "+printMatrices(subMatrix, 0, arr.length - 1));
		
		return result[0][arr.length - 1];
		
	}
	
	
	
	/*public String printMatrices(int[][] subMatrix, int row, int column) {
		
		if(row == column - 1) {
			return ""+column;
		} else if(row == column) {
			return "";
		}
		
		return "("+row+"," + printMatrices(subMatrix, row, subMatrix[row][column]) + ")("+ printMatrices(subMatrix, subMatrix[row][column], column) + "," + column + ")";
	}*/
		


    
}
