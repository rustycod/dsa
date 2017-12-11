package org.sample;

public class Factorial {

	public static int factorial(int n) {
		
		// base condition
		if (n == 0) {
			return 1;
		}
		
		// error condition
		if (n < 1) {
			return -1; // factorial not possible for negative numbers
		}
		
		return n * factorial(n -1);
	}
	
	public static void main (String[] args) {
		System.out.println(factorial(4));
	}
}
