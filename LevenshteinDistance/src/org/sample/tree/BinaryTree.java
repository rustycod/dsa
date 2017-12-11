package org.sample.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class BinaryTree {

	// calling code is responsible to check whether root is null
	// recursive approach
	public int findMax(Node<Integer> root) {
		
		int leftNodeValue = Integer.MIN_VALUE;
		int rightNodeValue = Integer.MIN_VALUE;

		if(root.left != null) {
			leftNodeValue = findMax(root.left);
		}
		
		if(root.right != null) {
			rightNodeValue = findMax(root.right);
		}
		
		int currentNodeValue = root.data;
		
		// find max of root, left sub-tree and right sub-tree
		return findMaxOfThree(currentNodeValue, leftNodeValue, rightNodeValue);
	}
	
	// helper method to find max of three values
	int findMaxOfThree(int value1, int value2, int value3) {
		
		int max = Integer.MIN_VALUE;
		
		if(value1 > value2) {
			max = value1;
		} else {
			max = value2;
		}
		
		if(value3 > max) {
			max = value3;
		}
		
		return max;		
	}
	
	// findMax: second way to write the code and bit more elegant
	// calling code is responsible to check whether root is null
	// recursive approach
	public int findMax2(Node<Integer> root) {
	    if (root.left == null && root.right == null)
	        return root.data;
	    else {
	        int maxValue = root.data;
	        if (root.left != null)
	            maxValue=Math.max(maxValue,findMax2(root.left));
	        if (root.right != null)
	            maxValue = Math.max(maxValue,findMax2(root.right));
	        return maxValue;
	    }
	}
	
	// calling code is responsible to check whether root is null
	// iterative approach
	public int findMaxIteratively(Node<Integer> root) {
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(root.data);
		int max = Integer.MIN_VALUE;
		
		while(!queue.isEmpty()) {
			
			int currentValue = queue.peek();
			
			if(currentValue > max) {
				max = currentValue;
			}
	  
			if(root.left != null) {
				queue.add(root.left.data);
			}
			
			if(root.right != null) {
				queue.add(root.right.data);
			}
		}
		
		return max;
	}
	
	// calling code is responsible to check whether root is null
	// serach an element
	// recursive approach
	public Node<Integer> search(Node<Integer> root, int value) {

		if(root.data == value) return root;

		Node<Integer> node = null;
		if(root.left != null) {
			node = search(root.left, value);
		}

		if(root.right != null) {
			node = search(root.right, value);
		}	
		
		return node;
	}
	
	
	// calling code is responsible to check whether root is null
	// serach an element
	// iterative approach
	public Node<Integer> searchIteratively(Node<Integer> root, int value) {

		// optimized case
		if(root.data == value) return root;
		
		Queue<Node<Integer>> queue = new LinkedList<Node<Integer>>();
		queue.add(root);
		
		Node<Integer> node = null;
		
		while(!queue.isEmpty()) {

			Node<Integer> currentNode = queue.poll();
			if(currentNode.data == value) {
				return currentNode;
			}
			
			if(currentNode.left != null) {
				queue.add(currentNode.left);
			}
			
			if(currentNode.right != null) {
				queue.add(currentNode.right);
			}
		}

		return node;
	}
	
	
	// insert a new node
	public Node<Integer> insert(Node<Integer> root, int value) {
		
		Node<Integer> newNode = null;
		
		if(root == null) {
			newNode = new Node<Integer>(value);
			root = newNode;
			return newNode ;
		}
		
		Queue<Node<Integer>> queue = new LinkedList<Node<Integer>>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			
			Node<Integer> currentNode = queue.poll();
			
			if(currentNode.left == null) {
				newNode = new Node<Integer>(value);
				currentNode.left = newNode;
				return newNode;
			} else {
				queue.add(currentNode.left);
			}
			
			if(currentNode.right == null) {
				newNode = new Node<Integer>(value);
				currentNode.right = newNode;
				return newNode;
			} else {
				queue.add(currentNode.right);
			}
		}
		
		return newNode;
	}
	
	
	// traversals methods
	
	// list to hold values of tree for testing purpose
	// this list must be reassigned in order to remove earlier values
	List<Integer> listNodeValues = new ArrayList<Integer>();
	
	public void inOrder(Node<Integer> root) {
		if(root != null) {
			inOrder(root.left);
			// visiting root node
			listNodeValues.add(root.data);
			inOrder(root.right);
		}
	}
	
	public void preOrder(Node<Integer> root) {
		if(root != null) {
			// visiting root node
			listNodeValues.add(root.data);
			preOrder(root.left);
			preOrder(root.right);
		}
	}
	
	public void postOrder(Node<Integer> root) {
		if(root != null) {
			postOrder(root.left);
			postOrder(root.right);
			// visiting root node
			listNodeValues.add(root.data);
		}
	}
	
}
