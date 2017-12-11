package org.sample.stack;

import java.util.Stack;

public class Reverse {
	
	public void traverse(Stack<Integer> stack) {
		
		if(stack.isEmpty()) {
			return;
		}
		int currentItem = stack.pop();
		traverse(stack);
		insertAtBottom(stack, currentItem);

	}

	public void insertAtBottom(Stack<Integer> stack, int data) {
	
		if(stack.isEmpty()) {
			stack.push(data);
			return;
		}
		
		int currentData = stack.pop();
		insertAtBottom(stack, data);
		stack.push(currentData);
	}
	
	public static void main (String[] args) {
		Reverse obj = new Reverse();
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		
		System.out.println(stack.toString());
		obj.traverse(stack);
		System.out.println("output: "+stack.toString());
		
		
	}
}
