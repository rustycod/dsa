package org.sample.practice.tree;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class BinarySearchTreeTest {

	@Test
	public void testBasicOperations() {
		
		BinarySearchTree bst = new BinarySearchTree();
		assert(bst.root == null);
		assertTrue(bst.listNodeValues.isEmpty());
		
		// inserting few values
		bst.insert(4);
		bst.insert(77);
		bst.insert(5);
		bst.insert(17);
		bst.insert(57);
		bst.insert(2);
		bst.insert(74);
		bst.insert(7);
		bst.insert(70);

		BTreePrinter.printNode(bst.root);
		
		bst.listNodeValues.clear();
		bst.preOrder(bst.root); // preOrder or postOrder can uniquely identify a BST
		List<Integer> expected = new ArrayList<Integer>();
		expected.add(4);expected.add(2);expected.add(77);expected.add(5);expected.add(17);
		expected.add(7);expected.add(57);expected.add(74);expected.add(70);
		System.out.println(expected);
		System.out.println(bst.listNodeValues);
		assertEquals(expected, bst.listNodeValues);
		
		
		assertNull(bst.search(50));
		assertNull(bst.search(59));
		assertTrue(bst.search(2).val == 2);
		assertTrue(bst.search(74).val == 74);
		assertTrue(bst.search(4).val == 4);
		
		assertTrue(bst.findMinimum(bst.root).val == 2);
		assertTrue(bst.findMaximum(bst.root).val == 77);
		

	}
	
	
	@Test
	public void testMirror() {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(50);bst.insert(14);bst.insert(66);bst.insert(71);bst.insert(45);
		bst.insert(24);bst.insert(9);bst.insert(69);bst.insert(68);bst.insert(7);
		
		System.out.println("Before mirror: ");
		BTreePrinter.printNode(bst.root);
		
		bst.listNodeValues.clear();
		bst.preOrder(bst.root);
		
		List<Integer> expected = new ArrayList<Integer>();
		expected.add(50);expected.add(14);expected.add(9);expected.add(7);expected.add(45);
		expected.add(24);expected.add(66);expected.add(71);expected.add(69);expected.add(68);
		
		assertEquals(expected, bst.listNodeValues);

		// mirror
		bst.createMirror(bst.root);
		
		bst.listNodeValues.clear();
		bst.preOrder(bst.root);
		
		List<Integer> expected2 = new ArrayList<Integer>();
		expected2.add(50);expected2.add(66);expected2.add(71);expected2.add(69);expected2.add(68);
		expected2.add(14);expected2.add(45);expected2.add(24);expected2.add(9);expected2.add(7);
		
		assertEquals(expected2, bst.listNodeValues);

		System.out.println("After mirror: ");
		BTreePrinter.printNode(bst.root);
	}
	
	
	@Test
	public void testIsBSTValid() {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(50);bst.insert(14);bst.insert(66);bst.insert(71);bst.insert(45);
		bst.insert(24);bst.insert(9);bst.insert(69);bst.insert(68);bst.insert(7);
		
		System.out.println("Before mirror: ");
		BTreePrinter.printNode(bst.root);
		
		bst.listNodeValues.clear();
		bst.preOrder(bst.root);
		
		List<Integer> expected = new ArrayList<Integer>();
		expected.add(50);expected.add(14);expected.add(9);expected.add(7);expected.add(45);
		expected.add(24);expected.add(66);expected.add(71);expected.add(69);expected.add(68);
		
		assertEquals(expected, bst.listNodeValues);
		assertTrue(bst.isValidBST(bst.root, Integer.MIN_VALUE, Integer.MAX_VALUE));

		// mirror
		bst.createMirror(bst.root);
		
		bst.listNodeValues.clear();
		bst.preOrder(bst.root);
		
		List<Integer> expected2 = new ArrayList<Integer>();
		expected2.add(50);expected2.add(66);expected2.add(71);expected2.add(69);expected2.add(68);
		expected2.add(14);expected2.add(45);expected2.add(24);expected2.add(9);expected2.add(7);
		
		assertEquals(expected2, bst.listNodeValues);

		System.out.println("After mirror: ");
		BTreePrinter.printNode(bst.root);
		assertTrue(!bst.isValidBST(bst.root, Integer.MIN_VALUE, Integer.MAX_VALUE));
	}
	
	
	@Test
	public void testFindLCM() {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(50);bst.insert(14);bst.insert(66);bst.insert(71);bst.insert(45);
		bst.insert(24);bst.insert(9);bst.insert(69);bst.insert(68);bst.insert(7);
		
		BTreePrinter.printNode(bst.root);
		
		bst.listNodeValues.clear();
		bst.preOrder(bst.root);
		
		List<Integer> expected = new ArrayList<Integer>();
		expected.add(50);expected.add(14);expected.add(9);expected.add(7);expected.add(45);
		expected.add(24);expected.add(66);expected.add(71);expected.add(69);expected.add(68);
		
		assertEquals(expected, bst.listNodeValues);
		assertTrue(bst.findLCA(bst.root, 7, 68) == 50);
		assertTrue(bst.findLCA(bst.root, 50, 68) == 50);
		assertTrue(bst.findLCA(bst.root, 7, 50) == 50);
		assertTrue(bst.findLCA(bst.root, 7, 45) == 14);
		assertTrue(bst.findLCA(bst.root, 7, 9) == 9);
		assertTrue(bst.findLCA(bst.root, 68, 69) == 69);
		assertTrue(bst.findLCA(bst.root, 66, 71) == 66);
		
	}
	
	//@Test
	/*public void testKthSmallestElement() {
		
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(50);bst.insert(14);bst.insert(66);bst.insert(71);bst.insert(45);
		bst.insert(24);bst.insert(9);bst.insert(69);bst.insert(68);bst.insert(7);
		
		BTreePrinter.printNode(bst.root);
		
		bst.listNodeValues.clear();
		bst.preOrder(bst.root);
		
		List<Integer> expected = new ArrayList<Integer>();
		expected.add(50);expected.add(14);expected.add(9);expected.add(7);expected.add(45);
		expected.add(24);expected.add(66);expected.add(71);expected.add(69);expected.add(68);
		
		assertEquals(expected, bst.listNodeValues);
		
		bst.count = 1;
		bst.kthNode = null;
		bst.findKthSmallest(bst.root, 7);
		assertTrue(bst.kthNode.val == 66);
		
		bst.count = 1;
		bst.kthNode = null;
		bst.findKthSmallest(bst.root, 6);
		assertTrue(bst.kthNode.val == 50);
		
		bst.count = 1;
		bst.kthNode = null;
		bst.findKthSmallest(bst.root, 1);
		assertTrue(bst.kthNode.val == 7);
	}*/
	
	
	@Test
	public void testGetAllRootToLeafPaths() {
		
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(50);bst.insert(14);bst.insert(66);bst.insert(71);bst.insert(45);
		bst.insert(24);bst.insert(9);bst.insert(69);bst.insert(68);bst.insert(7);
		
		BTreePrinter.printNode(bst.root);
		
		bst.listNodeValues.clear();
		bst.preOrder(bst.root);
		
		List<Integer> expected = new ArrayList<Integer>();
		expected.add(50);expected.add(14);expected.add(9);expected.add(7);expected.add(45);
		expected.add(24);expected.add(66);expected.add(71);expected.add(69);expected.add(68);
		
		assertEquals(expected, bst.listNodeValues);
		
		//bst.listPaths.clear();
		bst.listAllRootToLeafPaths.clear();
		bst.getAllRootToLeafPaths(bst.root, 0);
		
		List<List<Integer>> expectedList = new ArrayList<List<Integer>>();
		List<Integer> list1 = new ArrayList<Integer>(); list1.add(50); list1.add(14); list1.add(9); list1.add(7);
		List<Integer> list2 = new ArrayList<Integer>(); list2.add(50); list2.add(14); list2.add(45); list2.add(24);
		List<Integer> list3 = new ArrayList<Integer>(); list3.add(50); list3.add(66); list3.add(71); list3.add(69); list3.add(68);
		expectedList.add(list1);expectedList.add(list2);expectedList.add(list3);
		
		//assertEquals(expectedList, bst.listAllRootToLeafPaths); // this needs to be changed
		
		//bst.getAllRootToLeafPaths(bst.root, new ArrayList<Integer>());
	}
	
	@Test
	public void testFindAncestorsOfANode() {
		
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(50);bst.insert(14);bst.insert(66);bst.insert(71);bst.insert(45);
		bst.insert(24);bst.insert(9);bst.insert(69);bst.insert(68);bst.insert(7);
		
		BTreePrinter.printNode(bst.root);
		
		bst.listNodeValues.clear();
		bst.preOrder(bst.root);
		
		List<Integer> expected = new ArrayList<Integer>();
		expected.add(50);expected.add(14);expected.add(9);expected.add(7);expected.add(45);
		expected.add(24);expected.add(66);expected.add(71);expected.add(69);expected.add(68);
		
		assertEquals(expected, bst.listNodeValues);
		
		bst.listAncestorsOfANode.clear();
		bst.findAncestorsOfANode(bst.root, 9);
		List<Integer> expectedList1 = new ArrayList<Integer>();
		expectedList1.add(50);expectedList1.add(14);expectedList1.add(9);
		//assertEquals(expectedList1, bst.listAncestorsOfANode); // this needs to be corrected
		
		bst.listAncestorsOfANode.clear();
		bst.findAncestorsOfANode(bst.root, 24);
		
		bst.listAncestorsOfANode.clear();
		bst.findAncestorsOfANode(bst.root, 45);
		
		bst.listAncestorsOfANode.clear();
		bst.findAncestorsOfANode(bst.root, 69);
		
	}
	
	
	@Test
	public void findAncestorsOfANodeUsingArray() {
		
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(50);bst.insert(14);bst.insert(66);bst.insert(71);bst.insert(45);
		bst.insert(24);bst.insert(9);bst.insert(69);bst.insert(68);bst.insert(7);
		
		BTreePrinter.printNode(bst.root);
		
		bst.listNodeValues.clear();
		bst.preOrder(bst.root);
		
		List<Integer> expected = new ArrayList<Integer>();
		expected.add(50);expected.add(14);expected.add(9);expected.add(7);expected.add(45);
		expected.add(24);expected.add(66);expected.add(71);expected.add(69);expected.add(68);
		
		assertEquals(expected, bst.listNodeValues);
		
		bst.arrAncestors = new int[256];
		bst.findAncestorsOfANodeUsingArray(bst.root, 9, 0);
		List<Integer> expectedList1 = new ArrayList<Integer>();
		expectedList1.add(50);expectedList1.add(14);expectedList1.add(9);
		//assertEquals(expectedList1, bst.listAncestorsOfANode); // this needs to be corrected
		
		bst.arrAncestors = new int[256];
		bst.findAncestorsOfANodeUsingArray(bst.root, 24, 0);
		
		bst.arrAncestors = new int[256];
		bst.findAncestorsOfANodeUsingArray(bst.root, 45, 0);
		
		bst.arrAncestors = new int[256];
		bst.findAncestorsOfANodeUsingArray(bst.root, 69, 0);
		
	}
	
	@Test
	public void testGetSize() {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(50);bst.insert(14);bst.insert(66);bst.insert(71);bst.insert(45);
		bst.insert(24);bst.insert(9);bst.insert(69);bst.insert(68);bst.insert(7);
		
		BTreePrinter.printNode(bst.root);
		
		bst.listNodeValues.clear();
		bst.preOrder(bst.root);
		
		List<Integer> expected = new ArrayList<Integer>();
		expected.add(50);expected.add(14);expected.add(9);expected.add(7);expected.add(45);
		expected.add(24);expected.add(66);expected.add(71);expected.add(69);expected.add(68);
		
		assertEquals(expected, bst.listNodeValues);
		
		assertTrue(bst.getSize(bst.root) == 10);
		assertTrue(bst.getSizeIteratively(bst.root) == 10);
	}
	
	@Test
	public void testGetHeight() {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(50);bst.insert(14);bst.insert(66);bst.insert(71);bst.insert(45);
		bst.insert(24);bst.insert(9);bst.insert(69);bst.insert(68);bst.insert(7);
		
		BTreePrinter.printNode(bst.root);
		
		bst.listNodeValues.clear();
		bst.preOrder(bst.root);
		
		List<Integer> expected = new ArrayList<Integer>();
		expected.add(50);expected.add(14);expected.add(9);expected.add(7);expected.add(45);
		expected.add(24);expected.add(66);expected.add(71);expected.add(69);expected.add(68);
		
		assertEquals(expected, bst.listNodeValues);
		
		assertTrue(bst.getHeight(bst.root) == 4);
		assertTrue(bst.getHeightIteratively(bst.root) == 4);
	}
	
	@Test
	public void testPrintLevelOrderReverse() {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(50);bst.insert(14);bst.insert(66);bst.insert(71);bst.insert(45);
		bst.insert(24);bst.insert(9);bst.insert(69);bst.insert(68);bst.insert(7);
		
		BTreePrinter.printNode(bst.root);
		
		bst.listNodeValues.clear();
		bst.preOrder(bst.root);
		
		List<Integer> expected = new ArrayList<Integer>();
		expected.add(50);expected.add(14);expected.add(9);expected.add(7);expected.add(45);
		expected.add(24);expected.add(66);expected.add(71);expected.add(69);expected.add(68);
		
		assertEquals(expected, bst.listNodeValues);
		
		List<Integer> expectedResult = new ArrayList<Integer>();
		expectedResult.add(68);expectedResult.add(7);expectedResult.add(24);expectedResult.add(69);expectedResult.add(9);
		expectedResult.add(45);expectedResult.add(71);expectedResult.add(14);expectedResult.add(66);expectedResult.add(50);
		
		assertEquals(expectedResult, bst.printLevelOrderReverse(bst.root));
	}
	
	
	@Test
	public void testIdenticalTrees() {
		// tree 1
		BinarySearchTree bst1 = new BinarySearchTree();
		bst1.insert(50);bst1.insert(14);bst1.insert(66);bst1.insert(71);bst1.insert(45);
		bst1.insert(24);bst1.insert(9);bst1.insert(69);bst1.insert(68);bst1.insert(7);
		
		BTreePrinter.printNode(bst1.root);
		
		bst1.listNodeValues.clear();
		bst1.preOrder(bst1.root);
		
		List<Integer> expected = new ArrayList<Integer>();
		expected.add(50);expected.add(14);expected.add(9);expected.add(7);expected.add(45);
		expected.add(24);expected.add(66);expected.add(71);expected.add(69);expected.add(68);
		
		assertEquals(expected, bst1.listNodeValues);
		

		// tree 2
		BinarySearchTree bst2 = new BinarySearchTree();
		bst2.insert(50);bst2.insert(14);bst2.insert(66);bst2.insert(71);bst2.insert(45);
		bst2.insert(24);bst2.insert(9);bst2.insert(69);bst2.insert(68);bst2.insert(7);
		
		BTreePrinter.printNode(bst2.root);
		
		bst2.listNodeValues.clear();
		bst2.preOrder(bst2.root);
		
		assertEquals(expected, bst2.listNodeValues);
		
		assertTrue(bst1.areIdenticalTrees(bst1.root, bst2.root));
	}
	
	
	@Test
	public void testAreMirrors() {
		// tree 1
		BinarySearchTree bst1 = new BinarySearchTree();
		bst1.insert(50);bst1.insert(14);bst1.insert(66);bst1.insert(71);bst1.insert(45);
		bst1.insert(24);bst1.insert(9);bst1.insert(69);bst1.insert(68);bst1.insert(7);
		
		BTreePrinter.printNode(bst1.root);
		
		bst1.listNodeValues.clear();
		bst1.preOrder(bst1.root);
		
		List<Integer> expected = new ArrayList<Integer>();
		expected.add(50);expected.add(14);expected.add(9);expected.add(7);expected.add(45);
		expected.add(24);expected.add(66);expected.add(71);expected.add(69);expected.add(68);
		
		assertEquals(expected, bst1.listNodeValues);
		

		// tree 2
		BinarySearchTree bst2 = new BinarySearchTree();
		bst2.insert(50);bst2.insert(14);bst2.insert(66);bst2.insert(71);bst2.insert(45);
		bst2.insert(24);bst2.insert(9);bst2.insert(69);bst2.insert(68);bst2.insert(7);
		
		bst2.listNodeValues.clear();
		bst2.preOrder(bst2.root);
		
		assertEquals(expected, bst2.listNodeValues);
		
		bst2.createMirror(bst2.root);
		BTreePrinter.printNode(bst2.root);
		
		assertTrue(!bst1.areIdenticalTrees(bst1.root, bst2.root));
		assertTrue(bst1.areMirrors(bst1.root, bst2.root));
	}
	
	
	@Test
	public void testDoesSumExist() {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(50);bst.insert(14);bst.insert(66);bst.insert(71);bst.insert(45);
		bst.insert(24);bst.insert(9);bst.insert(69);bst.insert(68);bst.insert(7);
		
		BTreePrinter.printNode(bst.root);
		
		bst.listNodeValues.clear();
		bst.preOrder(bst.root);
		
		List<Integer> expected = new ArrayList<Integer>();
		expected.add(50);expected.add(14);expected.add(9);expected.add(7);expected.add(45);
		expected.add(24);expected.add(66);expected.add(71);expected.add(69);expected.add(68);
		
		assertEquals(expected, bst.listNodeValues);
		
		assertTrue(bst.doesSumExist(bst.root, 109));
		assertTrue(!bst.doesSumExist(bst.root, 500));
		assertTrue(!bst.doesSumExist(bst.root, 10));
		assertTrue(bst.doesSumExist(bst.root, 256));
		assertTrue(bst.doesSumExist(bst.root, 73));
		
	}
	
	@Test
	public void testSum() {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(50);bst.insert(14);bst.insert(66);bst.insert(71);bst.insert(45);
		bst.insert(24);bst.insert(9);bst.insert(69);bst.insert(68);bst.insert(7);
		
		BTreePrinter.printNode(bst.root);
		
		bst.listNodeValues.clear();
		bst.preOrder(bst.root);
		
		List<Integer> expected = new ArrayList<Integer>();
		expected.add(50);expected.add(14);expected.add(9);expected.add(7);expected.add(45);
		expected.add(24);expected.add(66);expected.add(71);expected.add(69);expected.add(68);
		
		assertEquals(expected, bst.listNodeValues);
		
		assertTrue(bst.sum(bst.root) == 423);
	}
	
	
	@Test
	public void testFindDiameter() {
		
		// case 1
		BinarySearchTree bst1 = new BinarySearchTree();
		bst1.insert(12);
		BTreePrinter.printNode(bst1.root);
		
		bst1.listNodeValues.clear();
		bst1.preOrder(bst1.root);
		
		List<Integer> expected1 = new ArrayList<Integer>();
		expected1.add(12);
		
		assertEquals(expected1, bst1.listNodeValues);
		System.out.println(bst1.findDiameter(bst1.root));
		assertTrue(bst1.findDiameter(bst1.root) == 1);
		
		
		// case 2
		BinarySearchTree bst2 = new BinarySearchTree();
		bst2.insert(12);bst2.insert(4);bst2.insert(14);
		BTreePrinter.printNode(bst2.root);
		
		bst2.listNodeValues.clear();
		bst2.preOrder(bst2.root);
		
		List<Integer> expected2 = new ArrayList<Integer>();
		expected2.add(12);expected2.add(4);expected2.add(14);
		
		assertEquals(expected2, bst2.listNodeValues);
		System.out.println(bst2.findDiameter(bst2.root));
		assertTrue(bst2.findDiameter(bst2.root) == 3);
		
		// case 3				
		BinarySearchTree bst3 = new BinarySearchTree();
		bst3.insert(12);bst3.insert(4);bst3.insert(2);bst3.insert(8);bst3.insert(6);bst3.insert(10);
		bst3.insert(14);bst3.insert(16);bst3.insert(24);bst3.insert(20);bst3.insert(18);bst3.insert(22);bst3.insert(26);
		
		BTreePrinter.printNode(bst3.root);
		
		bst3.listNodeValues.clear();
		bst3.preOrder(bst3.root);
		
		List<Integer> expected3 = new ArrayList<Integer>();
		expected3.add(12);expected3.add(4);expected3.add(2);expected3.add(8);expected3.add(6);expected3.add(10);
		expected3.add(14);expected3.add(16);expected3.add(24);expected3.add(20);expected3.add(18);expected3.add(22);expected3.add(26);
		
		assertEquals(expected3, bst3.listNodeValues);
		
		System.out.println(bst3.findDiameter(bst3.root));
		assertTrue(bst3.findDiameter(bst3.root) == 9);
		
		
		// case 4
		BinarySearchTree bst4 = new BinarySearchTree();
		bst4.insert(26);bst4.insert(14);bst4.insert(4);bst4.insert(2);bst4.insert(12);bst4.insert(8);bst4.insert(6);bst4.insert(10);
		bst4.insert(16);bst4.insert(20);bst4.insert(18);bst4.insert(22);bst4.insert(24);
		bst4.insert(28);bst4.insert(30);
		
		BTreePrinter.printNode(bst4.root);
		
		bst4.listNodeValues.clear();
		bst4.preOrder(bst4.root);
		
		List<Integer> expected4 = new ArrayList<Integer>();
		expected4.add(26);expected4.add(14);expected4.add(4);expected4.add(2);expected4.add(12);expected4.add(8);expected4.add(6);expected4.add(10);
		expected4.add(16);expected4.add(20);expected4.add(18);expected4.add(22);expected4.add(24);expected4.add(28);expected4.add(30);
		
		assertEquals(expected4, bst4.listNodeValues);
		
		System.out.println(bst4.findDiameter(bst4.root));
		assertTrue(bst4.findDiameter(bst4.root) == 9);
		
		
		// case 5
		BinarySearchTree bst5 = new BinarySearchTree();
		bst5.insert(50);bst5.insert(40);bst5.insert(30);bst5.insert(20);bst5.insert(10);
		
		BTreePrinter.printNode(bst5.root);
		
		bst5.listNodeValues.clear();
		bst5.preOrder(bst5.root);
		
		List<Integer> expected5 = new ArrayList<Integer>();
		expected5.add(50);expected5.add(40);expected5.add(30);expected5.add(20);expected5.add(10);
		
		assertEquals(expected5, bst5.listNodeValues);
		
		System.out.println(bst5.findDiameter(bst5.root));
		assertTrue(bst5.findDiameter(bst5.root) == 5);
	}
	
	
	@Test
	public void testInorderMorris() {
		
		// case 1
		BinarySearchTree bst1 = new BinarySearchTree();
		bst1.insert(12);
		BTreePrinter.printNode(bst1.root);
		
		bst1.listNodeValues.clear();
		bst1.inOrderMorris(bst1.root);
		
		List<Integer> expected1 = new ArrayList<Integer>();
		expected1.add(12);
		
		assertEquals(expected1, bst1.listNodeValues);
		
		
		// case 2
		BinarySearchTree bst2 = new BinarySearchTree();
		bst2.insert(12);bst2.insert(4);bst2.insert(14);
		BTreePrinter.printNode(bst2.root);
		
		bst2.listNodeValues.clear();
		bst2.inOrderMorris(bst2.root);
		
		List<Integer> expected2 = new ArrayList<Integer>();
		expected2.add(4);expected2.add(12);expected2.add(14);
		
		assertEquals(expected2, bst2.listNodeValues);
		
		// case 3				
		BinarySearchTree bst3 = new BinarySearchTree();
		bst3.insert(12);bst3.insert(4);bst3.insert(2);bst3.insert(8);bst3.insert(6);bst3.insert(10);
		bst3.insert(14);bst3.insert(16);bst3.insert(24);bst3.insert(20);bst3.insert(18);bst3.insert(22);bst3.insert(26);
		
		BTreePrinter.printNode(bst3.root);
		
		bst3.listNodeValues.clear();
		bst3.inOrderMorris(bst3.root);
		
		List<Integer> expected3 = new ArrayList<Integer>();
		expected3.add(2);expected3.add(4);expected3.add(6);expected3.add(8);expected3.add(10);expected3.add(12);
		expected3.add(14);expected3.add(16);expected3.add(18);expected3.add(20);expected3.add(22);expected3.add(24);expected3.add(26);
		
		assertEquals(expected3, bst3.listNodeValues);
		
		
		
		// case 4
		/*BinarySearchTree bst4 = new BinarySearchTree();
		bst4.insert(26);bst4.insert(14);bst4.insert(4);bst4.insert(2);bst4.insert(12);bst4.insert(8);bst4.insert(6);bst4.insert(10);
		bst4.insert(16);bst4.insert(20);bst4.insert(18);bst4.insert(22);bst4.insert(24);
		bst4.insert(28);bst4.insert(30);
		
		BTreePrinter.printNode(bst4.root);
		
		bst4.listNodeValues.clear();
		bst4.preOrder(bst4.root);
		
		List<Integer> expected4 = new ArrayList<Integer>();
		expected4.add(26);expected4.add(14);expected4.add(4);expected4.add(2);expected4.add(12);expected4.add(8);expected4.add(6);expected4.add(10);
		expected4.add(16);expected4.add(20);expected4.add(18);expected4.add(22);expected4.add(24);expected4.add(28);expected4.add(30);
		
		assertEquals(expected4, bst4.listNodeValues);
		
		System.out.println(bst4.findDiameter(bst4.root));
		assertTrue(bst4.findDiameter(bst4.root) == 9);
		
		
		// case 5
		BinarySearchTree bst5 = new BinarySearchTree();
		bst5.insert(50);bst5.insert(40);bst5.insert(30);bst5.insert(20);bst5.insert(10);
		
		BTreePrinter.printNode(bst5.root);
		
		bst5.listNodeValues.clear();
		bst5.preOrder(bst5.root);
		
		List<Integer> expected5 = new ArrayList<Integer>();
		expected5.add(50);expected5.add(40);expected5.add(30);expected5.add(20);expected5.add(10);
		
		assertEquals(expected5, bst5.listNodeValues);
		
		System.out.println(bst5.findDiameter(bst5.root));
		assertTrue(bst5.findDiameter(bst5.root) == 5);*/
	}
	
	
	@Test
	public void testPrintConvexHull() {
		
		// case 1
		/*BinarySearchTree bst1 = new BinarySearchTree();
		bst1.insert(12);
		BTreePrinter.printNode(bst1.root);
		
		bst1.listNodeValues.clear();
		bst1.preOrder(bst1.root);
		
		List<Integer> expected1 = new ArrayList<Integer>();
		expected1.add(12);
		
		assertEquals(expected1, bst1.listNodeValues);
		bst1.printConvexHull(bst1.root);*/
		//System.out.println();
		//assertTrue(bst1.findDiameter(bst1.root) == 1);
		
		
		// case 2
		/*BinarySearchTree bst2 = new BinarySearchTree();
		bst2.insert(12);bst2.insert(4);bst2.insert(14);
		BTreePrinter.printNode(bst2.root);
		
		bst2.listNodeValues.clear();
		bst2.preOrder(bst2.root);
		
		List<Integer> expected2 = new ArrayList<Integer>();
		expected2.add(12);expected2.add(4);expected2.add(14);
		
		assertEquals(expected2, bst2.listNodeValues);
		System.out.println(bst2.findDiameter(bst2.root));
		assertTrue(bst2.findDiameter(bst2.root) == 3);*/
		
		// case 3				
		BinarySearchTree bst3 = new BinarySearchTree();
		bst3.insert(12);bst3.insert(4);bst3.insert(2);bst3.insert(8);bst3.insert(6);bst3.insert(10);
		bst3.insert(14);bst3.insert(16);bst3.insert(24);bst3.insert(20);bst3.insert(18);bst3.insert(22);bst3.insert(26);
		
		BTreePrinter.printNode(bst3.root);
		
		bst3.listNodeValues.clear();
		bst3.preOrder(bst3.root);
		
		List<Integer> expected3 = new ArrayList<Integer>();
		expected3.add(12);expected3.add(4);expected3.add(2);expected3.add(8);expected3.add(6);expected3.add(10);
		expected3.add(14);expected3.add(16);expected3.add(24);expected3.add(20);expected3.add(18);expected3.add(22);expected3.add(26);
		
		assertEquals(expected3, bst3.listNodeValues);
		
		//System.out.println(bst3.findDiameter(bst3.root));
		bst3.printConvexHull(bst3.root);
		//assertTrue(bst3.findDiameter(bst.root) == 9);
		
		
		// case 4
		/*BinarySearchTree bst4 = new BinarySearchTree();
		bst4.insert(26);bst4.insert(14);bst4.insert(4);bst4.insert(2);bst4.insert(12);bst4.insert(8);bst4.insert(6);bst4.insert(10);
		bst4.insert(16);bst4.insert(20);bst4.insert(18);bst4.insert(22);bst4.insert(24);
		bst4.insert(28);bst4.insert(30);
		
		BTreePrinter.printNode(bst4.root);
		
		bst4.listNodeValues.clear();
		bst4.preOrder(bst4.root);
		
		List<Integer> expected4 = new ArrayList<Integer>();
		expected4.add(26);expected4.add(14);expected4.add(4);expected4.add(2);expected4.add(12);expected4.add(8);expected4.add(6);expected4.add(10);
		expected4.add(16);expected4.add(20);expected4.add(18);expected4.add(22);expected4.add(24);expected4.add(28);expected4.add(30);
		
		assertEquals(expected4, bst4.listNodeValues);
		
		System.out.println(bst4.findDiameter(bst4.root));
		assertTrue(bst4.findDiameter(bst4.root) == 9);
		
		
		// case 5
		BinarySearchTree bst5 = new BinarySearchTree();
		bst5.insert(50);bst5.insert(40);bst5.insert(30);bst5.insert(20);bst5.insert(10);
		
		BTreePrinter.printNode(bst5.root);
		
		bst5.listNodeValues.clear();
		bst5.preOrder(bst5.root);
		
		List<Integer> expected5 = new ArrayList<Integer>();
		expected5.add(50);expected5.add(40);expected5.add(30);expected5.add(20);expected5.add(10);
		
		assertEquals(expected5, bst5.listNodeValues);
		
		System.out.println(bst5.findDiameter(bst5.root));
		assertTrue(bst5.findDiameter(bst5.root) == 5);*/
	}
}

