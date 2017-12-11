package org.sample.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;

import sun.awt.VerticalBagLayout;

public class BinarySearchTree {
	public Node<Integer> root;
	public BinarySearchTree(){
		root = null;
	}
	
	// meta: BST5
	public boolean find(int id){
		Node<Integer> current = root;
		while(current!=null){
			if(current.data==id){
				return true;
			}else if(current.data>id){
				current = current.left;
			}else{
				current = current.right;
			}
		}
		return false;
	}
	public boolean delete(int id){
		Node<Integer> parent = root;
		Node<Integer> current = root;
		boolean isLeftChild = false;
		while(current.data!=id){
			parent = current;
			if(current.data>id){
				isLeftChild = true;
				current = current.left;
			}else{
				isLeftChild = false;
				current = current.right;
			}
			if(current ==null){
				return false;
			}
		}
		//if i am here that means we have found the node
		//Case 1: if node to be deleted has no children
		if(current.left==null && current.right==null){
			if(current==root){
				root = null;
			}
			if(isLeftChild ==true){
				parent.left = null;
			}else{
				parent.right = null;
			}
		}
		//Case 2 : if node to be deleted has only one child
		else if(current.right==null){
			if(current==root){
				root = current.left;
			}else if(isLeftChild){
				parent.left = current.left;
			}else{
				parent.right = current.left;
			}
		}
		else if(current.left==null){
			if(current==root){
				root = current.right;
			}else if(isLeftChild){
				parent.left = current.right;
			}else{
				parent.right = current.right;
			}
		}else if(current.left!=null && current.right!=null){
			
			//now we have found the minimum element in the right sub tree
			Node<Integer> successor = getSuccessor(current);
			if(current==root){
				root = successor;
			}else if(isLeftChild){
				parent.left = successor;
			}else{
				parent.right = successor;
			}			
			successor.left = current.left;
		}		
		return true;		
	}
	
	public Node<Integer> getSuccessor(Node<Integer> deleleNode){
		Node<Integer> successsor =null;
		Node<Integer> successsorParent =null;
		Node<Integer> current = deleleNode.right;
		while(current!=null){
			successsorParent = successsor;
			successsor = current;
			current = current.left;
		}
		//check if successor has the right child, it cannot have left child for sure
		// if it does have the right child, add it to the left of successorParent.
//		successsorParent
		if(successsor!=deleleNode.right){
			successsorParent.left = successsor.right;
			successsor.right = deleleNode.right;
		}
		return successsor;
	}
	public void insert(int id){
		Node<Integer> newNode = new Node<Integer>(id);
		if(root==null){
			root = newNode;
			return;
		}
		Node<Integer> current = root;
		Node<Integer> parent = null;
		while(true){
			parent = current;
			if(id<current.data){				
				current = current.left;
				if(current==null){
					parent.left = newNode;
					return;
				}
			}else{
				current = current.right;
				if(current==null){
					parent.right = newNode;
					return;
				}
			}
		}
	}
	
	public void displayInOrder(Node<Integer> root){
		if(root!=null){
			displayInOrder(root.left);
			System.out.print(" " + root.data);
			displayInOrder(root.right);
		}
	}
	
	public void displayPreOrder(Node<Integer> root){
		if(root!=null){
			System.out.print(" " + root.data);
			displayInOrder(root.left);
			displayInOrder(root.right);
		}
	}
	
	public void displayPostOrder(Node<Integer> root){
		if(root!=null){
			displayInOrder(root.left);
			displayInOrder(root.right);
			System.out.print(" " + root.data);
		}
	}
	
	// mirror image
	// meta: BT41
	/*public void mirror(Node<Integer> root){
		if(root!=null){
			mirror(root.left);
			mirror(root.right);
			
			// swap
			Node<Integer> tempNode = root.left;
			root.left = root.right;
			root.right = tempNode;
		}
	}*/

	// meta: BT23
	public void getLeafNodes(Node<Integer> root){
		if(root!=null){
			if(root.left == null && root.right == null) {
				System.out.print(" " + root.data);
			}
			getLeafNodes(root.left);
			getLeafNodes(root.right);
		}
	}
	
	/*public int countNodes(Node<Integer> root){
		if(root == null) return 0;
		
		return countNodes(root.left) + 1 + countNodes(root.right);
	}*/
	
