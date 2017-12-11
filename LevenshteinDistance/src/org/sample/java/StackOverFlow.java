package org.sample.java;

import java.util.Stack;

public class StackOverFlow {

	private static Stack<Integer> stack = new Stack<Integer>();
	
	public static void process() {
		
		int i = 0;
		
		while(true) {
			stack.push(i++);
		}		
	}
	
	
	public static void throwErrorMethod() {
		process();		
	}
	
	
	public static void exampleStackOverFlowError() {
		exampleStackOverFlowError();
	}
	
	
	public static void main(String[] args) {
		process();
		//exampleStackOverFlowError();
		/*try {
			//throwErrorMethod();
			exampleStackOverFlowError();
		} catch (Error error) {
			System.out.println("error caught! ");
		}*/
	}
	
	
	
}
