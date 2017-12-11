package org.sample.algo.dp;

import static org.junit.Assert.*;

import org.junit.Test;

public class KnapsackTest {
	
	@Test
	public void testGetMaxValue() {
		
		Knapsack knapsack = new Knapsack();
		
		// case 1
		int[] weight1 = {1, 3, 4, 7};
		int[] value1 = {1, 4, 5, 7};
		int totalWeight1 = 7;
		assertTrue(9 == knapsack.getMaxValue(weight1, value1, totalWeight1));
		int[] expected1 = new int[]{4, 3, 0, 0};
		assertArrayEquals(expected1, knapsack.itemsPicked);
		
		// case 2
		int[] weight2 = {10, 20, 30};
		int[] value2 = {60, 100, 120};
		int totalWeight2 = 50;
		assertTrue(220 == knapsack.getMaxValue(weight2, value2, totalWeight2));
		int[] expected2 = new int[]{30, 20, 0};
		assertArrayEquals(expected2, knapsack.itemsPicked);
		
	}
}
