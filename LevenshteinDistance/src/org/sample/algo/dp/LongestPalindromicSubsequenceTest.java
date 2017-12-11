package org.sample.algo.dp;

import static org.junit.Assert.*;

import org.junit.Test;

public class LongestPalindromicSubsequenceTest {
	
	@Test
	public void testGetOptimalCost() {
		
		LongestPalindromicSubsequence lps = new LongestPalindromicSubsequence();
		
		// case 1
		assertTrue(5 == lps.getPalindrome("AGBDBA").length());
		assertTrue("ABDBA".equals(lps.getPalindrome("AGBDBA")));
		
		// case 2
		assertTrue(7 == lps.getPalindrome("BBABCBCAB").length());
		assertTrue("BACBCAB".equals(lps.getPalindrome("BBABCBCAB")));

		// case 3
		assertTrue(6 == lps.getPalindrome("ABCCBA").length());
		assertTrue("ABCCBA".equals(lps.getPalindrome("ABCCBA")));
		
	}
}
