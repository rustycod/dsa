package org.sample.algo.dp;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class MinimumEditDistanceTest {
	
	@Test
	public void testGetMinimumEditDistance() {
		
		MinimumEditDistance minimumEditDistance = new MinimumEditDistance();
		
		// case 1
		String str11 = "AZCED";
		String str12 = "ABCDEF";
		assertTrue(3 == minimumEditDistance.getMinimumEditDistance(str11, str12));
		//System.out.println(minimumEditDistance.instructions);
		interpretInstructions(minimumEditDistance.instructions, str11, str12);
		
		// case 2
		String str21 = "GEEK";
		String str22 = "GESEK";
		assertTrue(1 == minimumEditDistance.getMinimumEditDistance(str21, str22));
		interpretInstructions(minimumEditDistance.instructions, str21, str22);
		
		// case 3
		String str31 = "CATF";
		String str32 = "CUT";
		assertTrue(2 == minimumEditDistance.getMinimumEditDistance(str31, str32));
		interpretInstructions(minimumEditDistance.instructions, str31, str32);
		
		// case 4
		String str41 = "SUNDAY";
		String str42 = "SATURDAY";
		assertTrue(3 == minimumEditDistance.getMinimumEditDistance(str41, str42));
		interpretInstructions(minimumEditDistance.instructions, str41, str42);
		

	}
	
	private void interpretInstructions(List<List<Integer>> instructions, String str1, String str2) {
		
		System.out.println("---------------------------------------------------");
		System.out.println("Instructions for "+str1+ " and "+str2 +":");
		
		for(List<Integer> instruction : instructions) {
			StringBuilder sb = new StringBuilder();
			
			if(instruction.get(0) == 1) {
				sb.append("Replace ");
			} else if(instruction.get(0) == 2) {
				sb.append("Remove ");
			} else {
				sb.append("Add ");
			}
			
			
			if(instruction.get(1) != -1 && instruction.get(2) != -1) {
				sb.append(str1.charAt(instruction.get(1)) + " at index "+instruction.get(1)+" in first string with "+str2.charAt(instruction.get(2))+" at index "+instruction.get(2)+" in second string");
			} else if(instruction.get(1) != -1) {
				sb.append(str1.charAt(instruction.get(1)) + " at index " +instruction.get(1)+" in first string");
			} else {
				sb.append(str2.charAt(instruction.get(2)) + " at index " +instruction.get(2)+ " in second string");
			}
			
			System.out.println(sb.toString());
			
			
		}
	}
}
