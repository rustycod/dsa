package org.sample.algo.dp;

import static org.junit.Assert.*;

import org.junit.Test;

public class SubsetSumTest {
	
	@Test
	public void testGetSubsetSum() {
		
		SubsetSum subsetSum = new SubsetSum();
		
		// case 1
		int[] arr1 = {2, 3, 4, 5, 12, 34};
		int[] result1 = subsetSum.getSubsetSum(arr1, 9);
		int[] expected1 = new int[]{0, 0, 0, 2, 3, 4};
		assertArrayEquals(expected1, result1);

		// case 2
		int[] arr2 = {2, 3, 7, 8, 10};
		int[] result2 = subsetSum.getSubsetSum(arr2, 11);
		int[] expected2 = new int[]{0, 0, 0, 3, 8};
		assertArrayEquals(expected2, result2);		

		// case 3
		int[] arr3 = {2, 3, 7, 8, 10};
		int[] result3 = subsetSum.getSubsetSum(arr3, 14);
		int[] expected3 = new int[0];
		assertArrayEquals(expected3, result3);

		// case 4
		int[] arr4 = {3, 34, 4, 12, 5, 2};
		int[] result4 = subsetSum.getSubsetSum(arr4, 9);
		int[] expected4 = new int[]{0, 0, 0, 0, 4, 5};
		assertArrayEquals(expected4, result4);	
	
	}
}
