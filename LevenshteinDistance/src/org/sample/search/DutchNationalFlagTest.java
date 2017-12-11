package org.sample.search;

import static org.junit.Assert.*;

import org.junit.Test;

public class DutchNationalFlagTest {

	@Test
	public void testThreeWayDNF() {
		DutchNationalFlag obj = new DutchNationalFlag();

		// case 1
		int[] array1 = new int[]{2, 1, 0, 0, 2, 0, 1, 1, 2, 0};
		obj.threeWayDNF(array1);
		int[] expected1 = new int[]{0, 0, 0, 0, 1, 1, 1, 2, 2, 2};
		assertArrayEquals(expected1, array1);
		
		// case 2
		int[] array2 = new int[]{1, 0, 0, 0, 1, 1, 0};
		obj.threeWayDNF(array2);
		int[] expected2 = new int[]{0, 0, 0, 0, 1, 1, 1};
		assertArrayEquals(expected2, array2);
		
		// case 3
		int[] array3 = new int[]{0, 0, 0, 1, 1, 1};
		obj.threeWayDNF(array3);
		int[] expected3 = new int[]{0, 0, 0, 1, 1, 1};
		assertArrayEquals(expected3, array3);
		
		// case 4
		int[] array4 = new int[]{1, 1, 1, 2, 2, 2};
		obj.threeWayDNF(array4);
		int[] expected4 = new int[]{1, 1, 1, 2, 2, 2};
		assertArrayEquals(expected4, array4);
		
		// case 5
		int[] array5 = new int[]{2, 2, 2, 1, 1, 1, 0, 0, 0};
		obj.threeWayDNF(array5);
		int[] expected5 = new int[]{0, 0, 0, 1, 1, 1, 2, 2, 2};
		assertArrayEquals(expected5, array5);
	}

	
	@Test
	public void testFourWayDNF() {
		DutchNationalFlag obj = new DutchNationalFlag();

		// case 1
		int[] array1 = new int[]{2, 1, 3, 0, 2, 0, 3, 1, 2, 0};
		obj.fourWayDNF(array1);
		int[] expected1 = new int[]{0, 0, 0, 1, 1, 2, 2, 2, 3, 3};
		assertArrayEquals(expected1, array1);
		
		// case 2
		int[] array2 = new int[]{1, 0, 0, 0, 1, 1, 0, 2, 2};
		obj.fourWayDNF(array2);
		int[] expected2 = new int[]{0, 0, 0, 0, 1, 1, 1, 2, 2};
		assertArrayEquals(expected2, array2);
		
		// case 3
		int[] array3 = new int[]{1, 1, 0, 0, 2, 1, 2, 0, 1 ,0, 0, 0, 0, 0, 0, 3, 3};
		obj.fourWayDNF(array3);
		int[] expected3 = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 3, 3};
		assertArrayEquals(expected3, array3);
		
	}
	
	
	@Test
	public void testFiveWayDNF() {
		DutchNationalFlag obj = new DutchNationalFlag();

		// case 1
		int[] array1 = new int[]{2, 1, 3, 0, 2, 4, 0, 3, 1, 2, 4, 0};
		obj.fiveWayDNF(array1);
		int[] expected1 = new int[]{0, 0, 0, 1, 1, 2, 2, 2, 3, 3, 4, 4};
		assertArrayEquals(expected1, array1);
		
	}
	
	
	@Test
	public void testSegregateOddEvenNumbers() {
		DutchNationalFlag obj = new DutchNationalFlag();
		
		// case 1
		int[] array1 = new int[]{6, 82, 65, 50, 42, 46, 58, 22, 4, 37, 3, 40, 35};
		obj.segregateOddEvenNumbers(array1);
		int[] expected1 = new int[]{6, 82, 40, 50, 42, 46, 58, 22, 4, 37, 3, 65, 35};
		assertArrayEquals(expected1, array1);
		
	}
}
