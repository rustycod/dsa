package org.sample.practice.stack;

import java.util.HashMap;
import java.util.Map;

// Read only region start
class UserMainCode2
{

	public String convertBase(String input1,String input2,String input3){
		// Read only region end
		// Write code here...
		
		if(input1.length() < 2 || input1.length() > 40 || input1 == null) {
			throw new UnsupportedOperationException("Number of characters in input1 should be between 2 and 40 with both inclusive");
		}

		
		if(input2.length() < 2 || input2.length() > 40 || input2 == null) {
			throw new UnsupportedOperationException("Number of characters in input2 should be between 2 and 40 with both inclusive");
		}
		
		if(input3 == null || input3.length() == 0) {
			throw new UnsupportedOperationException("Input3 is either null or must contain at least 1 character");
		}
		
		
		int baseSystem1 = input1.length();
		char[] charArr1 = input1.toCharArray();
		
		// map1
		Map<Character, Integer> mapInput1 = new HashMap<Character, Integer>();
		int count = 0;
		for(Character c : charArr1) {
			mapInput1.put(c, count);
			count++;
		}
		
		
		// convert input3 to decimal system
		char[] charArray3 = input3.toCharArray();
		int length3 = input3.length();
		
		int count3 = length3;
		int sumDecimal = 0;
		int base = 1;
		
		
		while(count3 > 0) {
			
			int number = mapInput1.get(charArray3[count3 - 1]);
			
			if(count3 != length3) {
				base = base * baseSystem1;
			}
			
			sumDecimal = sumDecimal + base * number; 
			
			count3--;
		}
			
		System.out.println("input3 in decimal is: "+sumDecimal);
		

		// convert sumDecimal (decimal) to target library
		int baseSystem2 = input2.length();
		
		if(baseSystem2 == 10) {
			return sumDecimal + ""; // no need to convert as target system is in decimal
		}
		
		
		// if not, convert sumDecimal to as per target library
		StringBuilder sb = new StringBuilder();
		
		int result = sumDecimal;
		while(result >= baseSystem2) {
			int remainder = result % baseSystem2;
			sb.append(remainder);
			result = result / baseSystem2;
			//sumDecimal = result;
		}
		
		sb.append(result);
		sb = sb.reverse();
		//System.out.println("result: "+sb);
		
		
		// map2
		Map<Character, Integer> mapInput2 = new HashMap<Character, Integer>();
		int count2 = 0;
		char[] charArr2 = input2.toCharArray();
		for(Character c : charArr2) {
			mapInput1.put(c, count2);
			count2++;
		}
		
		String str = sb.toString();
		StringBuilder sbNew = new StringBuilder();
		for(char c : str.toCharArray()) {
			sbNew.append(str);
		}
		
		return sb.toString(); 
	}
	
	
	public static void main (String[] args) {
		
		UserMainCode2 obj = new UserMainCode2();
		
		System.out.println("result is: "+obj.convertBase("abcABCD", "0123456789", "bc"));
		
		System.out.println("result is: "+obj.convertBase("0123456789", "zYlrSPLNalephb", "334150"));
		
		//obj.convertBase("0123456789", "01", "100");
		
		
	}
}