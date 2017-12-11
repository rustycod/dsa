package org.sample.linkedlist;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.Test;



public class LinkedListTest {


	@Test
	public void testRemove() {
		
		// case 1: linkedList is empty
		LinkedList ll1 = new LinkedList();
		Set<Integer> expected1Before = new LinkedHashSet<Integer>();
		assertEquals(expected1Before, ll1.traverse());
		assertNull(ll1.remove(1));
		Set<Integer> expected1 = new LinkedHashSet<Integer>();
		assertEquals(expected1, ll1.traverse());
		
		// case 2: only one node exists and value doesn't match
		LinkedList ll2 = new LinkedList();
		ll2.add(1);
		Set<Integer> expected2Before = new LinkedHashSet<Integer>();
		expected2Before.add(1);
		assertEquals(expected2Before, ll2.traverse());
		assertNull(ll2.remove(2));
		Set<Integer> expected2 = new LinkedHashSet<Integer>();
		expected2.add(1);
		assertEquals(expected2, ll2.traverse());

		// case 3: only one node exists and value does match
		LinkedList ll3 = new LinkedList();
		ll3.add(2);
		Set<Integer> expected3Before = new LinkedHashSet<Integer>();
		expected3Before.add(2);
		assertEquals(expected3Before, ll3.traverse());
		Node removedNode = ll3.remove(2); 
		assertNotNull(removedNode);
		assertEquals(2, removedNode.getData());
		assertNull(removedNode.getNext());
		Set<Integer> expected3 = new LinkedHashSet<Integer>();
		assertEquals(expected3, ll3.traverse());
		
		// case 4: remove tail
		
		// case 5: remove second node
		
		// case 6: remove last but one node
		
		// case 7: remove any node from center
		
	}
	
	@Test
	public void printReverse() {
		
		LinkedList ll1 = new LinkedList();
		ll1.add(1);ll1.add(2);ll1.add(3);ll1.add(4);ll1.add(5);
		
		ll1.reverse();
		
		Set<Integer> ll1output = ll1.traverse();
		Set<Integer> expectedOutput = new LinkedHashSet<Integer>();
		expectedOutput.add(1);expectedOutput.add(2);expectedOutput.add(3);expectedOutput.add(4);expectedOutput.add(5);
		assertEquals(5, ll1output.size());
		assertEquals(expectedOutput, ll1output);
		
		ll1.printReverse();
	}
	
	@Test
	public void testReverse() {
		// case 1: linkedList with 5 nodes
		LinkedList ll1 = new LinkedList();
		ll1.add(1);ll1.add(2);ll1.add(3);ll1.add(4);ll1.add(5);
		
		Set<Integer> expectedOutput = new LinkedHashSet<Integer>();
		expectedOutput.add(1);expectedOutput.add(2);expectedOutput.add(3);expectedOutput.add(4);expectedOutput.add(5);
		assertEquals(expectedOutput, ll1.traverse());
		
		ll1.reverse();
		System.out.println(ll1);
		
		
		// case 2: linkedList with no node
		LinkedList ll2 = new LinkedList();
		Set<Integer> expectedOutput2 = new LinkedHashSet<Integer>();
		assertEquals(expectedOutput2, ll2.traverse());
		
		ll2.reverse();
		assertEquals(expectedOutput2, ll2.traverse());
		
		// case 3: linkedList with one node
		LinkedList ll3 = new LinkedList();
		ll3.add(1);
		Set<Integer> expectedOutput3 = new LinkedHashSet<Integer>();
		expectedOutput3.add(1);
		assertEquals(expectedOutput3, ll3.traverse());
		
		ll3.reverse();
		assertEquals(expectedOutput3, ll3.traverse());
		
		
		// case 4: linkedList with two nodes
		LinkedList ll4 = new LinkedList();
		ll4.add(1);ll4.add(2);
		Set<Integer> expectedOutput4 = new LinkedHashSet<Integer>();
		expectedOutput4.add(1);expectedOutput4.add(2);
		assertEquals(expectedOutput4, ll4.traverse());
		
		ll4.reverse();
		expectedOutput4 = new LinkedHashSet<Integer>();
		expectedOutput4.add(2);expectedOutput4.add(1);
		assertEquals(expectedOutput4, ll4.traverse());
		
		

		
		
		
	}
}