	/*public int countNodesIteratively(Node<Integer> root){
		
		if(root == null) return 0;
		
		Queue<Node<Integer>> queue = new LinkedList<Node<Integer>>();
		queue.add(root);
		int count = 0;
		
		while(!queue.isEmpty()){
			
			Node<Integer> currentNode = queue.poll();
			count++;
			
			if(currentNode.left != null) {
				queue.add(currentNode.left);
			}
			
			if(currentNode.right != null) {
				queue.add(currentNode.right);
			}
		}
		
		return count;
	}*/
	
	// meta: Q43
	/*public int countLevels(Node<Integer> root){
		if(root == null) return 0;
		
		int leftLevel = countLevels(root.left);
		int rightLevel = countLevels(root.right);
		
		if(leftLevel > rightLevel) {
			return leftLevel + 1;
		} else {
			return rightLevel + 1;
		}
	}
	
	// meta: Q44
	public int countLevelsIteratively(Node<Integer> root){
		if(root == null) return 0;
		
		Queue<Node<Integer>> queue = new LinkedList<Node<Integer>>();
		queue.add(root);
		queue.add(null); // null will act as a delimiter for levels
		
		int levelCount = 0;
		
		while(!queue.isEmpty()) {
			
			Node<Integer> currentNode = queue.poll();
			
			if(currentNode == null) {
				// delimiter encountered
				levelCount++;
				
				if(!queue.isEmpty()) {
					// add delimiter
					queue.add(null);
				}
				continue;
			}
			
			if(currentNode.left != null) {
				queue.add(currentNode.left);
			}
			
			if(currentNode.right != null) {
				queue.add(currentNode.right);
			}
			

		}
		
		return levelCount;
	}*/

	
	// meta: BT20
	/*public List<Node<Integer>> findDeepestNodesIteratively(Node<Integer> root){
		
		if(root == null) new LinkedList<Node<Integer>>();
		
		Queue<Node<Integer>> queue = new LinkedList<Node<Integer>>();
		queue.add(root);
		queue.add(null); // level identifier
		
		List<Node<Integer>> deepNodes = new LinkedList<Node<Integer>>();
		List<Node<Integer>> nodesAtALevel = new LinkedList<Node<Integer>>();
		
		int height = 0; // just for debugging purpose
		
		while(!queue.isEmpty()){
			
			Node<Integer> currentNode = queue.poll();
			
			if(currentNode != null) {
				nodesAtALevel.add(currentNode);
			}
			
			if(currentNode == null) {
				deepNodes = nodesAtALevel;
				nodesAtALevel = new LinkedList<Node<Integer>>();
				
				if(!queue.isEmpty()) {
					queue.add(null);
				}
		
				height++; // just for debugging purpose
				continue;
			}
			
			if(currentNode.left != null) {
				queue.add(currentNode.left);
			}
			
			if(currentNode.right != null) {
				queue.add(currentNode.right);
			}
		}
		
		return deepNodes;
		
	}*/
	
	/* Print nodes at the given level */
    /*public void printGivenLevel (Node<Integer> root ,int level)
    {
        if (root == null) {
        	return;
        }
        if (level == 1) {
        	System.out.print(root.data + " ");
        } else if (level > 1) {
            printGivenLevel(root.left, level-1);
            printGivenLevel(root.right, level-1);
        }
    }*/
	
	public void printLevelOrder() {
        Queue<Node<Integer>> queue = new LinkedList<Node<Integer>>();
        
        if(root == null) {
        	return;
        }
        
        queue.add(root);
        while (!queue.isEmpty()) {
            // poll() removes the present head.
            Node<Integer> tempNode = queue.poll();
            System.out.print(tempNode.data + " ");
 
            /*Enqueue left child */
            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }
 
            /*Enqueue right child */
            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
    }

	/*public void printLevelOrderReverse() {
        Queue<Node<Integer>> queue = new LinkedList<Node<Integer>>();
        Stack<Integer> stack = new Stack<Integer>();
        
        if(root == null) {
        	return;
        }
        
        queue.add(root);
        while (!queue.isEmpty()) {
            // poll() removes the present head.
            Node<Integer> tempNode = queue.poll();
 
            Enqueue right child 
            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }

            Enqueue left child 
            if (tempNode.left != null) { 
                queue.add(tempNode.left);
            }
            
            stack.push(tempNode.data);
        }
        
        while(!stack.isEmpty()) {
        	System.out.print(" " + stack.pop());
        }
        
    }*/
	
