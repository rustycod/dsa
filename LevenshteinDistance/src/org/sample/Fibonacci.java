package org.sample;

public class Fibonacci {
	
	public static int fibonacci(int count) {
		if (count == 1) {
			return 0;
		}
		
		if (count == 2) {
			return 1;
		}
		
		return fibonacci(count - 1) + fibonacci(count - 2);
	}
	
	public static void main (String[] args) {
		
		int count = 10;
		for(int i = 1; i <= count; i++) {
			System.out.println(fibonacci(i));
		}
		
	}

}
