package org.sample.practice.stack;

import java.util.Stack;

public class StackMisc {

	
	public void reverseStack(Stack<Integer> stack) {
		
		if(stack.size() == 0) return;
		
		int currVal = stack.pop();
		
		reverseStack(stack);
		insertAtBottom(stack, currVal);
		
	}

	
	public void insertAtBottom(Stack<Integer> stack, int data) {
		
		if(stack.size() == 0) {
			stack.push(data);
			return;
		}
		
		int currValue = stack.pop();
		insertAtBottom(stack, data);
		stack.push(currValue);
	}
	
	
	public int[] findSpan(int[] inArray) {
		int[] spanArray = new int[inArray.length];
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i = 0; i < inArray.length; i++) {
			
			if(stack.isEmpty()) {
				stack.push(inArray[i]);
			} else {
				while(!stack.isEmpty() && inArray[i] >= stack.peek()) {
					stack.pop();
				}
				stack.push(inArray[i]);
			}
			
			spanArray[i] = i - stack.size() + 2;
			
		}
		
		return spanArray;
	}

}
