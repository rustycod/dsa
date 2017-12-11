package org.sample.search;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TrappingRainWaterTest {

	@Test
	public void testGetRainWater() {
		
		TrappingRainWater obj = new TrappingRainWater();
		
		// case 1
		int[] arr1 = {2, 0, 2};
		assertTrue(obj.getRainWater(arr1) == 2);
		
		// case 2
		int[] arr2 = {3, 0, 0, 2, 0, 4};
		assertTrue(obj.getRainWater(arr2) == 10);

		// case 3
		int[] arr3 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
		assertTrue(obj.getRainWater(arr3) == 6);
	}
}
