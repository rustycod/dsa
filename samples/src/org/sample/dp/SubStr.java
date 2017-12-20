package org.sample.dp;

import java.util.ArrayList;
import java.util.List;


public class SubStr {
	
	public static void main(String[] args) {
		
		String str = "aabaa";
		
		// case 
		SubStr t = new SubStr();
		System.out.println("case of 1, 1");
		t.process(str, 1, 1);
		System.out.println("case of 1, 4");
		t.process(str, 1, 4);
		System.out.println("case of 1, 1");
		t.process(str, 1, 1);
		System.out.println("case of 0, 2");
		t.process(str, 0, 2);
		
		/*List<String> expectedList = new ArrayList<String>();
		expectedList.add("a");expectedList.add("b");expectedList.add("ab");expectedList.add("ba");expectedList.add("aa");
		expectedList.add("aba");expectedList.add("baa");expectedList.add("abaa");*/
		
	}
	
	
	private List<String> process(String str, int start, int end) {
		
		// corner case
		if(start < 0) {
			throw new IllegalArgumentException("start index can't be negative");
		} else if(end < 0) {
			throw new IllegalArgumentException("end index can't be negative");
		} else if(start > end) {
			throw new IllegalArgumentException("start index must be equal or smaller than end");
		}
		
		if(str == null || str.trim().length() == 0) {
			throw new IllegalArgumentException("input string is either null or empty");
		}
		
		String subStr = str.substring(start, end + 1);
		System.out.println("subStr: "+subStr);
		
		List<String> strList = generateSubStrings(subStr);
		System.out.println("strList: "+strList);
		return strList;
	}
	
	public List<String> generateSubStrings(String str) {
		
		List<String> subStrList = new ArrayList<String>();
		
		int length = 1;
		
		while(length <= str.length()) {
			
			for(int i = 0; (i + length) <= str.length(); i++) {
				String strCurr = str.substring(i, i + length);
				if(!subStrList.contains(strCurr)) {
					subStrList.add(str.substring(i, i + length));
				}
			}
			
			length++;
		}
		
		return subStrList;
	}
	
	
	
}
