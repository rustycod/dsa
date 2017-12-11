package org.sample.stack;

import java.util.Stack;

public class ReversePractice {

	public static void reverseStack(Stack<Integer> stack) {
	
		int val = stack.pop();
		reverseStack(stack);
	}
	
	public static void reverse(Stack<Integer> stack, int val) {
		
		int currValue = stack.pop();
		
		if(stack.isEmpty()) {
			stack.push(val);
			
		} else {
			reverse(stack, currValue);
		}
		
		System.out.println(currValue);
		stack.push(val);
		
	}
	
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(1);stack.push(2);stack.push(3);
		reverse(stack, 4);
		
		System.out.println("stack: "+stack);
		
	}
}
