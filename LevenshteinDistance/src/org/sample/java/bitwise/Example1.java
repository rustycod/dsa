package org.sample.java.bitwise;

public class Example1 {

	public static void main(String[] args) {
		int j = 10;
		
		System.out.println(Integer.toBinaryString(j));
		
		System.out.println("39: "+Integer.toBinaryString(39));
		System.out.println("39 >>> 3: "+(39 >>> 3));
		System.out.println("39 >> 3: "+(39 >> 3));
		
		
		int k = j << 2;
		System.out.println("result 1: "+k);
		
		int l = k >>> 3;
		
		System.out.println("result 2: "+l);
		
		int m = 4;
		System.out.println("result 3: "+(4>>1));
		System.out.println("result 4: "+(4>>>1));
	}
}
