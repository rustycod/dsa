package org.sample.algo.dp;

import static org.junit.Assert.*;

import org.junit.Test;

public class MatrixMultiplicationCostTest {
	
	@Test
	public void testGetMaxValue() {
		
		MatrixMultiplicationCost mmc = new MatrixMultiplicationCost();
		
		// case 1
		int[] arr1 = {4, 2, 3, 5, 3}; // this represents 4 matrices of [4,2], [2,3], [3,5], [5,3]
		assertTrue(84 == mmc.findCost(arr1));
		
		// case 2
		int[] arr2 = {2, 3, 6, 4, 5};
		assertTrue(124 == mmc.findCost(arr2));
		
		
		// case 3
		int[] arr3 = {1, 2, 3, 4};
		assertTrue(18 == mmc.findCost(arr3));
		
	}
}
