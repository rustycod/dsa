package org.sample.practice.linkedlist;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class LinkedListTest {

	@Test // test with empty linked list
	public void testEmptyLinkedList() {
		LinkedList ll1 = new LinkedList();
		assertTrue(ll1.isEmpty());
		assertTrue(ll1.traverse().isEmpty());
		ll1.delete(1); // node with data 1 doesn't exist as linedlist is empty
	}
	
	@Test // test with one node in linkedlist
	public void testLinkedListOneNode() {
		LinkedList ll2 = new LinkedList();
		assertTrue(ll2.isEmpty());
		assertTrue(ll2.traverse().isEmpty());
		
		ll2.add(10);
		assertTrue(!ll2.isEmpty());
		assertTrue(!ll2.traverse().isEmpty());
		
		List<Integer> expected = new ArrayList<Integer>();
		expected.add(10);
		assertEquals(expected, ll2.traverse());
		
		ll2.add(20);
		List<Integer> expected2 = new ArrayList<Integer>();
		expected2.add(20);expected2.add(10);
		assertEquals(expected2, ll2.traverse());
		
		ll2.add(30);
		List<Integer> expected3 = new ArrayList<Integer>();
		expected3.add(30);expected3.add(20);expected3.add(10);
		assertEquals(expected3, ll2.traverse());
		
		ll2.insertAfter(40, 50);
		
		ll2.insertAfter(20, 25);
		List<Integer> expected4 = new ArrayList<Integer>();
		expected4.add(30);expected4.add(20);expected4.add(25);expected4.add(10);
		assertEquals(expected4, ll2.traverse());
		
		ll2.delete(60);
		ll2.delete(25);
		List<Integer> expected5 = new ArrayList<Integer>();
		expected5.add(30);expected5.add(20);expected5.add(10);
		assertEquals(expected5, ll2.traverse());
	}
	
	@Test
	public void testNthNodeFromEnd() {
		
		LinkedList ll3 = new LinkedList();

		for(int i = 1; i <= 20; i++) {
			ll3.add(i);
		}
		
		assertTrue(ll3.nthNodeFromEnd(30) == null);
		assertTrue(ll3.nthNodeFromEnd(5).data == 5);
		assertTrue(ll3.nthNodeFromEnd(10).data == 10);
		
	}
	
	
	@Test
	public void testNthNodeFromEndRecursive() {
	
		LinkedList ll3 = new LinkedList();

		for(int i = 1; i <= 10; i++) {
			ll3.add(i*10);
		}
		
		ll3.i = 0;
		assertTrue(ll3.findnthToLastRecursion(ll3.getHead(), 3).data == 30);
		ll3.i = 0;
		assertTrue(ll3.findnthToLastRecursion(ll3.getHead(), 5).data == 50);
		ll3.i = 0;
		assertTrue(ll3.findnthToLastRecursion(ll3.getHead(), 15) == null);
		
		ll3.counter = 0;
		System.out.println("Line 1: "+ll3.nthNodeFromEndBookAnswer(ll3.getHead(), 3));
		
		
		ll3.nthNodeFromEnd(ll3.getHead(), 3);
		assertTrue(ll3.nodeValue == 30);
		ll3.nthNodeFromEnd(ll3.getHead(), 5);
		assertTrue(ll3.nodeValue == 50);
		ll3.nodeValue = -100;
		ll3.nthNodeFromEnd(ll3.getHead(), 15);
		assertTrue(ll3.nodeValue == -100);
		
	}

	@Test
	public void testWhetherCycleExists() {

		// loop case
		LinkedList ll1 = new LinkedList();
		Node firstNode = null;
		Node fifthNode = null;
		
		for(int i = 1; i <= 10; i++) {
			if(i == 1) {
				firstNode = ll1.addNode(i);
			} else if(i == 5) {
				fifthNode = ll1.addNode(i);
			} else {
				ll1.addNode(i);
			}
		}
		
		// nodes were added to head of linkedlist 
		firstNode.next = fifthNode;

		assertTrue(ll1.whetherCycleExists());
		
		
		// linkedlist ending with null
		LinkedList ll2 = new LinkedList();
		
		for(int i = 1; i <= 10; i++) {
				ll2.addNode(i);
		}

		assertTrue(!ll2.whetherCycleExists());
	}
	
	
	@Test
	public void testBreakCycle() {

		// loop case
		LinkedList ll1 = new LinkedList();
		Node firstNode = null;
		Node fifthNode = null;
		
		for(int i = 1; i <= 10; i++) {
			if(i == 1) {
				firstNode = ll1.addNode(i);
			} else if(i == 5) {
				fifthNode = ll1.addNode(i);
			} else {
				ll1.addNode(i);
			}
		}
		
		// nodes were added to head of linkedlist
		firstNode.next = fifthNode;

		assertTrue(ll1.whetherCycleExists());
		assertTrue(ll1.breakCycle().data == 5);
		
	}
	
	@Test
	public void testGetLoopLength() {

		// loop case
		LinkedList ll1 = new LinkedList();
		Node firstNode = null;
		Node fifthNode = null;
		
		for(int i = 1; i <= 10; i++) {
			if(i == 1) {
				firstNode = ll1.addNode(i);
			} else if(i == 5) {
				fifthNode = ll1.addNode(i);
			} else {
				ll1.addNode(i);
			}
		}
		
		firstNode.next = fifthNode;

		assertTrue(ll1.whetherCycleExists());
		assertTrue(ll1.breakCycle().data == 5);
		assertTrue(ll1.getLoopLength() == 5);
		
	}
	
	
	@Test
	public void testFindMergingPoint() {

		// first linkedlist
		LinkedList ll1 = new LinkedList();
		Node thirdNodell1 = null;
		
		for(int i = 1; i <= 10; i++) {
			if(i == 3) {
				thirdNodell1 = ll1.addNode(i);
			} else {
				ll1.addNode(i);
			}
		}

		// second linkedlist
		LinkedList ll2 = new LinkedList();
		Node firstNodell2 = null;
		for(int i = 1; i <= 3; i++) {
			if(i == 1) {
				firstNodell2 = ll2.addNode(i*10);
			} else {
				ll2.addNode(i*10);
			}
		}

		firstNodell2.next =  thirdNodell1;

		assertTrue(ll1.findMergingPoint(ll1, ll2).data == 3);

	}
	
	@Test
	public void testFindMiddle() {

		// case 1
		LinkedList ll1 = new LinkedList();
		assertTrue(ll1.findMiddle() == null);
		
		// case 2
		LinkedList ll2 = new LinkedList();
		ll2.add(1);
		assertTrue(ll2.findMiddle().data == 1);
		
		// case 3
		LinkedList ll3 = new LinkedList();
		ll3.add(1);ll3.add(2);
		assertTrue(ll3.findMiddle().data == 1);
		
		// case 4
		LinkedList ll4 = new LinkedList();
		ll4.add(1);ll4.add(2);ll4.add(3);
		assertTrue(ll4.findMiddle().data == 2);
		
		// case 5
		LinkedList ll5 = new LinkedList();
		ll5.add(1);ll5.add(2);ll5.add(3);ll5.add(4);
		assertTrue(ll5.findMiddle().data == 2);
		
		// case 6
		LinkedList ll6 = new LinkedList();
		ll6.add(1);ll6.add(2);ll6.add(3);ll6.add(4);ll6.add(5);
		assertTrue(ll6.findMiddle().data == 3);
	}
	
	@Test
	public void testPrintReverse(){
		LinkedList ll1 = new LinkedList();
		for(int i = 1; i <= 10; i++) {
			ll1.add(i);
		}
		
		List<Integer> expected1 = new ArrayList<Integer>();
		for(int i = 1; i <= 10; i++) {
			expected1.add(i);
		}
		
		ll1.nodesReverse = new ArrayList<Integer>();
		ll1.printReverse(ll1.getHead());
		assertEquals(expected1, ll1.nodesReverse);
		
		List<Integer> expected2 = new ArrayList<Integer>();
		for(int i = 10; i >= 1; i--) {
			expected2.add(i);
		}
		assertEquals(expected2, ll1.traverse());
		
	}
	
	@Test
	public void testWhetherLengthIsEven() {
		// case 1
		LinkedList ll1 = new LinkedList();
		assertTrue(ll1.whetherLengthIsEven() == true);
		
		// case 2
		LinkedList ll2 = new LinkedList();
		ll2.add(1);
		assertTrue(ll2.whetherLengthIsEven() == false);
		
		// case 3
		LinkedList ll3 = new LinkedList();
		ll3.add(1);ll3.add(2);
		assertTrue(ll3.whetherLengthIsEven() == true);
		
		// case 4
		LinkedList ll4 = new LinkedList();
		ll4.add(1);ll4.add(2);ll4.add(3);
		assertTrue(ll4.whetherLengthIsEven() == false);
		
		// case 5
		LinkedList ll5 = new LinkedList();
		ll5.add(1);ll5.add(2);ll5.add(3);ll5.add(4);
		assertTrue(ll5.whetherLengthIsEven() == true);
		
		// case 6
		LinkedList ll6 = new LinkedList();
		ll6.add(1);ll6.add(2);ll6.add(3);ll6.add(4);ll6.add(5);
		assertTrue(ll6.whetherLengthIsEven() == false);
	}
	
	
	@Test
	public void testMergeTwoSortedLinkedLists() {
		
		LinkedList ll1 = new LinkedList();
		ll1.addToTail(2);ll1.addToTail(4);ll1.addToTail(6);ll1.addToTail(8);ll1.addToTail(10);
		
		LinkedList ll2 = new LinkedList();
		ll2.addToTail(1);ll2.addToTail(3);ll2.addToTail(5);ll2.addToTail(7);ll2.addToTail(9);
		
		Node head = ll1.mergeTwoSortedLinkedLists(ll1.getHead(), ll2.getHead());
		assertTrue(ll1.isInOrder(head));
		
	}
	
	@Test
	public void testMergeTwoSortedLinkedListsRecuesively() {
		
		LinkedList ll1 = new LinkedList();
		ll1.addToTail(2);ll1.addToTail(4);ll1.addToTail(6);ll1.addToTail(8);ll1.addToTail(10);
		
		LinkedList ll2 = new LinkedList();
		ll2.addToTail(1);ll2.addToTail(3);ll2.addToTail(5);ll2.addToTail(7);ll2.addToTail(9);
		
		Node head = ll1.mergeTwoSortedLinkedListsRecuesively(ll1.getHead(), ll2.getHead());
		assertTrue(ll1.isInOrder(head));
		
	}
	
	@Test
	public void testIsInOrder() {
		// case 1
		LinkedList ll1 = new LinkedList();
		assertTrue(ll1.isInOrder(ll1.getHead()) == true);
		
		// case 2
		LinkedList ll2 = new LinkedList();
		ll2.add(1);
		assertTrue(ll2.isInOrder(ll2.getHead()) == true);
		
		// case 3
		LinkedList ll3 = new LinkedList();
		ll3.add(1);ll3.add(2);
		assertTrue(ll3.isInOrder(ll3.getHead()) == false);
		
		// case 4
		LinkedList ll4 = new LinkedList();
		ll4.addToTail(1);ll4.addToTail(2);
		assertTrue(ll4.isInOrder(ll4.getHead()) == true);
		
		// case 5
		LinkedList ll5 = new LinkedList();
		ll5.addToTail(1);ll5.addToTail(2);ll5.addToTail(3);
		assertTrue(ll5.isInOrder(ll5.getHead()) == true);

		// case 6
		LinkedList ll6 = new LinkedList();
		ll6.addToTail(1);ll6.addToTail(3);ll6.addToTail(2);
		assertTrue(ll6.isInOrder(ll6.getHead()) == false);
	}
	
	@Test
	public void testReverseLinkedListInPairs() {
		
		// case 1
		LinkedList ll1 = new LinkedList();
		assertTrue(ll1.reverseLinkedListInPairs(ll1.getHead()) == null);
		
		// case 2
		LinkedList ll2 = new LinkedList();
		ll2.addToTail(1);
		List<Integer> expected2 = new ArrayList<Integer>(); expected2.add(1);
		ll2.reverseLinkedListInPairs(ll2.getHead());
		assertEquals(expected2, ll2.traverse());
		
		// case 3
		LinkedList ll3 = new LinkedList();
		ll3.addToTail(1);ll3.addToTail(2);
		List<Integer> expected3 = new ArrayList<Integer>(); expected3.add(2); expected3.add(1);
		LinkedList ll3New = new LinkedList();
		ll3New.addToTail(ll3.reverseLinkedListInPairs(ll3.getHead()));
		assertEquals(expected3, ll3New.traverse());
		
		// case 4
		LinkedList ll4 = new LinkedList();
		ll4.addToTail(1);ll4.addToTail(2);ll4.addToTail(3);
		List<Integer> expected4 = new ArrayList<Integer>(); expected4.add(2); expected4.add(1); expected4.add(3);
		LinkedList ll4New = new LinkedList();
		ll4New.addToTail(ll4.reverseLinkedListInPairs(ll4.getHead()));
		assertEquals(expected4, ll4New.traverse());

		// case 5
		LinkedList ll5 = new LinkedList();
		ll5.addToTail(1);ll5.addToTail(3);ll5.addToTail(2);ll5.addToTail(4);
		List<Integer> expected5 = new ArrayList<Integer>(); expected5.add(3); expected5.add(1); expected5.add(4); expected5.add(2);
		LinkedList ll5New = new LinkedList();
		ll5New.addToTail(ll5.reverseLinkedListInPairs(ll5.getHead()));
		assertEquals(expected5, ll5New.traverse());
		
	}

	@Test
	public void testReverseLinkedListInPairsIteratively() {
		
		// case 1
		LinkedList ll1 = new LinkedList();
		assertTrue(ll1.reverseLinkedListInPairsIteratively(ll1.getHead()) == null);
		
		// case 2
		LinkedList ll2 = new LinkedList();
		ll2.addToTail(1);
		List<Integer> expected2 = new ArrayList<Integer>(); expected2.add(1);
		ll2.reverseLinkedListInPairsIteratively(ll2.getHead());
		assertEquals(expected2, ll2.traverse());
		
		// case 3
		LinkedList ll3 = new LinkedList();
		ll3.addToTail(1);ll3.addToTail(2);
		List<Integer> expected3 = new ArrayList<Integer>(); expected3.add(2); expected3.add(1);
		LinkedList ll3New = new LinkedList();
		ll3New.addToTail(ll3.reverseLinkedListInPairsIteratively(ll3.getHead()));
		assertEquals(expected3, ll3New.traverse());
		
		// case 4
		LinkedList ll4 = new LinkedList();
		ll4.addToTail(1);ll4.addToTail(2);ll4.addToTail(3);
		List<Integer> expected4 = new ArrayList<Integer>(); expected4.add(2); expected4.add(1); expected4.add(3);
		LinkedList ll4New = new LinkedList();
		ll4New.addToTail(ll4.reverseLinkedListInPairsIteratively(ll4.getHead()));
		assertEquals(expected4, ll4New.traverse());

		// case 5
		LinkedList ll5 = new LinkedList();
		ll5.addToTail(1);ll5.addToTail(3);ll5.addToTail(2);ll5.addToTail(4);
		List<Integer> expected5 = new ArrayList<Integer>(); expected5.add(3); expected5.add(1); expected5.add(4); expected5.add(2);
		LinkedList ll5New = new LinkedList();
		ll5New.addToTail(ll5.reverseLinkedListInPairsIteratively(ll5.getHead()));
		assertEquals(expected5, ll5New.traverse());
		
		// case 6
		LinkedList ll6 = new LinkedList();
		ll6.addToTail(1);ll6.addToTail(2);ll6.addToTail(3);ll6.addToTail(4);ll6.addToTail(5);
		List<Integer> expected6 = new ArrayList<Integer>(); expected6.add(2); expected6.add(1); expected6.add(4); expected6.add(3); expected6.add(5);
		LinkedList ll6New = new LinkedList();
		ll6New.addToTail(ll6.reverseLinkedListInPairsIteratively(ll6.getHead()));
		assertEquals(expected6, ll6New.traverse());
		
		// case 7
		LinkedList ll7 = new LinkedList();
		ll7.addToTail(1);ll7.addToTail(2);ll7.addToTail(3);ll7.addToTail(4);ll7.addToTail(5);ll7.addToTail(6);
		List<Integer> expected7 = new ArrayList<Integer>(); expected7.add(2); expected7.add(1); expected7.add(4); expected7.add(3); expected7.add(6); expected7.add(5);
		LinkedList ll7New = new LinkedList();
		ll7New.addToTail(ll7.reverseLinkedListInPairsIteratively(ll7.getHead()));
		assertEquals(expected7, ll7New.traverse());
	}
	
	// Circular LinkedList
	
	@Test
	public void testSizeofCLL() {
	
		// case 1
		LinkedList ll1 = new LinkedList();
		assertTrue(ll1.sizeofCLL(ll1.getHead()) == 0);
		
		// case 2
		LinkedList ll2 = new LinkedList();
		ll2.addNode(1).next = ll2.getHead();
		assertTrue(ll2.sizeofCLL(ll2.getHead()) == 1);
		
		// case 3
		LinkedList ll3 = new LinkedList();
		ll3.addNodeToTail(1);ll3.addNodeToTail(2).next = ll3.getHead();
		assertTrue(ll3.sizeofCLL(ll3.getHead()) == 2);
		
		// case 4
		LinkedList ll4 = new LinkedList();
		ll4.addNodeToTail(1);ll4.addNodeToTail(2);ll4.addNodeToTail(3).next = ll4.getHead();
		assertTrue(ll4.sizeofCLL(ll4.getHead()) == 3);

		// case 5
		LinkedList ll5 = new LinkedList();
		ll5.addNodeToTail(1);ll5.addNodeToTail(2);ll5.addNodeToTail(3);ll5.addNodeToTail(4).next = ll5.getHead();
		assertTrue(ll5.sizeofCLL(ll5.getHead()) == 4);
	}


	@Test
	public void testSplitCircularLinkedList() {
	
		// case 1
		LinkedList ll1 = new LinkedList();
		Node secondCLL1 = ll1.splitCircularLinkedList(ll1.getHead());
		assertTrue(ll1.sizeofCLL(ll1.getHead()) == 0);
		assertTrue(ll1.sizeofCLL(secondCLL1) == 0);
		
		// case 2
		LinkedList ll2 = new LinkedList();
		ll2.addNode(1).next = ll2.getHead();
		Node secondCLL2 = ll2.splitCircularLinkedList(ll2.getHead());
		assertTrue(ll2.sizeofCLL(ll2.getHead()) == 1);
		List<Integer> expected2 = new ArrayList<Integer>(); expected2.add(1);
		assertEquals(expected2, ll2.traverseCircularLinkedList(ll2.getHead()));
		assertTrue(ll2.sizeofCLL(secondCLL2) == 0);
		
		// case 3
		LinkedList ll3 = new LinkedList();
		ll3.addNodeToTail(1);ll3.addNodeToTail(2).next = ll3.getHead();
		Node secondCLL3 = ll3.splitCircularLinkedList(ll3.getHead());
		assertTrue(ll3.sizeofCLL(ll3.getHead()) == 1);
		List<Integer> expected3First = new ArrayList<Integer>(); expected3First.add(1);
		assertEquals(expected3First, ll3.traverseCircularLinkedList(ll3.getHead()));
		List<Integer> expected3Second = new ArrayList<Integer>(); expected3Second.add(2);
		assertEquals(expected3Second, ll3.traverseCircularLinkedList(secondCLL3));
		
		// case 4
		LinkedList ll4 = new LinkedList();
		ll4.addNodeToTail(1);ll4.addNodeToTail(2);ll4.addNodeToTail(3).next = ll4.getHead();
		Node secondCLL4 = ll4.splitCircularLinkedList(ll4.getHead());
		List<Integer> expected4First = new ArrayList<Integer>(); expected4First.add(1);expected4First.add(2);
		assertEquals(expected4First, ll4.traverseCircularLinkedList(ll4.getHead()));
		List<Integer> expected4Second = new ArrayList<Integer>(); expected4Second.add(3);
		assertEquals(expected4Second, ll4.traverseCircularLinkedList(secondCLL4));
		
		// case 5
		LinkedList ll5 = new LinkedList();
		ll5.addNodeToTail(1);ll5.addNodeToTail(2);ll5.addNodeToTail(3);ll5.addNodeToTail(4).next = ll5.getHead();
		Node secondCLL5 = ll5.splitCircularLinkedList(ll5.getHead());
		List<Integer> expected5First = new ArrayList<Integer>(); expected5First.add(1);expected5First.add(2);
		assertEquals(expected4First, ll5.traverseCircularLinkedList(ll5.getHead()));
		List<Integer> expected5Second = new ArrayList<Integer>(); expected5Second.add(3); expected5Second.add(4);
		assertEquals(expected5Second, ll5.traverseCircularLinkedList(secondCLL5));
	}
	
	@Test
	public void testReverseSetOfThree() {
		// case 1
		LinkedList ll1 = new LinkedList();
		ll1.reverseSetOfThree(ll1.getHead());
		List<Integer> expected1 = new ArrayList<Integer>();
		assertEquals(expected1, ll1.traverse());
		
		// case 2
		LinkedList ll2 = new LinkedList();
		ll2.add(1);
		ll2.reverseSetOfThree(ll2.getHead());
		List<Integer> expected2 = new ArrayList<Integer>(); expected2.add(1);
		assertEquals(expected2, ll2.traverse());
		
		// case 3
		LinkedList ll3 = new LinkedList();
		ll3.addToTail(1);ll3.addToTail(2);
		ll3.reverseSetOfThree(ll3.getHead());
		List<Integer> expected3 = new ArrayList<Integer>(); expected3.add(1); expected3.add(2);
		assertEquals(expected3, ll3.traverse());
		
		// case 4
		LinkedList ll4 = new LinkedList();
		ll4.addToTail(1);ll4.addToTail(2);ll4.addToTail(3);
		LinkedList ll4New = new LinkedList();
		ll4New.addToTail(ll4.reverseSetOfThree(ll4.getHead()));
		List<Integer> expected4 = new ArrayList<Integer>(); expected4.add(3); expected4.add(2); expected4.add(1);
		assertEquals(expected4, ll4New.traverse());		
		
		// case 5
		LinkedList ll5 = new LinkedList();
		ll5.addToTail(1);ll5.addToTail(2);ll5.addToTail(3);ll5.addToTail(4);
		LinkedList ll5New = new LinkedList();
		ll5New.addToTail(ll5.reverseSetOfThree(ll5.getHead()));
		List<Integer> expected5 = new ArrayList<Integer>(); expected5.add(3); expected5.add(2); expected5.add(1); expected5.add(4);
		assertEquals(expected5, ll5New.traverse());		

		// case 6
		LinkedList ll6 = new LinkedList();
		ll6.addToTail(1);ll6.addToTail(2);ll6.addToTail(3);ll6.addToTail(4);ll6.addToTail(5);
		LinkedList ll6New = new LinkedList();
		ll6New.addToTail(ll6.reverseSetOfThree(ll6.getHead()));
		List<Integer> expected6 = new ArrayList<Integer>(); expected6.add(3); expected6.add(2); expected6.add(1); expected6.add(4); expected6.add(5);
		assertEquals(expected6, ll6New.traverse());		
		
		// case 7
		LinkedList ll7 = new LinkedList();
		ll7.addToTail(1);ll7.addToTail(2);ll7.addToTail(3);ll7.addToTail(4);ll7.addToTail(5);ll7.addToTail(6);
		LinkedList ll7New = new LinkedList();
		ll7New.addToTail(ll7.reverseSetOfThree(ll7.getHead()));
		List<Integer> expected7 = new ArrayList<Integer>(); expected7.add(3); expected7.add(2); expected7.add(1); expected7.add(6); expected7.add(5);expected7.add(4);
		assertEquals(expected7, ll7New.traverse());		
		
		// case 8
		LinkedList ll8 = new LinkedList();
		ll8.addToTail(1);ll8.addToTail(2);ll8.addToTail(3);ll8.addToTail(4);ll8.addToTail(5);ll8.addToTail(6);ll8.addToTail(7);
		LinkedList ll8New = new LinkedList();
		ll8New.addToTail(ll8.reverseSetOfThree(ll8.getHead()));
		List<Integer> expected8 = new ArrayList<Integer>(); expected8.add(3); expected8.add(2); expected8.add(1); expected8.add(6); expected8.add(5);expected8.add(4);expected8.add(7);
		assertEquals(expected8, ll8New.traverse());		
	}
	
	@Test
	public void testShift() {
		
		// left shift cases
		// case 1
		LinkedList ll1 = new LinkedList();
		ll1.reverseSetOfThree(ll1.getHead());
		List<Integer> expected1 = new ArrayList<Integer>();
		assertEquals(expected1, ll1.traverse());
		
		// case 2
		LinkedList ll2 = new LinkedList();
		ll2.add(1);
		ll2.reverseSetOfThree(ll2.getHead());
		List<Integer> expected2 = new ArrayList<Integer>(); expected2.add(1);
		assertEquals(expected2, ll2.traverse());
		
		// case 3
		LinkedList ll3 = new LinkedList();
		ll3.addToTail(1);ll3.addToTail(2);
		ll3.reverseSetOfThree(ll3.getHead());
		List<Integer> expected3 = new ArrayList<Integer>(); expected3.add(1); expected3.add(2);
		assertEquals(expected3, ll3.traverse());
		
		// case 4
		LinkedList ll4 = new LinkedList();
		ll4.addToTail(1);ll4.addToTail(2);ll4.addToTail(3);
		LinkedList ll4New = new LinkedList();
		ll4New.addToTail(ll4.reverseSetOfThree(ll4.getHead()));
		List<Integer> expected4 = new ArrayList<Integer>(); expected4.add(3); expected4.add(2); expected4.add(1);
		assertEquals(expected4, ll4New.traverse());		
		
		// case 5
		LinkedList ll5 = new LinkedList();
		ll5.addToTail(1);ll5.addToTail(2);ll5.addToTail(3);ll5.addToTail(4);
		LinkedList ll5New = new LinkedList();
		ll5New.addToTail(ll5.reverseSetOfThree(ll5.getHead()));
		List<Integer> expected5 = new ArrayList<Integer>(); expected5.add(3); expected5.add(2); expected5.add(1); expected5.add(4);
		assertEquals(expected5, ll5New.traverse());		

		// case 6
		LinkedList ll6 = new LinkedList();
		ll6.addToTail(1);ll6.addToTail(2);ll6.addToTail(3);ll6.addToTail(4);ll6.addToTail(5);
		LinkedList ll6New = new LinkedList();
		ll6New.addToTail(ll6.reverseSetOfThree(ll6.getHead()));
		List<Integer> expected6 = new ArrayList<Integer>(); expected6.add(3); expected6.add(2); expected6.add(1); expected6.add(4); expected6.add(5);
		assertEquals(expected6, ll6New.traverse());		
		
		// case 7
		LinkedList ll7 = new LinkedList();
		ll7.addToTail(1);ll7.addToTail(2);ll7.addToTail(3);ll7.addToTail(4);ll7.addToTail(5);ll7.addToTail(6);
		LinkedList ll7New = new LinkedList();
		ll7New.addToTail(ll7.reverseSetOfThree(ll7.getHead()));
		List<Integer> expected7 = new ArrayList<Integer>(); expected7.add(3); expected7.add(2); expected7.add(1); expected7.add(6); expected7.add(5);expected7.add(4);
		assertEquals(expected7, ll7New.traverse());		
		
		// case 8
		LinkedList ll8 = new LinkedList();
		ll8.addToTail(1);ll8.addToTail(2);ll8.addToTail(3);ll8.addToTail(4);ll8.addToTail(5);ll8.addToTail(6);ll8.addToTail(7);
		LinkedList ll8New = new LinkedList();
		ll8New.addToTail(ll8.reverseSetOfThree(ll8.getHead()));
		List<Integer> expected8 = new ArrayList<Integer>(); expected8.add(3); expected8.add(2); expected8.add(1); expected8.add(6); expected8.add(5);expected8.add(4);expected8.add(7);
		assertEquals(expected8, ll8New.traverse());				
	}

	
	@Test
	public void testReverse() {
		
		// case 1
		LinkedList ll1 = new LinkedList();
		ll1.setHead(ll1.reverse(ll1.getHead()));
		List<Integer> expected1 = new ArrayList<Integer>();
		assertEquals(expected1, ll1.traverse());
		
		// case 2
		LinkedList ll2 = new LinkedList();
		ll2.add(1);
		ll2.setHead(ll2.reverse(ll2.getHead()));
		List<Integer> expected2 = new ArrayList<Integer>(); expected2.add(1);
		assertEquals(expected2, ll2.traverse());
		
		// case 3
		LinkedList ll3 = new LinkedList();
		ll3.addToTail(1);ll3.addToTail(2);
		ll3.setHead(ll3.reverse(ll3.getHead()));
		List<Integer> expected3 = new ArrayList<Integer>(); expected3.add(2); expected3.add(1);
		assertEquals(expected3, ll3.traverse());
		
		// case 4
		LinkedList ll4 = new LinkedList();
		ll4.addToTail(1);ll4.addToTail(2);ll4.addToTail(3);
		ll4.setHead(ll4.reverse(ll4.getHead()));
		List<Integer> expected4 = new ArrayList<Integer>(); expected4.add(3); expected4.add(2); expected4.add(1);
		assertEquals(expected4, ll4.traverse());		
		
		// case 5
		LinkedList ll5 = new LinkedList();
		ll5.addToTail(1);ll5.addToTail(2);ll5.addToTail(3);ll5.addToTail(4);ll5.addToTail(5);ll5.addToTail(6);ll5.addToTail(7);
		ll5.setHead(ll5.reverse(ll5.getHead()));
		List<Integer> expected5 = new ArrayList<Integer>(); expected5.add(7); expected5.add(6); expected5.add(5); expected5.add(4); expected5.add(3);expected5.add(2);expected5.add(1);
		assertEquals(expected5, ll5.traverse());				
	}
	
	
	@Test
	public void testReverseRecursively() {
		
		// case 1
		/*LinkedList ll1 = new LinkedList();
		ll1.setHead(ll1.reverseRecursively(ll1.getHead()));
		List<Integer> expected1 = new ArrayList<Integer>();
		assertEquals(expected1, ll1.traverse());
		
		// case 2
		LinkedList ll2 = new LinkedList();
		ll2.add(1);
		ll2.setHead(ll2.reverseRecursively(ll2.getHead()));
		List<Integer> expected2 = new ArrayList<Integer>(); expected2.add(1);
		assertEquals(expected2, ll2.traverse());*/
		
		// case 3
		LinkedList ll3 = new LinkedList();
		ll3.addToTail(1);ll3.addToTail(2);
		//ll3.setHead(ll3.reverseRecursively(ll3.getHead(), ll3.getHead().next));
		List<Integer> expected3 = new ArrayList<Integer>(); expected3.add(2); expected3.add(1);
		assertEquals(expected3, ll3.traverse());
		
		// case 4
		/*LinkedList ll4 = new LinkedList();
		ll4.addToTail(1);ll4.addToTail(2);ll4.addToTail(3);
		ll4.setHead(ll4.reverseRecursively(ll4.getHead()));
		List<Integer> expected4 = new ArrayList<Integer>(); expected4.add(3); expected4.add(2); expected4.add(1);
		assertEquals(expected4, ll4.traverse());		
		
		// case 5
		LinkedList ll5 = new LinkedList();
		ll5.addToTail(1);ll5.addToTail(2);ll5.addToTail(3);ll5.addToTail(4);ll5.addToTail(5);ll5.addToTail(6);ll5.addToTail(7);
		ll5.setHead(ll5.reverseRecursively(ll5.getHead()));
		List<Integer> expected5 = new ArrayList<Integer>(); expected5.add(7); expected5.add(6); expected5.add(5); expected5.add(4); expected5.add(3);expected5.add(2);expected5.add(1);
		assertEquals(expected5, ll5.traverse());*/				
	}
	
	@Test
	public void testIsPalindrome() {
		
		// case 1
		LinkedList ll1 = new LinkedList();
		List<Integer> before1 = ll1.traverse();
		assertTrue(ll1.isPalindrome(ll1.getHead()));
		assertEquals(before1, ll1.traverse());
		
		// case 2
		LinkedList ll2 = new LinkedList();
		ll2.add(1);
		List<Integer> before2 = ll2.traverse();
		assertTrue(ll2.isPalindrome(ll2.getHead()));
		assertEquals(before2, ll2.traverse());
		
		// case 3
		LinkedList ll3 = new LinkedList();
		ll3.addToTail(1);ll3.addToTail(2);
		List<Integer> before3 = ll3.traverse();
		assertTrue(!ll3.isPalindrome(ll3.getHead()));
		assertEquals(before3, ll3.traverse());
		
		// case 4
		LinkedList ll4 = new LinkedList();
		ll4.addToTail(1);ll4.addToTail(2);ll4.addToTail(3);
		List<Integer> before4 = ll4.traverse();
		assertTrue(!ll4.isPalindrome(ll4.getHead()));
		assertEquals(before4, ll4.traverse());
		
		// case 5
		LinkedList ll5 = new LinkedList();
		ll5.addToTail(1);ll5.addToTail(2);ll5.addToTail(1);
		List<Integer> before5 = ll5.traverse();
		assertTrue(ll5.isPalindrome(ll5.getHead()));
		assertEquals(before5, ll5.traverse());
		
		// case 6
		LinkedList ll6 = new LinkedList();
		ll6.addToTail(1);ll6.addToTail(2);ll6.addToTail(2);ll6.addToTail(1);
		List<Integer> before6 = ll6.traverse();
		assertTrue(ll6.isPalindrome(ll6.getHead()));
		assertEquals(before6, ll6.traverse());
		
		// case 7
		LinkedList ll7 = new LinkedList();
		ll7.addToTail(1);ll7.addToTail(2);ll7.addToTail(3);ll7.addToTail(2);ll7.addToTail(1);
		List<Integer> before7 = ll7.traverse();
		assertTrue(ll7.isPalindrome(ll7.getHead()));
		assertEquals(before7, ll7.traverse());
		
		// case 8
		LinkedList ll8 = new LinkedList();
		ll8.addToTail(1);ll8.addToTail(2);ll8.addToTail(3);ll8.addToTail(1);ll8.addToTail(1);
		List<Integer> before8 = ll8.traverse();
		assertTrue(!ll8.isPalindrome(ll8.getHead()));
		assertEquals(before8, ll8.traverse());
		
	}
	
	
	@Test
	public void testAreSameLinkedLists() {
		
		// case 1
		LinkedList ll1 = new LinkedList();
		LinkedList ll2 = new LinkedList();
		assertTrue(ll1.areSameLinkedLists(ll1.getHead(), ll2.getHead()));
		
		// case 2
		ll1 = new LinkedList();
		ll2 = new LinkedList();
		ll2.add(1);
		assertTrue(!ll1.areSameLinkedLists(ll1.getHead(), ll2.getHead()));
		
		// case 3
		ll1 = new LinkedList();
		ll2 = new LinkedList();
		ll1.addToTail(1);ll1.addToTail(2);
		ll2.add(1);
		assertTrue(!ll1.areSameLinkedLists(ll1.getHead(), ll2.getHead()));
		
		// case 4
		ll1 = new LinkedList();
		ll2 = new LinkedList();
		ll1.addToTail(1);ll1.addToTail(2);
		ll2.addToTail(1);ll2.addToTail(2);
		assertTrue(ll1.areSameLinkedLists(ll1.getHead(), ll2.getHead()));
		
		// case 5
		ll1 = new LinkedList();
		ll2 = new LinkedList();
		ll1.addToTail(1);ll1.addToTail(2);ll1.addToTail(3);ll1.addToTail(1);ll1.addToTail(1);
		ll2.addToTail(1);ll2.addToTail(2);ll2.addToTail(3);ll2.addToTail(1);ll2.addToTail(1);
		assertTrue(ll1.areSameLinkedLists(ll1.getHead(), ll2.getHead()));
		
		// case 6
		ll1 = new LinkedList();
		ll2 = new LinkedList();
		ll1.addToTail(1);ll1.addToTail(2);ll1.addToTail(3);ll1.addToTail(1);ll1.addToTail(1);
		ll2.addToTail(1);ll2.addToTail(2);ll2.addToTail(5);ll2.addToTail(1);ll2.addToTail(1);
		assertTrue(!ll1.areSameLinkedLists(ll1.getHead(), ll2.getHead()));
	}
	
	
	@Test
	public void testReverseSetOfKNodes() {

		// for k as 2
		// case 1
		LinkedList ll1 = new LinkedList();
		assertTrue(ll1.reverseSetOfKNodes(ll1.getHead(), 2) == null);
		
		// case 2
		LinkedList ll2 = new LinkedList();
		ll2.addToTail(1);
		List<Integer> expected2 = new ArrayList<Integer>(); expected2.add(1);
		ll2.reverseSetOfKNodes(ll2.getHead(), 2);
		assertEquals(expected2, ll2.traverse());
		
		// case 3
		LinkedList ll3 = new LinkedList();
		ll3.addToTail(1);ll3.addToTail(2);
		List<Integer> expected3 = new ArrayList<Integer>(); expected3.add(2); expected3.add(1);
		LinkedList ll3New = new LinkedList();
		ll3New.addToTail(ll3.reverseSetOfKNodes(ll3.getHead(),2));
		assertEquals(expected3, ll3New.traverse());
		
		// case 4
		LinkedList ll4 = new LinkedList();
		ll4.addToTail(1);ll4.addToTail(2);ll4.addToTail(3);
		List<Integer> expected4 = new ArrayList<Integer>(); expected4.add(2); expected4.add(1); expected4.add(3);
		LinkedList ll4New = new LinkedList();
		ll4New.addToTail(ll4.reverseSetOfKNodes(ll4.getHead(), 2));
		assertEquals(expected4, ll4New.traverse());

		// case 5
		LinkedList ll5 = new LinkedList();
		ll5.addToTail(1);ll5.addToTail(3);ll5.addToTail(2);ll5.addToTail(4);
		List<Integer> expected5 = new ArrayList<Integer>(); expected5.add(3); expected5.add(1); expected5.add(4); expected5.add(2);
		LinkedList ll5New = new LinkedList();
		ll5New.addToTail(ll5.reverseSetOfKNodes(ll5.getHead(), 2));
		assertEquals(expected5, ll5New.traverse());
		
		// for k as 3
		// case 1
		ll1 = new LinkedList();
		ll1.reverseSetOfKNodes(ll1.getHead(), 3);
		List<Integer> expected1 = new ArrayList<Integer>();
		assertEquals(expected1, ll1.traverse());
		
		// case 2
		ll2 = new LinkedList();
		ll2.add(1);
		ll2.reverseSetOfKNodes(ll2.getHead(), 3);
		expected2 = new ArrayList<Integer>(); expected2.add(1);
		assertEquals(expected2, ll2.traverse());
		
		// case 3
		ll3 = new LinkedList();
		ll3.addToTail(1);ll3.addToTail(2);
		ll3.reverseSetOfKNodes(ll3.getHead(), 3);
		expected3 = new ArrayList<Integer>(); expected3.add(1); expected3.add(2);
		assertEquals(expected3, ll3.traverse());
		
		// case 4
		ll4 = new LinkedList();
		ll4.addToTail(1);ll4.addToTail(2);ll4.addToTail(3);
		ll4New = new LinkedList();
		ll4New.addToTail(ll4.reverseSetOfKNodes(ll4.getHead(), 3));
		expected4 = new ArrayList<Integer>(); expected4.add(3); expected4.add(2); expected4.add(1);
		assertEquals(expected4, ll4New.traverse());		
		
		// case 5
		ll5 = new LinkedList();
		ll5.addToTail(1);ll5.addToTail(2);ll5.addToTail(3);ll5.addToTail(4);
		ll5New = new LinkedList();
		ll5New.addToTail(ll5.reverseSetOfKNodes(ll5.getHead(), 3));
		expected5 = new ArrayList<Integer>(); expected5.add(3); expected5.add(2); expected5.add(1); expected5.add(4);
		assertEquals(expected5, ll5New.traverse());		

		// case 6
		LinkedList ll6 = new LinkedList();
		ll6.addToTail(1);ll6.addToTail(2);ll6.addToTail(3);ll6.addToTail(4);ll6.addToTail(5);
		LinkedList ll6New = new LinkedList();
		ll6New.addToTail(ll6.reverseSetOfKNodes(ll6.getHead(), 3));
		List<Integer> expected6 = new ArrayList<Integer>(); expected6.add(3); expected6.add(2); expected6.add(1); expected6.add(4); expected6.add(5);
		assertEquals(expected6, ll6New.traverse());		
		
		// case 7
		LinkedList ll7 = new LinkedList();
		ll7.addToTail(1);ll7.addToTail(2);ll7.addToTail(3);ll7.addToTail(4);ll7.addToTail(5);ll7.addToTail(6);
		LinkedList ll7New = new LinkedList();
		ll7New.addToTail(ll7.reverseSetOfKNodes(ll7.getHead(), 3));
		List<Integer> expected7 = new ArrayList<Integer>(); expected7.add(3); expected7.add(2); expected7.add(1); expected7.add(6); expected7.add(5);expected7.add(4);
		assertEquals(expected7, ll7New.traverse());		
		
		// case 8
		LinkedList ll8 = new LinkedList();
		ll8.addToTail(1);ll8.addToTail(2);ll8.addToTail(3);ll8.addToTail(4);ll8.addToTail(5);ll8.addToTail(6);ll8.addToTail(7);
		LinkedList ll8New = new LinkedList();
		ll8New.addToTail(ll8.reverseSetOfKNodes(ll8.getHead(), 3));
		List<Integer> expected8 = new ArrayList<Integer>(); expected8.add(3); expected8.add(2); expected8.add(1); expected8.add(6); expected8.add(5);expected8.add(4);expected8.add(7);
		assertEquals(expected8, ll8New.traverse());		
		
		
		// for k as 1
		// case 1
		ll1 = new LinkedList();
		ll1.setHead(ll1.reverseSetOfKNodes(ll1.getHead(), 1));
		expected1 = new ArrayList<Integer>();
		assertEquals(expected1, ll1.traverse());
		
		// case 2
		ll2 = new LinkedList();
		ll2.add(1);
		ll2.setHead(ll2.reverseSetOfKNodes(ll2.getHead(), 1));
		expected2 = new ArrayList<Integer>(); expected2.add(1);
		assertEquals(expected2, ll2.traverse());
		
		// case 3
		ll3 = new LinkedList();
		ll3.addToTail(1);ll3.addToTail(2);
		ll3.setHead(ll3.reverseSetOfKNodes(ll3.getHead(), 1));
		expected3 = new ArrayList<Integer>(); expected3.add(2); expected3.add(1);
		assertEquals(expected3, ll3.traverse());
		
		// case 4
		ll4 = new LinkedList();
		ll4.addToTail(1);ll4.addToTail(2);ll4.addToTail(3);
		ll4.setHead(ll4.reverseSetOfKNodes(ll4.getHead(), 1));
		expected4 = new ArrayList<Integer>(); expected4.add(3); expected4.add(2); expected4.add(1);
		assertEquals(expected4, ll4.traverse());		
		
		// case 5
		ll5 = new LinkedList();
		ll5.addToTail(1);ll5.addToTail(2);ll5.addToTail(3);ll5.addToTail(4);ll5.addToTail(5);ll5.addToTail(6);ll5.addToTail(7);
		ll5.setHead(ll5.reverseSetOfKNodes(ll5.getHead(), 1));
		expected5 = new ArrayList<Integer>(); expected5.add(7); expected5.add(6); expected5.add(5); expected5.add(4); expected5.add(3);expected5.add(2);expected5.add(1);
		assertEquals(expected5, ll5.traverse());				
		
	}
	
	
	@Test
	public void testCloneSpecialTree() {
		
		LinkedList ll = new LinkedList();
		
		Node secondNode = null; // it'll point to 6th node
		Node forthNode = null; // it'll point to 8th node
		Node fifthNode = null; // it'll point to 2nd node
		Node sixthNode = null; 
		Node eighthNode = null; 
		
		for(int i = 1; i <= 10; i++) {
			if(i == 2) {
				secondNode = new NodeWithRandomPointer(i);
				ll.addToTail(secondNode);
			} else if(i == 4) {
				forthNode = new NodeWithRandomPointer(i);
				ll.addToTail(forthNode);
			} else if(i == 5) {
				fifthNode = new NodeWithRandomPointer(i);
				ll.addToTail(fifthNode);
			} else if(i == 6) {
				sixthNode = new NodeWithRandomPointer(i);
				ll.addToTail(sixthNode);
			} else if(i == 8) {
				eighthNode = new NodeWithRandomPointer(i);
				ll.addToTail(eighthNode);
			} else {
				ll.addToTail(new NodeWithRandomPointer(i));
			}  
		}
		
		((NodeWithRandomPointer)secondNode).random = sixthNode;
		((NodeWithRandomPointer)forthNode).random = eighthNode;
		((NodeWithRandomPointer)fifthNode).random = secondNode;
		
		
		// traverse first tree
		System.out.println("traverse first tree: ");
		ll.traverseSpecialTree((NodeWithRandomPointer)ll.getHead());
		
		// traverse cloned tree
		System.out.println("traverse cloned tree: ");
		NodeWithRandomPointer nodeHeadClone = ll.cloneSpecialTree((NodeWithRandomPointer)ll.getHead());
		ll.traverseSpecialTree(nodeHeadClone);
	}
	
	
	@Test 
	public void testGetLeader() {
		
		// case 1 with k as 2
		LinkedList ll = new LinkedList();
		
		Node lastNode = null;
		for(int i = 1; i <= 10; i++) {
			lastNode = new Node(i);
			ll.addToTail(lastNode);
		}
		
		// make it circular
		lastNode.next = ll.getHead();
		assertTrue(ll.getLeader(ll.getHead(), 2).data == 6);
		
		
		// case 1 with k as 3
		ll = new LinkedList();
		
		lastNode = null;
		for(int i = 1; i <= 10; i++) {
			lastNode = new Node(i);
			ll.addToTail(lastNode);
		}
		
		// make it circular
		lastNode.next = ll.getHead();
		assertTrue(ll.getLeader(ll.getHead(), 3).data == 5);
		
		
		// case 1 with k as 1
		ll = new LinkedList();
		
		lastNode = null;
		for(int i = 1; i <= 10; i++) {
			lastNode = new Node(i);
			ll.addToTail(lastNode);
		}
		
		// make it circular
		lastNode.next = ll.getHead();
		assertTrue(ll.getLeader(ll.getHead(), 1).data == 1);
		
	}
	
	
	@Test
	public void testInsertInSortedOrder() {
		// case 1
		LinkedList ll1 = new LinkedList();
		ll1.insertInSortedOrder(50);
		List<Integer> expected1 = new ArrayList<Integer>(); expected1.add(50);
		assertEquals(expected1, ll1.traverse());
		
		ll1.insertInSortedOrder(100);
		List<Integer> expected2 = new ArrayList<Integer>(); expected2.add(50); expected2.add(100);
		assertEquals(expected2, ll1.traverse());

		ll1.insertInSortedOrder(30);
		List<Integer> expected3 = new ArrayList<Integer>(); expected3.add(30); expected3.add(50); expected3.add(100);
		assertEquals(expected3, ll1.traverse());
		
		ll1.insertInSortedOrder(150);
		List<Integer> expected4 = new ArrayList<Integer>(); expected4.add(30); expected4.add(50); expected4.add(100); expected4.add(150);
		assertEquals(expected4, ll1.traverse());
		
		ll1.insertInSortedOrder(1);
		List<Integer> expected5 = new ArrayList<Integer>(); expected5.add(1); expected5.add(30); expected5.add(50); expected5.add(100); expected5.add(150);
		assertEquals(expected5, ll1.traverse());
		
		ll1.insertInSortedOrder(110);
		List<Integer> expected6 = new ArrayList<Integer>(); expected6.add(1); expected6.add(30); expected6.add(50); expected6.add(100); expected6.add(110); expected6.add(150);
		assertEquals(expected6, ll1.traverse());
		
		ll1.insertInSortedOrder(200);
		List<Integer> expected7 = new ArrayList<Integer>(); expected7.add(1); expected7.add(30); expected7.add(50); expected7.add(100); expected7.add(110); expected7.add(150); expected7.add(200);
		assertEquals(expected7, ll1.traverse());
	}
	
}

