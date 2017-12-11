package org.sample.java;

public class FinallyExample {

	public static int test(Object obj) {
		try {
			return obj.toString().length();
		} catch (Exception ex) {
			return -1;
		} finally {
			return 0;
		}
	}
	
	
	public static void main(String[] args) {
		System.out.println("result is: "+test(null));
	}
 }
