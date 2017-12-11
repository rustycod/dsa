package org.sort;

import org.junit.Test;
import static org.junit.Assert.*;

public class MergeSortTest {

	@Test
	public void testMerge() {
		// test 1
		int[] arr1 = new int[] {4, 5, 17, 77};
		int[] arr2 = new int[] {2, 7, 57, 70, 74};
		
		int[] arrMerged = MergeSort.merge(arr1, arr2);
		
		for(int i = 0; i < arrMerged.length - 1; i++) {
			assertTrue(arrMerged[i] <= arrMerged[i+1]);
		}

		// test 2
		int[] arr3 = new int[] {6, 21, 34, 36, 42, 43, 69, 75, 82, 86};
		int[] arr4 = new int[] {7, 43, 47, 52, 55, 56, 59, 62, 64, 72, 75, 80, 90, 92, 98};
		
		int[] arrMerged2 = MergeSort.merge(arr3, arr4);
		
		for(int i = 0; i < arrMerged2.length - 1; i++) {
			assertTrue(arrMerged2[i] <= arrMerged2[i+1]);
		}
		
		// test 3
		int[] arr5 = new int[] {7, 43, 47, 52, 55, 56, 59, 62, 64, 72, 75, 80, 90, 92, 98};
		int[] arr6 = new int[] {6, 21, 34, 36, 42, 43, 69, 75, 82, 86};
		
		int[] arrMerged3 = MergeSort.merge(arr5, arr6);
		
		for(int i = 0; i < arrMerged3.length - 1; i++) {
			assertTrue(arrMerged3[i] <= arrMerged3[i+1]);
		}
	}
	
	
	@Test
	public void testSort() {
		int[] arr = new int[] {4, 77, 5, 17, 57, 2, 74, 7, 70};
		int[] arrMerged1 = MergeSort.sort(arr, 0, arr.length - 1);
		
		for(int i = 0; i < arrMerged1.length - 1; i++) {
			assertTrue(arrMerged1[i] <= arrMerged1[i+1]);
		}

		// second array
		int[] arr2 = new int[] {21, 86, 36, 82, 6, 34, 69, 43, 75, 42};
		int[] arrMerged2 = MergeSort.sort(arr2, 0, arr2.length - 1);
		
		for(int i = 0; i < arrMerged2.length - 1; i++) {
			assertTrue(arrMerged2[i] <= arrMerged2[i+1]);
		}
		
		// third array
		int[] arr3 = new int[] {56, 80, 75, 47, 72, 7, 55, 59, 64, 92, 98, 90, 52, 62};
		int[] arrMerged3 = MergeSort.sort(arr3, 0, arr3.length - 1);
		
		for(int i = 0; i < arr3.length - 1; i++) {
			assertTrue(arrMerged3[i] <= arrMerged3[i+1]);
		}
	}
}
