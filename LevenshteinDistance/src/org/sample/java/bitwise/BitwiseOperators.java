package org.sample.java.bitwise;

public class BitwiseOperators {

	public BitwiseOperators( ) {

		int a = 11; //1 0 1 1
		int b = 12; //1 1 0 0

		System.out.println("a & b : "+(a & b));

		System.out.println("a | b : "+(a | b));

		System.out.println("a ^ b : "+(a ^ b));

		System.out.println("~a : "+(~a));
		System.out.println("result 0: "+Integer.toBinaryString(~a));

		System.out.println("a << b : "+(a << b));
		System.out.println("result 1: "+Integer.toBinaryString(a << b));

		System.out.println("a >> b : "+(a >> b));
		System.out.println("result 2: "+Integer.toBinaryString(a >> b));

		System.out.println("a >>> b : "+(a >>> b));
		System.out.println("result 3: "+Integer.toBinaryString(a >>> b));

		System.out.println("~a : "+(~a));
		System.out.println("result 4: "+Integer.toBinaryString((~a) >> 2));
		
		System.out.println("~a : "+(~a));
		System.out.println("result 5: "+Integer.toBinaryString((~a) >>> 2));
	}

	public static void main(String args[]){
		new BitwiseOperators();
	}
}