	// TODO get deepest nodes
	
	
	public boolean tracePath(Node<Integer> root, int value, List<Integer> resultList) {
		if(root == null) return false;
		
		if(root.data == value) {
			resultList.add(value);
			return true;
		} 
		
		if(tracePath(root.left, value, resultList) == true || tracePath(root.right, value, resultList) == true) {
				resultList.add(root.data);
				return true;
		}
		
		return false;
	}
	
	
	// least common ancestor
	// meta: BT51
	// it assumes that both the nodes are present in binary tree
	public Node<Integer> lca(Node<Integer> root, Node<Integer> node1, Node<Integer> node2) {

		if(root == null) return null;
		
		if(root.data == node1.data || root.data == node2.data) {
			return root;
		}
		
		Node<Integer> left = lca(root.left, node1, node2);
		Node<Integer> right = lca(root.right, node1, node2);
		
		if(left == null && right == null) {
			return null;
		}
		
		if(left != null && right != null) {
			return root;
		}
		
		return left != null ? left : right;

	}
	
	// find max in BST: calling code is responsible for checking whether root is null
	//meta: BST1
	public int findMax(Node<Integer> root) {
		if(root.right == null) {
			return root.data;
		} else {
			return findMax(root.right);
		}
	}
	
	
	// find max in BST: calling code is responsible for checking whether root is null
	// iterative approach
	//meta: BST2
	public int findMaxIteratively(Node<Integer> root) {
		
		int max = root.data;
		
		while(root.right != null) {
			if(root.right.data > max) {
				max = root.right.data;
			}
			
			root = root.right;
		}

		return max;
	}
	
	// find min in BST: calling code is responsible for checking whether root is null
	public int findMin(Node<Integer> root) {
		if(root.left == null) {
			return root.data;
		} else {
			return findMin(root.left);
		}
	}
	
	// find min in BST: calling code is responsible for checking whether root is null
	// find min iteratively
	public int findMinIteratively(Node<Integer> root) {
		
		int min = root.data;
		
		while(root.left != null) {
			
			if(root.left.data < min) {
				min = root.left.data;
			}
			
			root = root.left;
		}
		
		return min;

	}
	
	// find list of leaf nodes iteravely
	// meta: BT23
/*	public List<Node<Integer>> findLeafNodesIteratively(Node<Integer> root) {
		
		List<Node<Integer>> leafNodes = new LinkedList<Node<Integer>>(); 
		
		if(root == null) return leafNodes;
		
		Queue<Node<Integer>> queue = new LinkedList<Node<Integer>>();
		queue.add(root);
		
		
		while(!queue.isEmpty()) {
			
			Node<Integer> currentNode = queue.poll();
			
			if(currentNode.left == null && currentNode.right == null) {
				leafNodes.add(currentNode);
				continue;
			}
			
			if(currentNode.left != null) {
				queue.add(currentNode.left);
			}
			
			if(currentNode.right != null) {
				queue.add(currentNode.right);
			}
		}
		
		return leafNodes;
	}
	
	// find all the full nodes iteratively
	// meta: BT26
	public List<Node<Integer>> findFullNodesIteratively(Node<Integer> root) {
		
		List<Node<Integer>> fullNodes = new LinkedList<Node<Integer>>();
		
		if(root == null) return fullNodes;
		
		Queue<Node<Integer>> queue = new LinkedList<Node<Integer>>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			
			Node<Integer> currentNode = queue.poll();
			
			if(currentNode.left != null && currentNode.right != null) {
				fullNodes.add(currentNode);
			}
			
			if(currentNode.left != null) {
				queue.add(currentNode.left);
			}
			
			if(currentNode.right != null) {
				queue.add(currentNode.right);
			}
		}
		
		return fullNodes;
	}
	
	// find all the half nodes iteratively
	// meta: BT28
	public List<Node<Integer>> findHalfNodesIteratively(Node<Integer> root) {
		
		List<Node<Integer>> halfNodes = new LinkedList<Node<Integer>>();
		
		if(root == null) return halfNodes;
		
		Queue<Node<Integer>> queue = new LinkedList<Node<Integer>>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			
			Node<Integer> currentNode = queue.poll();
			
			if((currentNode.left != null && currentNode.right == null) 
					|| (currentNode.left == null && currentNode.right != null)) {
				halfNodes.add(currentNode);
			}
			
			if(currentNode.left != null) {
				queue.add(currentNode.left);
			}
			
			if(currentNode.right != null) {
				queue.add(currentNode.right);
			}
		}
		
		return halfNodes;
	}*/
	
