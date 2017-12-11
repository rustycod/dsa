package org.sample.algo.dp;


/**
 * Assumption: nodes array is in increasing order
 * 
 * Timing Complexity: O(n ^ 4) as sum is also being calculated each time
 * Space Complexity: O(n ^ 2)
 *
 */
public class OptimalBST {
	
	public int getOptimalCost(int[] nodes, int[] freq) {
		
		int[][] result = new int[nodes.length][freq.length]; // to maintain cost
		int[][] root = new int[nodes.length][freq.length]; // to track roots of optimal BST
		
		
		// initializing root matrix
		for(int i = 0; i < nodes.length; i++) {
			for(int j = 0; j < nodes.length; j++) {
				root[i][j] = -1;
				
				if(i == j) {
					root[i][j] = i;
				}
			}
		}
		
		// initializing result matrix
		for(int i = 0; i < nodes.length; i++) {
			result[i][i] = freq[i];
		}
		
		
		// core logic
		for(int l = 2; l <= nodes.length; l++) {
			
			for(int i = 0; i <= (nodes.length - l); i++) {
				int j = i + l - 1;
				
				int minCost = Integer.MAX_VALUE;
				
				// sum from i to j elments
				int sum = 0;
				for(int index = i; index <= j; index++) {
					sum += freq[index];
				}
				
				int currentRoot = 0;
				
				for(int k = i; k <= j; k++) {
					
					int cost = Integer.MAX_VALUE;
					
					if(k == i) {
						cost = result[k+1][j];
					} else if(k == j) {
						cost = result[i][k-1];
					} else {
						cost = result[i][k-1] + result[k+1][j];
					}
					
					cost += sum;
					
					if(cost < minCost) {
						minCost = cost;
						currentRoot = k;
					}
				}
				
				
				result[i][j] = minCost;
				root[i][j] = currentRoot; // maintain current root as well
			}
		}
		
	
		// trace optimal BST
		preOrder = new int[nodes.length];
		index = 0;
		// pre-order traversal of Optimal BST
		preOrderTraversal(root, nodes, 0, nodes.length - 1);
		
		
		// minimum cost of optimal BST
		return result[0][nodes.length - 1]; 
	}
	
	
	public int[] preOrder;
	private int index = 0;
	public void preOrderTraversal(int[][] root, int[] nodes, int row, int column) {
		
		// base case
		if(row > column) {
			return;
		}


		int currRoot = root[row][column];
		preOrder[index++] = nodes[currRoot];
		//System.out.println("currRoot "+nodes[currRoot]);
		
		preOrderTraversal(root, nodes, row, currRoot-1);
		preOrderTraversal(root, nodes, currRoot+1, column);
	}
}
