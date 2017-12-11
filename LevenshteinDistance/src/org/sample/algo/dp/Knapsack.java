package org.sample.algo.dp;

/**
 * 0/1 Knapsack problem, also known as integer knapsack problem
 * (that means either an element can be present or not)
 *
 *	Assumptions: weight array contains the elements in increasing order of weight
 *
 * Time Complexity: O(number of items x totalWeight)
 * Space Complexity: O(number of items x totalWeight) 
 * 
 */
public class Knapsack {
	
	public int[] itemsPicked; // for junit purpose

	public int getMaxValue(int[] weight, int[] value, int totalWeight) {
		
		int[][] result = new int[weight.length + 1][totalWeight + 1];
		
		for(int row = 1; row <= weight.length; row++) {
			for(int column = 1; column <= totalWeight; column++) {
				
				if(weight[row - 1] > column) {
					result[row][column] = result[row - 1][column];
				} else {
					// option 1 - picking current element
					int option1 = value[row - 1] + result[row - 1][column - weight[row - 1]];
					
					// option 2 - not picking current element
					int option2 = result[row - 1][column];
					
					result[row][column] = Math.max(option1, option2);
				}
			}
		}
	
		
		// print the array for explanation sake
		for(int row = 0; row <= weight.length; row++) {
			for(int column = 0; column <= totalWeight; column++) {
				System.out.print(result[row][column] + " ");
			}
			System.out.println();
		}
		
		
		// trace back the elements
		int currentRow = weight.length;
		int currentColumn = totalWeight;
		itemsPicked = new int[weight.length];
		int index = 0;
		
		while(currentRow >= 1 && currentColumn >= 1) {
			
			if(result[currentRow][currentColumn] > result[currentRow - 1][currentColumn]) {
				//System.out.println("item picked: "+weight[currentRow - 1]); // weight array is zero-indexed
				itemsPicked[index++] = weight[currentRow - 1];
				currentColumn = currentColumn - weight[currentRow - 1];
				currentRow--;
			} else {
				currentRow--;
			}
		}
		
		
		return result[weight.length][totalWeight]; 
	}
}
