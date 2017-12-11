package org.sample.practice.stack;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class MaxAreaHistogramTest {

	@Test
	public void testArea(){
		
		MaxAreaHistogram maxAreaHistogram = new MaxAreaHistogram();
		
		//assertTrue(maxAreaHistogram.getMaxArea(new int[]{1, 2, 4}) == 4);
		//assertTrue(maxAreaHistogram.getMaxArea(new int[]{2, 1, 2, 3, 1}) == 5);
		assertTrue(maxAreaHistogram.getMaxArea(new int[]{3, 2, 5, 6, 1, 4, 4}) == 10);
		
	}
	
}
