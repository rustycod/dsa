package org.sample.practice.tree;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import static org.junit.Assert.*;

public class BinaryTreeTest {
	
	@Test
	public void testTravesal() {
		BinaryTree bt = new BinaryTree();
		bt.insert(24);bt.insert(9);bt.insert(69);bt.insert(68);bt.insert(7);
		bt.insert(50);bt.insert(14);bt.insert(66);bt.insert(71);bt.insert(45);
		
		BTreePrinter.printNode(bt.root);
		
		// preOrder
		bt.listNodeValues.clear();
		bt.preOrder(bt.root);
		
		List<Integer> expectedPreOrder = new ArrayList<Integer>();
		expectedPreOrder.add(24);expectedPreOrder.add(9);expectedPreOrder.add(68);expectedPreOrder.add(66);expectedPreOrder.add(71);
		expectedPreOrder.add(7);expectedPreOrder.add(45);expectedPreOrder.add(69);expectedPreOrder.add(50);expectedPreOrder.add(14);
		
		assertEquals(expectedPreOrder, bt.listNodeValues);
		
		// inOrder
		bt.listNodeValues.clear();
		bt.inOrder(bt.root);
		
		List<Integer> expectedInOrder = new ArrayList<Integer>();
		expectedInOrder.add(66);expectedInOrder.add(68);expectedInOrder.add(71);expectedInOrder.add(9);expectedInOrder.add(45);
		expectedInOrder.add(7);expectedInOrder.add(24);expectedInOrder.add(50);expectedInOrder.add(69);expectedInOrder.add(14);
		
		assertEquals(expectedInOrder, bt.listNodeValues);
	}

	
	@Test
	public void testLca() {
		BinaryTree bt = new BinaryTree();
		bt.insert(24);bt.insert(9);bt.insert(69);bt.insert(68);bt.insert(7);
		bt.insert(50);bt.insert(14);bt.insert(66);bt.insert(71);bt.insert(45);
		
		BTreePrinter.printNode(bt.root);
		
		// preOrder
		bt.listNodeValues.clear();
		bt.preOrder(bt.root);
		
		List<Integer> expectedPreOrder = new ArrayList<Integer>();
		expectedPreOrder.add(24);expectedPreOrder.add(9);expectedPreOrder.add(68);expectedPreOrder.add(66);expectedPreOrder.add(71);
		expectedPreOrder.add(7);expectedPreOrder.add(45);expectedPreOrder.add(69);expectedPreOrder.add(50);expectedPreOrder.add(14);
		
		assertEquals(expectedPreOrder, bt.listNodeValues);
		
		// inOrder
		bt.listNodeValues.clear();
		bt.inOrder(bt.root);
		
		List<Integer> expectedInOrder = new ArrayList<Integer>();
		expectedInOrder.add(66);expectedInOrder.add(68);expectedInOrder.add(71);expectedInOrder.add(9);expectedInOrder.add(45);
		expectedInOrder.add(7);expectedInOrder.add(24);expectedInOrder.add(50);expectedInOrder.add(69);expectedInOrder.add(14);
		
		assertEquals(expectedInOrder, bt.listNodeValues);
		
		// lca check
		assertTrue(bt.lca(bt.root, 66, 71) == 68);
		assertTrue(bt.lca(bt.root, 45, 69) == 24);
		assertTrue(bt.lca(bt.root, 9, 66) == 9);
		assertTrue(bt.lca(bt.root, 14, 69) == 69);
		
	}
	
	
	@Test
	public void testBuildTree() {
		BinaryTree bt = new BinaryTree();
		bt.insert(24);bt.insert(9);bt.insert(69);bt.insert(68);bt.insert(7);
		bt.insert(50);bt.insert(14);bt.insert(66);bt.insert(71);bt.insert(45);
		
		BTreePrinter.printNode(bt.root);
		
		// preOrder
		bt.listNodeValues.clear();
		bt.preOrder(bt.root);
		
		List<Integer> expectedPreOrder = new ArrayList<Integer>();
		expectedPreOrder.add(24);expectedPreOrder.add(9);expectedPreOrder.add(68);expectedPreOrder.add(66);expectedPreOrder.add(71);
		expectedPreOrder.add(7);expectedPreOrder.add(45);expectedPreOrder.add(69);expectedPreOrder.add(50);expectedPreOrder.add(14);
		
		assertEquals(expectedPreOrder, bt.listNodeValues);
		
		// inOrder
		bt.listNodeValues.clear();
		bt.inOrder(bt.root);
		
		List<Integer> expectedInOrder = new ArrayList<Integer>();
		expectedInOrder.add(66);expectedInOrder.add(68);expectedInOrder.add(71);expectedInOrder.add(9);expectedInOrder.add(45);
		expectedInOrder.add(7);expectedInOrder.add(24);expectedInOrder.add(50);expectedInOrder.add(69);expectedInOrder.add(14);
		
		assertEquals(expectedInOrder, bt.listNodeValues);
		
		
		int[] inOrder = new int[]{66, 68, 71, 9, 45, 7, 24, 50, 69, 14}; // inOrder
		int[] preOrder = new int[]{24, 9, 68, 66, 71, 7, 45, 69, 50, 14}; // preOrder
		
		
		Node newRoot = bt.buildTree(inOrder, preOrder, 0, 9, 0);
		//BinaryTree newTree = new BinaryTree();
		//newTree.root = newRoot;
		System.out.println("New Tree: ");
		BTreePrinter.printNode(newRoot);
	}
	
	
	@Test
	public void testBuildTreeSpecific() {
		
		int[] preOrder = new int[]{1, 0, 1, 0, 0};
		
		BinaryTree bt = new BinaryTree();
		bt.root = bt.buildTreeSpecific(preOrder, 0);
		
		BTreePrinter.printNode(bt.root);
		
	}
}