	// find whether two trees are structurally same
	// meta: BT29
	/*public boolean areStructurallySame(Node<Integer> root1, Node<Integer> root2) {
		
		if(root1 == null && root2 == null) {
			return true;
		} 
		
		if(root1 == null || root2 == null) {
			return false;
		}
		
		//return areStructurallySame(root1.left, root2.left) && areStructurallySame(root1.right, root2.right);
		return root1.data == root2.data && areStructurallySame(root1.left, root2.left) && areStructurallySame(root1.right, root2.right); // if data is also to be compared
	}*/
	
	// find the level having maximum sum
	// meta: BT34
/*	public int findLevelHavingMaxSumIteratively(Node<Integer> root) {
		
		if(root == null) return -1; // -1 means no tree exist
		
		Queue<Node<Integer>> queue = new LinkedList<Node<Integer>>();
		queue.add(root);
		queue.add(null); // level delimiter
		
		int sum = 0;
		int maxSum = Integer.MIN_VALUE;
		int level = 0;
		int levelWithMaxSum = 0;
		
		while(!queue.isEmpty()){
			
			Node<Integer> currentNode = queue.poll();
			
			if(currentNode != null) {
				sum += currentNode.data;
			}
			
			if(currentNode == null) {
				
				level++;
				if(sum > maxSum) {
					levelWithMaxSum = level;
					maxSum = sum;
				}
					
				sum = 0;	
				
				if(!queue.isEmpty()) {
					queue.add(null);
				}
				
				continue;
			}
			
			if(currentNode.left != null) {
				queue.add(currentNode.left);
			}
			
			if(currentNode.right != null) {
				queue.add(currentNode.right);
			}
		}
		
		return levelWithMaxSum;
		
	}*/
	
	// print all root-to-leaf paths
	// meta: BT35
	// calling code will check whether root is null
	// check one more appraoch with int array in red book Q.20
	/*public void printRootToLeafPaths(Node<Integer> root, Deque<Integer> deque) {
		
		deque.add(root.data);
		
		if(root.left == null && root.right == null) {
			// time to print as leaf node is reached
			System.out.println(deque);
			return;
		}
		
		if(root.left != null) {
			printRootToLeafPaths(root.left, deque);
			deque.pollLast();
		}
		
		
		if(root.right != null) {
			printRootToLeafPaths(root.right, deque);
			deque.pollLast();
		}
	}*/
	
	// given a sum check whether there exists a path from root to any of the nodes
	// meta: BT37
	// calling code with check whether root is null
	// check second approach also
	public void checkSum(Node<Integer> root, Deque<Integer> deque, int givenSum) {
		
		deque.add(root.data);
		
		// check sum, if met print
		if(givenSum == getSum(deque)) {
			System.out.print("Sum found with nodes: "+deque);
			return;
		}
		
		
		if(root.left != null) {
			checkSum(root.left, deque, givenSum);
			deque.pollLast();
		}
		
		if(root.right != null) {
			checkSum(root.right, deque, givenSum);
			deque.pollLast();
		}
	}
	
	// given a sum check whether there exists a path from root to any of the nodes
	// meta: BT37
	// calling code with check whether root is null
	// second approach: it'll come out when it finds the first such case and will not return all the cases
	public boolean checkSumSecondApproach(Node<Integer> root, int givenSum) {

		if(root.data == givenSum) {
			// sum found
			System.out.println("Sum found!"+root.data);
			return true;
		}
		
		int remainingSum = givenSum - root.data;

		if(root.left == null && root.right == null) {
			return false; // no point in checking further as leaf node is reached
		} else if(root.left != null && root.right != null) {
			return checkSumSecondApproach(root.left, remainingSum) || checkSumSecondApproach(root.right, remainingSum);
		} else if(root.left != null) {
			return checkSumSecondApproach(root.left, remainingSum);
		} else {
			return checkSumSecondApproach(root.right, remainingSum);
		}
		
	}
	
	// helper method to calculate of sum of elements in queue
	private int getSum(Deque<Integer> deque) {
		int sum = 0;
		
		Integer[] array = deque.toArray(new Integer[0]);
		
		for(Integer val : array) {
			sum += val;
		}
		
		return sum;
	}
	
	
	// find sum of all the nodes
	// meta: BT39
	
