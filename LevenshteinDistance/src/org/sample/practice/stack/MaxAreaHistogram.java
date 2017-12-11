package org.sample.practice.stack;

import java.util.Stack;

public class MaxAreaHistogram {

	public int getMaxArea(int[] arr) {
		
		int index = 0;
		Stack<Integer> stack = new Stack<Integer>();
		int maxArea = -1;
		
		while (index < arr.length) {
			
			if(stack.isEmpty() || arr[stack.peek()] <= arr[index]) {
				stack.push(index);
				index++;
				continue;
			}
			
			
			while(!stack.isEmpty() && arr[stack.peek()] > arr[index]) {
				int top = stack.pop();
				
				int area = -1;
				if(stack.isEmpty()) {
					area = arr[top] * index;
				} else {
					area = arr[top] * (index - stack.peek() - 1);
				}
				
				
				if(area > maxArea) {
					maxArea = area;
				}
			}
			
			stack.push(index);
			index++;
		}
		

		
		while(!stack.isEmpty()) {

			int top = stack.pop();
			
			int area = -1;
			if(stack.isEmpty()) {
				area = arr[top] * index;
			} else {
				area = arr[top] * (index - stack.peek() - 1);
			}
			
			
			if(area > maxArea) {
				maxArea = area;
			}			
			
		}
		
		return maxArea; // for time being
	}
	
}
