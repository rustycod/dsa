package org.sort;

import org.junit.Test;
import static org.junit.Assert.*;

public class QuickSortFirstAttemptTest {

	@Test
	public void testSort() {
		int[] arr = new int[] {4, 77, 5, 17, 57, 2, 74, 7, 70};
		QuickSortFirstAttempt.sort(arr, 0, arr.length - 1);
		
		for(int i = 0; i < arr.length - 1; i++) {
			assertTrue(arr[i] <= arr[i+1]);
		}

		// second array
		int[] arr2 = new int[] {21, 86, 36, 82, 6, 34, 69, 43, 75, 42};
		QuickSortFirstAttempt.sort(arr2, 0, arr2.length - 1);
		
		for(int i = 0; i < arr2.length - 1; i++) {
			assertTrue(arr2[i] <= arr2[i+1]);
		}
		
		// third array
		int[] arr3 = new int[] {56, 80, 75, 47, 72, 7, 55, 59, 64, 92, 98, 90, 52, 62};
		QuickSortFirstAttempt.sort(arr3, 0, arr3.length - 1);
		
		for(int i = 0; i < arr3.length - 1; i++) {
			assertTrue(arr3[i] <= arr3[i+1]);
		}
	}
}
