package org.sample.algo.dp;

import static org.junit.Assert.*;

import org.junit.Test;

public class LongestCommonSubsequenceTest {
	
	@Test
	public void testGetMaxValue() {
		
		LongestCommonSubsequence lcs = new LongestCommonSubsequence();
		
		// case 1
		assertTrue("abcf".equals(lcs.lcs("abcdaf", "acbcf")));
		
		// case 2
		assertTrue("ADH".equals(lcs.lcs("ABCDGH", "AEDFHR")));
		
		// case 3
		assertTrue("GTAB".equals(lcs.lcs("AGGTAB", "GXTXAYB")));
		
		// case 4
		assertTrue("ADHR".equals(lcs.lcs("AEDPHR", "ABCDGHLQR")));
		
	}
}
