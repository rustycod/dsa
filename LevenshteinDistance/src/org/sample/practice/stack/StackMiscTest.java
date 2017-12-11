package org.sample.practice.stack;

import java.util.Stack;
import org.junit.Test;
import static org.junit.Assert.*;

public class StackMiscTest {

	
	@Test
	public void testReverseStack() {
		StackMisc obj = new StackMisc();
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(1);stack.push(2);stack.push(3);stack.push(4);stack.push(5);
		obj.reverseStack(stack);		
		
		Stack<Integer> expected = new Stack<Integer>();
		expected.push(5);expected.push(4);expected.push(3);expected.push(2);expected.push(1);
		assertEquals(expected, stack);
		
	}

	@Test
	public void testInsertAtBottom() {
		
		StackMisc obj = new StackMisc();
		
		Stack<Integer> stack1 = new Stack<Integer>();
		stack1.push(1);stack1.push(2);stack1.push(3);stack1.push(4);stack1.push(5);
		//System.out.println("before: "+stack1);
		obj.insertAtBottom(stack1, 100);
		//System.out.println("after: "+stack1);
		Stack<Integer> expected1 = new Stack<Integer>();
		expected1.push(100);expected1.push(1);expected1.push(2);expected1.push(3);expected1.push(4);expected1.push(5);
		assertEquals(expected1, stack1);
		
		Stack<Integer> stack2 = new Stack<Integer>();
		obj.insertAtBottom(stack2, 1);
		Stack<Integer> expected2 = new Stack<Integer>();
		expected2.push(1);
		assertEquals(expected2, stack2);
		
		Stack<Integer> stack3 = new Stack<Integer>();
		stack3.push(1);
		obj.insertAtBottom(stack3, 2);
		Stack<Integer> expected3 = new Stack<Integer>();
		expected3.push(2);expected3.push(1);
		assertEquals(expected3, stack3);
		
		Stack<Integer> stack4 = new Stack<Integer>();
		stack4.push(2);stack4.push(1);
		obj.insertAtBottom(stack4, 3);
		Stack<Integer> expected4 = new Stack<Integer>();
		expected4.push(3);expected4.push(2);expected4.push(1);
		assertEquals(expected4, stack4);
		
		Stack<Integer> stack5 = new Stack<Integer>();
		stack5.push(3);stack5.push(2);stack5.push(1);
		obj.insertAtBottom(stack5, 4);
		Stack<Integer> expected5 = new Stack<Integer>();
		expected5.push(4);expected5.push(3);expected5.push(2);expected5.push(1);
		assertEquals(expected5, stack5);		
		
		Stack<Integer> stack6 = new Stack<Integer>();
		stack6.push(4);stack6.push(3);stack6.push(2);stack6.push(1);
		obj.insertAtBottom(stack6, 5);
		Stack<Integer> expected6 = new Stack<Integer>();
		expected6.push(5);expected6.push(4);expected6.push(3);expected6.push(2);expected6.push(1);
		assertEquals(expected6, stack6);		
	}


	@Test
	public void testFindSpan() {
		
		StackMisc obj = new StackMisc();
		
		// case 1
		int[] inArray1 = new int[]{6, 3, 4, 5, 2};
		int[] expectedSpanArray1 = new int[]{1, 1, 2, 3, 1};
		int[] spanArray1 = obj.findSpan(inArray1);
		assertArrayEquals(expectedSpanArray1, spanArray1);
		
		// case 2
		int[] inArray2 = new int[]{100, 80, 60, 70, 60, 75, 85};
		int[] expectedSpanArray2 = new int[]{1, 1, 1, 2, 1, 4, 6};
		int[] spanArray2 = obj.findSpan(inArray2);
		assertArrayEquals(expectedSpanArray2, spanArray2);
		
		// case 3
		int[] inArray3 = new int[]{100, 60, 70, 65, 110, 120};
		int[] expectedSpanArray3 = new int[]{1, 1, 2, 1, 5, 6};
		int[] spanArray3 = obj.findSpan(inArray3);
		assertArrayEquals(expectedSpanArray3, spanArray3);
	}
	
}
