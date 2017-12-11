package org.sample.practice.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree {

	Node root;
	
	// insert a new node
	public Node insert(int value) {
		
		Node newNode = null;
		
		if(root == null) {
			newNode = new Node(value);
			root = newNode;
			return newNode ;
		}
		
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			
			Node currentNode = queue.poll();
			
			if(currentNode.left == null) {
				newNode = new Node(value);
				currentNode.left = newNode;
				return newNode;
			} else {
				queue.add(currentNode.left);
			}
			
			if(currentNode.right == null) {
				newNode = new Node(value);
				currentNode.right = newNode;
				return newNode;
			} else {
				queue.add(currentNode.right);
			}
		}
		
		return newNode;
	}
	
	
	// calling code is responsible to check whether root is null
	// recursive approach
	public int findMax(Node root) {
		
		int leftNodeValue = Integer.MIN_VALUE;
		int rightNodeValue = Integer.MIN_VALUE;

		if(root.left != null) {
			leftNodeValue = findMax(root.left);
		}
		
		if(root.right != null) {
			rightNodeValue = findMax(root.right);
		}
		
		int currentNodeValue = root.val;
		
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
	public int findMax2(Node root) {
	    if (root.left == null && root.right == null)
	        return root.val;
	    else {
	        int maxValue = root.val;
	        if (root.left != null)
	            maxValue=Math.max(maxValue,findMax2(root.left));
	        if (root.right != null)
	            maxValue = Math.max(maxValue,findMax2(root.right));
	        return maxValue;
	    }
	}
	
	// calling code is responsible to check whether root is null
	// iterative approach
	public int findMaxIteratively(Node root) {
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(root.val);
		int max = Integer.MIN_VALUE;
		
		while(!queue.isEmpty()) {
			
			int currentValue = queue.peek();
			
			if(currentValue > max) {
				max = currentValue;
			}
	  
			if(root.left != null) {
				queue.add(root.left.val);
			}
			
			if(root.right != null) {
				queue.add(root.right.val);
			}
		}
		
		return max;
	}
	
	// calling code is responsible to check whether root is null
	// serach an element
	// recursive approach
	/*public Node search(Node root, int value) {

		if(root.val == value) return root;

		Node node = null;
		if(root.left != null) {
			node = search(root.left, value);
		}

		if(root.right != null) {
			node = search(root.right, value);
		}	
		
		return node;
	}*/
	
	public boolean search(Node root, int value) {

		if(root == null) return false;
		
		if(root.val == value) return true;

		return search(root.left, value) || search(root.right, value); // '||' is a short-circuit operator

	}
	
	// calling code is responsible to check whether root is null
	// serach an element
	// iterative approach
	public Node searchIteratively(Node root, int value) {

		// optimized case
		if(root.val == value) return root;
		
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		
		Node node = null;
		
		while(!queue.isEmpty()) {

			Node currentNode = queue.poll();
			if(currentNode.val == value) {
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
	
	
	// traversals methods
	
	// list to hold values of tree for testing purpose
	// this list must be reassigned in order to remove earlier values
	List<Integer> listNodeValues = new ArrayList<Integer>();
	
	public void inOrder(Node root) {
		if(root != null) {
			inOrder(root.left);
			// visiting root node
			listNodeValues.add(root.val);
			inOrder(root.right);
		}
	}
	
	public void preOrder(Node root) {
		if(root != null) {
			// visiting root node
			listNodeValues.add(root.val);
			preOrder(root.left);
			preOrder(root.right);
		}
	}
	
	public void postOrder(Node root) {
		if(root != null) {
			postOrder(root.left);
			postOrder(root.right);
			// visiting root node
			listNodeValues.add(root.val);
		}
	}
	
	
	// lca
	// assumption is that both the nodes are present in the tree
	public int lca(Node root, int val1, int val2) {
		
		if(root == null) return -1;
		
		if(root.val == val1 || root.val == val2) return root.val;
		
		int leftValue = lca(root.left, val1, val2);
		int rightValue = lca(root.right, val1, val2);
		
		if(leftValue != -1 && rightValue != -1) {
			return root.val;
		} else if(leftValue != -1 && rightValue == -1) {
			return leftValue;
		} else if(leftValue == -1 && rightValue != -1) {
			return rightValue;
		} else {
			return -1;
		}
	}
	
	
	// build binary tree using inorder and preorder traversal
	public Node buildTree(int[] inorder, int[] preorder, int indexInOrderStart, int indexInOrderEnd, int indexPreOrder) {
		
		if(indexInOrderStart > indexInOrderEnd) return null;
		
		System.out.println("indexPreOrder: "+indexPreOrder);
		int rootValue = preorder[indexPreOrder];
		System.out.println("rootValue: "+rootValue);
		Node root = new Node(rootValue);
		
		int indexInOrderCurrent = getIndex(inorder, rootValue);
		
		/*Node leftNode = buildTree(inorder, preorder, indexInOrderStart, indexInOrderCurrent - 1, indexPreOrder);
		if(leftNode != null) {
			root.left = leftNode;
		}
		
		Node rightNode = buildTree(inorder, preorder, indexInOrderCurrent + 1, indexInOrderEnd, indexPreOrder);
		if(rightNode != null) {
			root.right = rightNode;
		}*/
		
		indexPreOrder++;
		root.left = buildTree(inorder, preorder, indexInOrderStart, indexInOrderCurrent - 1, indexPreOrder);
		/*if(root.left == null) {
			indexPreOrder--;
		}*/
		
		if(root.left != null) {
			indexPreOrder++;
		}
		
		root.right = buildTree(inorder, preorder, indexInOrderCurrent + 1, indexInOrderEnd, indexPreOrder);
		/*if(root.right == null) {
			indexPreOrder--;
		}*/
		
		return root;
	}
	
	private int getIndex(int[] arr, int value) {
		int count = 0;
		for(int a : arr) {
			if(a == value) {
				return count;
			}
			count++;
		}
		return -1;
	}
	
	
	// build tree specific ILILL / 10100
	public Node buildTreeSpecific(int[] arr, int index) {
		
		if(index >= arr.length) return null;
		
		int value = arr[index];
		Node root = new Node(value);
		
		if(value == 0) { // leaf node
			return root;
		} else { // internal node
			root.left = buildTreeSpecific(arr, index + 1);
			root.right = buildTreeSpecific(arr, index + 2);
			return root;
		}
	}
	
	
}