	// find sum of all the nodes (iteratively)
	// meta: BT40
/*	public int getSumIteratively(Node<Integer> root) {

		if(root == null) return 0;
		
		Queue<Node<Integer>> queue = new LinkedList<Node<Integer>>();
		queue.add(root);
		
		int sum = 0;
		
		while(!queue.isEmpty()) {

			Node<Integer> currentNode = queue.poll();
			sum += currentNode.data;
			
			if(currentNode.left != null) {
				queue.add(currentNode.left);
			}
			
			if(currentNode.right != null) {
				queue.add(currentNode.right);
			}
		}
		
		return sum;
	}*/
	
	// check whether given trees are mirrors to each other
	// meta: BT43
	/*public boolean areMirrors(Node<Integer> root1, Node<Integer> root2) {

		if(root1 == null && root2 == null) {
			return true;
		} else if (root1 == null || root2 == null){
			return false;
		} if (root1.data != root2.data) {
			return false;
		} else {
			return areMirrors(root1.left, root2.right) && areMirrors(root1.right, root2.left); 
		}
	}*/
	
	// build tree for given inorder and preorder traversal
	// meta: BT45
	int preOrderIndex = 0;
	public Node<Integer> buildTree(int[] inOrder, int[] preOrder, int indexStart, int indexEnd) {

		if(indexStart > indexEnd) {
			return null;
		}

		int newValue = preOrder[preOrderIndex];
		Node<Integer> newNode = new Node<Integer>(newValue);
		
		// optimization: this is a leaf node
		/*if(indexStart == indexEnd) {
			return newNode;
		}*/
		
		int inOrderIndex = getIndex(inOrder, newValue);
		
		preOrderIndex++;
		Node<Integer> leftNode = buildTree(inOrder, preOrder, indexStart, inOrderIndex - 1);
		Node<Integer> rightNode = buildTree(inOrder, preOrder, inOrderIndex + 1, indexEnd);
		
		newNode.left = leftNode;
		newNode.right = rightNode;
		
		return newNode;
	}

	private int getIndex(int[] arr, int value) {
		
		for(int index = 0; index < arr.length; index++) {
			if(value == arr[index]) {
				return index;
			}
		}
		
		return -1; // it means value not found
	}
	
	// print all the ancesots of a given node
	// meta: BT49
	public Node<Integer> printAncestors(Node<Integer> root, int nodeValue) {
		
		if(root == null) return null;
		
		if(root.data == nodeValue) {
			System.out.println(root.data);
			return root;
		}
		
		
		if(printAncestors(root.left, nodeValue) != null || printAncestors(root.right, nodeValue) != null) {
			System.out.println(root.data);
			return root;
		} else {
			return null;
		}
	}
	
	// print all the ancesots of a given node
	// meta: BT49 // bit optimized version
	public int printAncestorsOptimized(Node<Integer> root, Node<Integer> node) {
		
		if(root == null) {
			return -1;
		}
		
		if(root.left == node || root.right == node || printAncestorsOptimized(root.left, node) != -1 || printAncestorsOptimized(root.right, node) != -1) {
			System.out.println(root.data);
		} else {
			return -1;
		}
		
		return -1;
	}
	
	
	// fill sibling iteratively
	// meta: BT61
/*	public void fillSiblingIteratively(Node<Integer> root) {
		
		if(root == null) return;
		
		Queue<Node<Integer>> queue = new LinkedList<Node<Integer>>();
		queue.add(root);
		queue.add(null); // level identifier
		
		while(!queue.isEmpty()) {
			
			Node<Integer> currentNode = queue.poll();
			
			if(currentNode == null) {
				if(!queue.isEmpty()) {
					queue.add(null);
				}
				continue;
			}
			
			currentNode.sibling = queue.peek(); // add the sibling
			
			if(currentNode.left != null) {
				queue.add(currentNode.left);
			}
			
			if(currentNode.right != null) {
				queue.add(currentNode.right);
			}
		}
		
	}
	
	// fill siblings
	// meta: BT61
	public void fillSibling(Node<Integer> root) {
		
		if(root == null) return;
		
		if(root.left != null) {
			root.left.sibling = root.right;
		}
		
		if(root.right != null) {
			root.right.sibling = root.sibling != null ? root.sibling.left : null;
		}
		
		fillSibling(root.left);
		fillSibling(root.right);
	}*/
	
	// build tree from specific preOrder traversal (ILILL)
	// meta: BT58
	public Node<Integer> buildTreeSpecific(char[] preOrder, int index) {
		
		Node<Integer> node;
		if(preOrder[index] == 'I') {
			node = new Node<Integer>(1); // 1 for I
			
			// as per condition it must have two child nodes
			node.left = buildTreeSpecific(preOrder, index + 1);
			node.right = buildTreeSpecific(preOrder, index + 2);
		} else {
			node = new Node<Integer>(2); // 2 for L
		}
		
		return node;
	}
	
