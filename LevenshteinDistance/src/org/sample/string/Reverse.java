package org.sample.string;

public class Reverse {

	public String reverse(char[] charArray) {
		int length = charArray.length;
		
		int start = 0;
		int end = length - 1;
		
		while(start < end) {
			char temp = charArray[start];
			charArray[start] = charArray[end];
			charArray[end] = temp;
			
			start++;
			end--;
		}
		
		return new String(charArray);
	}
	
	public static void main (String[] args) {
		// case 1: abcde
		String str1 = "abcde";
		
		Reverse obj = new Reverse();
		System.out.println("Result1: "+obj.reverse(str1.toCharArray()));
		
		// case 2: abcdef
		String str2 = "abcdef";
		System.out.println("Result2: "+obj.reverse(str2.toCharArray()));
		
	}
}
