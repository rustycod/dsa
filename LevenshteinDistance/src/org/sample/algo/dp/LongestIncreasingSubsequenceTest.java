package org.sample.algo.dp;

import static org.junit.Assert.*;

import org.junit.Test;

public class LongestIncreasingSubsequenceTest {

	@Test
	public void testGetLongestIncreasingSubsequence() {
		
		LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
		
		// case 1
		int[] arr1 = new int[]{9, 1, 3, 7, 5, 6, 20};
		int[] result1 = lis.getLongestIncreasingSubsequence(arr1);
		
		assertTrue(result1.length == 5);
		int[] expected1 = new int[]{1, 3, 5, 6, 20};
		assertArrayEquals(expected1, result1);
		
		
		// case 2
		int[] arr2 = new int[]{7, 6, 5, 4, 3, 2, 1};
		int[] result2 = lis.getLongestIncreasingSubsequence(arr2);
		
		assertTrue(result2.length == 1);
		int[] expected2 = new int[]{7};
		assertArrayEquals(expected2, result2);
		
		
		// case 3
		int[] arr3 = new int[]{};
		int[] result3 = lis.getLongestIncreasingSubsequence(arr3);
		
		assertTrue(result3.length == 0);
		int[] expected3 = new int[]{};
		assertArrayEquals(expected3, result3);
		
		
		// case 4
		int[] result4 = lis.getLongestIncreasingSubsequence(null);
		
		assertTrue(result4.length == 0);
		int[] expected4 = new int[]{};
		assertArrayEquals(expected4, result4);
		
		
		// case 5
		int[] arr5 = new int[]{3, 4, -1, 0, 6, 2, 3};
		int[] result5 = lis.getLongestIncreasingSubsequence(arr5);
		
		assertTrue(result5.length == 4);
		int[] expected5 = new int[]{-1, 0, 2, 3};
		assertArrayEquals(expected5, result5);
		
		
		// case 6
		int[] arr6 = new int[]{2, 5, 1, 8, 3};
		int[] result6 = lis.getLongestIncreasingSubsequence(arr6);
		
		assertTrue(result6.length == 3);
		int[] expected6 = new int[]{2, 5, 8};
		assertArrayEquals(expected6, result6);
		
		
		// case 7
		int[] arr7 = {23,10,22,5,33,8,9,21,50,41,60,80,99, 22,23,24,25,26,27};
		int[] result7 = lis.getLongestIncreasingSubsequence(arr7);
		
		assertTrue(result7.length == 10);
		int[] expected7 = {5, 8, 9, 21, 22, 23, 24, 25, 26, 27};
		assertArrayEquals(expected7, result7);
		
		
		// case 8
		int[] arr8 = {10, 9, 2, 5, 3, 7, 101, 18};
		int[] result8 = lis.getLongestIncreasingSubsequence(arr8);
		
		assertTrue(result8.length == 4);
		int[] expected8 = {2, 5, 7, 101};
		assertArrayEquals(expected8, result8);

		
		// case 9
		int[] arr9 = {10, 22, 9, 33, 21, 50, 41, 60, 80};
		int[] result9 = lis.getLongestIncreasingSubsequence(arr9);
		assertTrue(result9.length == 6);
		int[] expected9 = {10, 22, 33, 50, 60, 80};
		assertArrayEquals(expected9, result9);
		
	}
}