	// find vertical sum of binary tree
	// for simlicity, we'll maintain list of nodes then their sum
	// meta: BT55
	public Map<Integer, List<Integer>> verticalMap = new TreeMap<Integer, List<Integer>>();
	public void findVerticalSum(Node<Integer> root, int column) {
		
		if(root == null) return;
		
		findVerticalSum(root.left, column - 1);
		
		if(verticalMap.get(column) == null) {
			List<Integer> list = new LinkedList<Integer>();
			list.add(root.data);
			verticalMap.put(column, list);
		} else {
			List<Integer> list = verticalMap.get(column);
			list.add(root.data);
			verticalMap.put(column, list);
		}
		
		
		findVerticalSum(root.right, column + 1);
	}
	
	// find diameter
	// meta: BT31
	public int findDiameter(Node<Integer> root) {
		
		if(root == null) return 0;
		
		int heightLeftSubTree = countLevels(root.left);
		int heightRightSubTree = countLevels(root.right);
		int diameterWithRoot = 1 + heightLeftSubTree + heightRightSubTree;
		
		int leftDiameter = findDiameter(root.left);
		int rightDiameter = findDiameter(root.right);

		return Math.max(diameterWithRoot, Math.max(leftDiameter, rightDiameter));
	}
	
	// LCA of BST
	// meta: BST13
	// calling function will take care of null root
	public Node<Integer> lcaBST(Node<Integer> root, Node<Integer> node1, Node<Integer> node2) {
	
		if(root.data > Math.max(node1.data, node2.data)) {
			return lca(root.left, node1, node2);
		} else if(root.data < Math.max(node1.data, node2.data)) {
			return lca(root.right, node1, node2);
		} else {
			return root;
		}
	}
	
	// is given Binary Tree a BST
	// meta: BST18
	// calling function will invoke with call: isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE)
	public boolean isBST(Node<Integer> root, int value1, int value2) {
		
		if(root == null) return true;
		
		if(root.data < value1 && root.data > value2) {
			return isBST(root.left, value1, root.data) && isBST(root.right, root.data, value2);
		} else {
			return false;
		}
	}
	
	// kth smallest element in BST
	// meta: BST20
	// calling function: findKthSmallestElement(root, 4, 1);
	int count = 1;
	Node<Integer> resultNode = new Node<Integer>(-1);
	public void findKthSmallestElement(Node<Integer> root, int k) {

		if(root == null || resultNode.data != -1) return;
		
		findKthSmallestElement(root.left, k);
		System.out.println(root.data + "("+count+")");
		if(count == k) {
			resultNode = root;
			count++;
			return;
		}
		count++;
		findKthSmallestElement(root.right, k);
		
	}
	
