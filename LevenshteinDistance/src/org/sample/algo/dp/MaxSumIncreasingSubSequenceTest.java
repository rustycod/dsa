package org.sample.algo.dp;

import static org.junit.Assert.*;

import org.junit.Test;

public class MaxSumIncreasingSubSequenceTest {

	@Test
	public void testMaxSumArray() {
		MaxSumIncreasingSubSequence obj;

		// case 1
		obj = new MaxSumIncreasingSubSequence();
		int[] arr1 = new int[]{4, 6, 1, 3, 8, 4, 6};
		assertTrue(obj.getMaxSumIncreasingSubSequence(arr1) == 18);
		int[] expected1 = new int[]{8, 6, 4, 0, 0, 0, 0};
		assertArrayEquals(expected1, obj.elements);

	}

}
