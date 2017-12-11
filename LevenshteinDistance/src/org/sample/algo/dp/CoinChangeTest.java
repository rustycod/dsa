package org.sample.algo.dp;

import static org.junit.Assert.*;

import org.junit.Test;

public class CoinChangeTest {
	
	@Test
	public void testGetCoinChange() {
		
		CoinChange coinChange = new CoinChange();
		
		// case 1
		int[] arr1 = {1, 2, 3};
		System.out.println("result1: "+coinChange.getCoinChange(arr1, 4));
		//int[] result1 = coinChange.getCoinChange(arr1, 4);
		//int[] expected1 = new int[]{0, 0, 0, 2, 3, 4};
		//assertArrayEquals(expected1, result1);

		// case 2
		int[] arr2 = {2, 3, 5, 6};
		System.out.println("result2: "+coinChange.getCoinChange(arr2, 10));
		//int[] result1 = coinChange.getCoinChange(arr1, 4);
		//int[] expected1 = new int[]{0, 0, 0, 2, 3, 4};
		//assertArrayEquals(expected1, result1);

		// case 3
		int[] arr3 = {1, 2, 3};
		System.out.println("result3: "+coinChange.getCoinChange(arr3, 5));
		//int[] result1 = coinChange.getCoinChange(arr1, 4);
		//int[] expected1 = new int[]{0, 0, 0, 2, 3, 4};
		//assertArrayEquals(expected1, result1);
		
		// case 4
		int[] arr4 = {3, 4, 6, 7, 9};
		System.out.println("result4: "+coinChange.getCoinChange(arr4, 15));
		//int[] result1 = coinChange.getCoinChange(arr1, 4);
		//int[] expected1 = new int[]{0, 0, 0, 2, 3, 4};
		//assertArrayEquals(expected1, result1);
	
	}
}