	// print all the elements in the range of k1 and k2, both inclusive
	// meta: BST22
	public void printElementsInRange(Node<Integer> root, int k1, int k2, List<Node<Integer>> nodeList)  {
		
		if(root == null || root.data > k2) return;
		
		printElementsInRange(root.left, k1, k2, nodeList);
	
		if(root.data >= k1 && root.data <= k2) {
			nodeList.add(root);
		} 
		
		printElementsInRange(root.right, k1, k2, nodeList);
	}
	
	
	/*public static void main(String arg[]){
		BinarySearchTree b = new BinarySearchTree();
		b.insert(3);b.insert(8);
		b.insert(1);b.insert(4);b.insert(6);b.insert(2);b.insert(10);b.insert(9);
		b.insert(20);b.insert(25);b.insert(15);b.insert(16);
		System.out.println("Original Tree: ");
		BTreePrinter.printNode(b.root);
		
		// reverse - mirror image
		b.mirror(root);
		System.out.println("Reversed (mirrored) Tree: ");
		BTreePrinter.printNode(root);
		
		// reverse - mirror image
		System.out.println("Leaf nodes: ");
		b.getLeafNodes(b.root);
		System.out.println();

		// count nodes
		System.out.println("Total Nodes: "+b.countNodes(b.root));
		
		// count levels
		//System.out.println("Total Levels: "+b.countLevels(b.root));

		// count levels iteratively
		//System.out.println("Total Levels (iteratavely): "+b.countLevelsIteratively(b.root));
		
		// level-order traversal
		System.out.println("level-order traversal: ");
		b.printLevelOrder();
		System.out.println();
		
		// level-order traversal reverse
		System.out.println("level-order traversal reverse: ");
		b.printLevelOrderReverse();
		System.out.println();
		
		System.out.println("Check whether Node with value 4 exists : " + b.find(4));
		System.out.println("Delete Node with no children (2) : " + b.delete(2));		
		BTreePrinter.printNode(root);
		System.out.println("\n Delete Node with one child (4) : " + b.delete(4));		
		BTreePrinter.printNode(root);
		System.out.println("\n Delete Node with Two children (10) : " + b.delete(10));		
		BTreePrinter.printNode(root);
		
		// trace path from root
		List<Integer> resultList;
		resultList = new ArrayList<Integer>();
		b.tracePath(b.root, 3, resultList);
		System.out.println("Path of 3 from root is: "+resultList);
		resultList = new ArrayList<Integer>();
		b.tracePath(b.root, 1, resultList);
		System.out.println("Path of 1 from root is: "+resultList);
		resultList = new ArrayList<Integer>();
		b.tracePath(b.root, 2, resultList);
		System.out.println("Path of 2 from root is: "+resultList);
		resultList = new ArrayList<Integer>();
		b.tracePath(b.root, 10, resultList);
		System.out.println("Path of 10 from root is: "+resultList);
		resultList = new ArrayList<Integer>();
		b.tracePath(b.root, 15, resultList);
		System.out.println("Path of 15 from root is: "+resultList);
		resultList = new ArrayList<Integer>();
		b.tracePath(b.root, 16, resultList);
		System.out.println("Path of 16 from root is: "+resultList);
		
		// find max
		System.out.println("Max value is: "+b.findMax(b.root));

		// find min
		System.out.println("Min value is: "+b.findMin(b.root));
		
		// find max iteratively
		System.out.println("Max value (iteratively) is: "+b.findMaxIteratively(b.root));
		
		// find min iteratively
		System.out.println("Min value (iteratively) is: "+b.findMinIteratively(b.root));
		
		// find deepest nodes iteratively
		List<Node<Integer>> deepestNodes = b.findDeepestNodesIteratively(b.root);
		List<Integer> deepNodeValues = new ArrayList<Integer>();
		for(Node<Integer> node : deepestNodes) {
			deepNodeValues.add(node.data);
		}
		System.out.println("Deepest nodes (iteratively) are: "+deepNodeValues);
		
		// find leaf nodes iteratively
		List<Node<Integer>> leafNodes = b.findLeafNodesIteratively(b.root);
		List<Integer> leafNodeValues = new ArrayList<Integer>();
		for(Node<Integer> node : leafNodes) {
			leafNodeValues.add(node.data);
		}
		System.out.println("Leaf nodes (iteratively) are: "+leafNodeValues);
		
		// find full nodes iteratively
		List<Node<Integer>> fullNodes = b.findFullNodesIteratively(b.root);
		List<Integer> fullNodeValues = new ArrayList<Integer>();
		for(Node<Integer> node : fullNodes) {
			fullNodeValues.add(node.data);
		}
		System.out.println("Full nodes (iteratively) are: "+fullNodeValues);
		
		// find half nodes iteratively
		List<Node<Integer>> halfNodes = b.findHalfNodesIteratively(b.root);
		List<Integer> halfNodeValues = new ArrayList<Integer>();
		for(Node<Integer> node : halfNodes) {
			halfNodeValues.add(node.data);
		}
		System.out.println("Half nodes (iteratively) are: "+halfNodeValues);
		
		// another tree b2
		BinarySearchTree b2 = new BinarySearchTree();
		b2.insert(4);b2.insert(9);
		b2.insert(2);b2.insert(5);b2.insert(7);b2.insert(3);b2.insert(11);b2.insert(10);
		b2.insert(21);b2.insert(26);b2.insert(16);b2.insert(17);
		System.out.println("Another Tree b2: ");
		BTreePrinter.printNode(b2.root);
		
		// another tree b3
		BinarySearchTree b3 = new BinarySearchTree();
		b3.insert(2);b3.insert(5);b3.insert(7);b3.insert(3);b3.insert(11);b3.insert(10);
		System.out.println("Another Tree b3: ");
		BTreePrinter.printNode(b3.root);
		
		// find whether two trees are identical
		System.out.println("Are trees are itentical (b and b2)? :"+b.areStructurallySame(b.root, b2.root));
		System.out.println("Are trees are itentical (b and b3)? :"+b.areStructurallySame(b.root, b3.root));
		System.out.println("Are trees are itentical (b2 and b3)? :"+b.areStructurallySame(b2.root, b3.root));
		
		// find level having maximum sum
		System.out.println("Level having maximum sum (iteratively) is: "+b.findLevelHavingMaxSumIteratively(b.root));
		
		// print all the root-to-leaf paths
		Deque<Integer> queue = new LinkedList<Integer>();
		System.out.println("Following are all the root-to-leaf paths: ");
		b.printRootToLeafPaths(b.root, queue);
		System.out.println();

		// given a sum check whether there exists a path from root to any of the nodes
		Deque<Integer> queue2 = new LinkedList<Integer>();
		System.out.println("check sum: ");
		b.checkSum(b.root, queue2, 21);
		System.out.println();
		
		// given a sum check whether there exists a path from root to any of the nodes
		// second approach: it returns only true or false
		System.out.println(b.checkSumSecondApproach(b.root, 21));
		
		// find sum of all the nodes
		System.out.println("Sum of all the nodes is: "+b.getSum(b.root));
		System.out.println("Sum of all the nodes (iteratively) is: "+b.getSumIteratively(b.root));

		// build tree for given inorder and preorder traversals
		int[] inOrder = new int[] {1, 2, 3, 4, 6, 8, 9, 10, 15, 16, 20, 25};
		int[] preOrder = new int[] {3, 1, 2, 8, 4, 6, 10, 9, 20, 15, 16, 25};
		Node<Integer> rootNewTree = b.buildTree(inOrder, preOrder, 0, inOrder.length -1);
		System.out.println("New tree is: ");
		BTreePrinter.printNode(rootNewTree);
		System.out.println("Are trees same: "+b.areStructurallySame(b.root, rootNewTree));
		
		// get all the ancestors of a node
		System.out.println("Following are the ancestors: ");
		b.printAncestors(b.root, 20);
		
		System.out.println("Following are the ancestors (optimized): ");
		b.printAncestorsOptimized(b.root, new Node<Integer>(20));

		// least common ancestor
		Node<Integer> lca1 = b.lca(b.root, new Node<Integer>(2), new Node<Integer>(15));
		System.out.println("LCA of 2 and 15 is: "+lca1.data);
	
		// fill sibling iteratively
		b.fillSiblingIteratively(b.root);
		System.out.println("Tree with filled sibling: ");
		BTreePrinter.printNode(b.root);
		
		// build specific tree
		char[] preOrderArr = new char[]{'I', 'L', 'I', 'L', 'L'}; 
		Node<Integer> nodeSpecific = b.buildTreeSpecific(preOrderArr, 0);
		BTreePrinter.printNode(nodeSpecific);
		
		// find vertical sum
		b.findVerticalSum(b.root, 0);
		System.out.println("Vertical Sum: "+b.verticalMap);
		
		// find diameter
		System.out.println("Diameter is: "+b.findDiameter(b.root));
		
		// lcaBST
		System.out.println("LCA (BST) for 6 and 25 is: "+b.lcaBST(b.root, new Node<Integer>(6), new Node<Integer>(25)).data);
		System.out.println("LCA (BST) for 8 and 25 is: "+b.lcaBST(b.root, new Node<Integer>(8), new Node<Integer>(25)).data);
		
		// find kth smallest element in BST
		//System.out.println("4th smallest element is: "+b.findKthSmallestElement(b.root, 4).data);
		
		System.out.println("In order traversal: ");
		b.findKthSmallestElement(b.root, 4);
		System.out.println("resultNode (4): "+b.resultNode.data);
		
		b.count = 1;
		b.resultNode = new Node<Integer>(-1);
		b.findKthSmallestElement(b.root, 5);
		System.out.println("resultNode (5): "+b.resultNode.data);
		
		b.count = 1;
		b.resultNode = new Node<Integer>(-1);
		b.findKthSmallestElement(b.root, 7);
		System.out.println("resultNode (7): "+b.resultNode.data);
		
		// print all the elements in the range of k1 and k2, both inclusive
		List<Node<Integer>> nodeListRange = new LinkedList<Node<Integer>>();
		b.printElementsInRange(b.root, 1, 10, nodeListRange);
		System.out.println("Range: ");
		for(Node<Integer> node: nodeListRange) {
			System.out.print(" "+node.data);
		}
		System.out.println();
	}*/
	
}
