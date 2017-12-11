package org.sample.search;

import static org.junit.Assert.*;

import org.junit.Test;

public class SearchMiscTest {

	@Test
	public void testFindMaxDuplicate() {
		int[] arr1 = new int[]{1,1,2,2,2,3,3,3,3,5};
		assertTrue(SearchMisc.findMaxDuplicate(arr1) == 3);
		
		int[] arr2 = new int[]{1,1,1,1,1,1,1,2,2,2,3,3,3,3,5};
		assertTrue(SearchMisc.findMaxDuplicate(arr2) == 1);
		
		int[] arr3 = new int[]{1,1,1,1,1,2,2,2,2,2};
		assertTrue(SearchMisc.findMaxDuplicate(arr3) == 2);
	}


	@Test
	public void testFindMaxDuplicate2() {
		int[] arr1 = new int[]{1,1,2,2,2,3,3,3,3,5};
		assertTrue(SearchMisc.findMaxDuplicate2(arr1) == 3);
		
		int[] arr2 = new int[]{1,1,1,1,1,1,1,2,2,2,3,3,3,3,5};
		assertTrue(SearchMisc.findMaxDuplicate2(arr2) == 1);
		
		int[] arr3 = new int[]{1,1,1,1,1,2,2,2,2,2};
		assertTrue(SearchMisc.findMaxDuplicate2(arr3) == 1);
	}
}
