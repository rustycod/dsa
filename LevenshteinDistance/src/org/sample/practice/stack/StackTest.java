package org.sample.practice.stack;

import org.junit.Test;
import static org.junit.Assert.*;

public class StackTest {

	@Test
	public void test() {
	
		Stack s1 = new Stack(5);
		assertTrue(s1.size() == 0);
		assertTrue(s1.push(1));
		assertTrue(s1.size() == 1);
		assertTrue(s1.pop() == 1);
		assertTrue(s1.size() == 0); 
		assertTrue(s1.push(1));
		assertTrue(s1.size() == 1);
		assertTrue(s1.push(2));
		assertTrue(s1.size() == 2);
		assertTrue(s1.push(3));
		assertTrue(s1.size() == 3);
		assertTrue(s1.push(4));
		assertTrue(s1.size() == 4);
		assertTrue(s1.push(5));
		assertTrue(s1.size() == 5);
		assertTrue(!s1.push(6));
		assertTrue(s1.size() == 5);
		assertTrue(s1.pop() == 5);
		assertTrue(s1.size() == 4);
		assertTrue(s1.pop() == 4);
		assertTrue(s1.size() == 3);
		assertTrue(s1.pop() == 3);
		assertTrue(s1.size() == 2);
		assertTrue(s1.pop() == 2);
		assertTrue(s1.size() == 1);
		assertTrue(s1.pop() == 1);
		assertTrue(s1.size() == 0);
		assertTrue(s1.pop() == -1);
		assertTrue(s1.size() == 0);
	}
	
	
}
