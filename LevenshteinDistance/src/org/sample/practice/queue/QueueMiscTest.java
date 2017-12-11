package org.sample.practice.queue;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

public class QueueMiscTest {

	@Test
	public void testReverse() {
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(1);queue.add(2);queue.add(3);queue.add(4);queue.add(5);
		QueueMisc.reverse(queue);
		
		Queue<Integer> expected = new LinkedList<Integer>();
		expected.add(5);expected.add(4);expected.add(3);expected.add(2);expected.add(1);
		
		assertEquals(expected, queue);
		
	}
}
