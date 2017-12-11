package org.sample.search;

import static org.junit.Assert.*;

import org.junit.Test;

public class MaxSumArrayTest {

	@Test
	public void testMaxSumArray() {
		Binary obj = new Binary();

		// case 1
		obj = new Binary();
		int[] arr1 = new int[]{-2, 11, -4, 13, -5, 2};
		assertTrue(obj.getMaxSum(arr1) == 20);
		int[] expected1 = new int[]{20, 1, 3};
		assertArrayEquals(expected1, obj.getMaxSumWithIndices(arr1));
		
		// case 2
		obj = new Binary();
		int[] arr2 = new int[]{1, -3, 4, -2, -1, 6};
		assertTrue(obj.getMaxSum(arr2) == 7);
		int[] expected2 = new int[]{7, 2, 5};
		assertArrayEquals(expected2, obj.getMaxSumWithIndices(arr2));

		// case 3
		obj = new Binary();
		int[] arr3 = new int[]{-2, -3, 4, -1, -2, 1, 5, -3};
		assertTrue(obj.getMaxSum(arr3) == 7);
		int[] expected3 = new int[]{7, 2, 6};
		assertArrayEquals(expected3, obj.getMaxSumWithIndices(arr3));
		
		// case 4
		obj = new Binary();
		int[] arr4 = new int[]{1, -3, 2, 1, -1};
		assertTrue(obj.getMaxSum(arr4) == 3);
		int[] expected4 = new int[]{3, 2, 3};
		assertArrayEquals(expected4, obj.getMaxSumWithIndices(arr4));

		// case 5
		obj = new Binary();
		int[] arr5 = new int[]{-4, 15, -6, 18, 2, -20};
		assertTrue(obj.getMaxSum(arr5) == 29);
		int[] expected5 = new int[]{29, 1, 4};
		assertArrayEquals(expected5, obj.getMaxSumWithIndices(arr5));
		
		// case 6
		obj = new Binary();
		int[] arr6 = new int[]{1, 2, 3, 4, 5};
		assertTrue(obj.getMaxSum(arr6) == 15);
		int[] expected6 = new int[]{15, 0, 4};
		assertArrayEquals(expected6, obj.getMaxSumWithIndices(arr6));
		
		// case 7
		obj = new Binary();
		int[] arr7 = new int[]{-2, -1, 5, -1, -2};
		assertTrue(obj.getMaxSum(arr7) == 5);
		int[] expected7 = new int[]{5, 2, 2};
		assertArrayEquals(expected7, obj.getMaxSumWithIndices(arr7));
	}

}
