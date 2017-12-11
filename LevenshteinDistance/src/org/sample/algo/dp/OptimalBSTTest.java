package org.sample.algo.dp;

import static org.junit.Assert.*;

import org.junit.Test;

public class OptimalBSTTest {
	
	@Test
	public void testGetOptimalCost() {
		
		OptimalBST optimalBST = new OptimalBST();
		
		// case 1
		int[] arr1 = {10, 12, 20};
		int[] freq1 = {34, 8, 50};
		assertTrue(142 == optimalBST.getOptimalCost(arr1, freq1));
		//System.out.println("result1: "+optimalBST.getOptimalCost(arr1, freq1));
		int[] expected1 = new int[]{20, 10, 12};
		assertArrayEquals(expected1, optimalBST.preOrder);
		
		// case 2
		int[] arr2 = {10, 12};
		int[] freq2 = {34, 50};
		//System.out.println("result2: "+optimalBST.getOptimalCost(arr2, freq2));
		assertTrue(118 == optimalBST.getOptimalCost(arr2, freq2));
		int[] expected2 = new int[]{12, 10};
		assertArrayEquals(expected2, optimalBST.preOrder);

		// case 3
		int[] arr3 = {10, 12, 16, 21};
		int[] freq3 = {4, 2, 6, 3};
		//System.out.println("result3: "+optimalBST.getOptimalCost(arr3, freq3));
		assertTrue(26 == optimalBST.getOptimalCost(arr3, freq3));
		int[] expected3 = new int[]{16, 10, 12, 21};
		assertArrayEquals(expected3, optimalBST.preOrder);
		
		// case 4
		int[] arr4 = {10, 12, 20, 35, 46};
		int[] freq4 = {34, 8, 50, 21, 16};
		//System.out.println("result4: "+optimalBST.getOptimalCost(arr4, freq4));
		assertTrue(232 == optimalBST.getOptimalCost(arr4, freq4));
		int[] expected4 = new int[]{20, 10, 12, 35, 46};
		assertArrayEquals(expected4, optimalBST.preOrder);
	}
}
