package org.sample.practice.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;



/**
 * This BST doesn't support duplicate values
 * 
 * Conditions:
 * 		left child < root
 * 		right child > root
 * */
public class BinarySearchTree {

	Node root;
	
	// insert a new node in tree
	public boolean insert(int val) {
		
		Node node = new Node(val);
		
		if(root == null) {
			root = node;
			return true;
		}
		
		Node parent = null;
		Node currentNode = root;
		boolean newNodeAsLeft = true;
		
		while(currentNode != null) {
			parent = currentNode;
			if(node.val < currentNode.val) {
				currentNode = currentNode.left;
				newNodeAsLeft = true;
			} else {
				currentNode = currentNode.right;
				newNodeAsLeft = false;
			}
		}

		if(newNodeAsLeft) {
			parent.left = node;
			return true;
		} else {
			parent.right = node;
			return true;
		}
		
	} // end of method - insert
	
	

	// search
	public Node search(int val) {
		
		if(root == null) {
			return null;
		}
		
		Node currentNode = root;
		
		while(currentNode != null) {

			if(currentNode.val == val) {
				return currentNode;
			} else if (val < currentNode.val) {
				currentNode = currentNode.left;
			} else {
				currentNode = currentNode.right;
			}
		}
		
		return null;
		
	} // end of method - search
	

	public boolean searchIteatively(Node root, Node target) {
	    Node current = root;
	 
	    while (current != null) {
		if (current.val > target.val) 
		    current = current.left;
		else if (current.val < target.val) 
		    current = current.right;
		else
		    return true;
	    }
	 
	    return false;
	}
	
	// delete
	/*public void delete(int val) {
		
		if(root == null) {
			return;
		}
		
		Node parentNode = null;
		Node currentNode = root;
		Node nodeToBeDeleted = null;
		boolean nodeLeft = true;
		
		while(currentNode != null) {
			if(currentNode.val == val) {
				nodeToBeDeleted = currentNode;
				break;
			} else if (currentNode.val > val) {
				parentNode = currentNode;
				currentNode = currentNode.left;
				nodeLeft = true;
			} else {
				parentNode = currentNode;
				currentNode = currentNode.right;
				nodeLeft = false;
			}
		}
		
		if(nodeToBeDeleted == null) {
			return; // node to be deleted doesn't exist
		}
		
		// check whether node to be deleted has any child
		if(nodeToBeDeleted.left == null && nodeToBeDeleted.right == null) {
			if(parentNode == null) { // the case when root is to be deleted
				root = null;
			} else if(nodeLeft) {
				parentNode.left = null;
			} else {
				parentNode.right = null;
			}
		} else if(nodeToBeDeleted.left != null && nodeToBeDeleted.right == null) {
			if(parentNode == null) { // the case when root is to be deleted
				root = nodeToBeDeleted.left;
			} else if(nodeLeft) {
				parentNode.left = nodeToBeDeleted.left;
			} else {
				parentNode.right = nodeToBeDeleted.left;
			}
		} else if(nodeToBeDeleted.left == null && nodeToBeDeleted.right != null) {
			if(parentNode == null) { // the case when root is to be deleted
				root = nodeToBeDeleted.right;
			} else if(nodeLeft) {
				parentNode.left = nodeToBeDeleted.right;
			} else {
				parentNode.right = nodeToBeDeleted.right;
			}
		} else {
			// need to find successor
			Node successorNode = getSuccessor(nodeToBeDeleted);
			nodeToBeDeleted.val = successorNode.val;
		}
		
	} // end of method - search
*/
	
	/*public Node getSuccessor(Node node) {
		// it must be having both left and right child
		Node rightNode = node.right;
		
		Node successorNode = null;
		
		if(rightNode.left == null) {
			successorNode = rightNode;
			return successorNode;
		}
		
		Node parentNode = rightNode;
		Node currentNode = rightNode.left;
		
		while(currentNode.left != null) {
			parentNode = currentNode;
			currentNode = currentNode.left;
		}
		
		successorNode = currentNode;
		parentNode.left = null;
		
		return successorNode;
		
	}*/
	

	/**
	 * This method will find success of node that has both the left and right child
	 * 
	 * Case 1: right node is the only node in hierarchy i.e. it is a leaf node
	 * Case 2: right node has no left node and only subtree at its right node
	 * Case 3: right node has also subtree at its left node
	 * 
	 * */
	/*public Node getSuccessor(Node node) {
		// it must be having both left and right child
		Node parentNode = node;
		Node currentNode = node.right;
		
		Node successorNode = null;
		
		// case 1 and 2
		if(currentNode.left == null) {
			parentNode.val = currentNode.val;
			parentNode.right = currentNode.right;
			return;
		}
		
		while(currentNode.left != null) {
			parentNode = currentNode;
			currentNode = currentNode.left;
		}
		
		successorNode = currentNode;
		
		if(successorNode.right != null) {
			parentNode.left = successorNode.right;
		} else {
			parentNode.left = null;
		}
		
		return successorNode;
		
	}*/
	// find minimum
	public Node findMinimum(Node root) {
		if(root == null) return null;
		
		while(root.left != null) {
			root = root.left;
		}
		
		return root;
	}
	
	
	// find maximum
	public Node findMaximum(Node root) {
		if(root == null) return null;
		
		while(root.right != null) {
			root = root.right;
		}
		
		return root;
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
	
	public void inOrderMorris(Node root) {

		while(root != null) {
			
			if(root.left == null) {
				// visiting root node
				listNodeValues.add(root.val);
				root = root.right;
			} else {
				
				// find predecessor of root
				Node currentNode = root.left;
				
				if(currentNode.right != null) {
					while(currentNode.right != null) {
						
						if(currentNode.right == root) {
							// visiting root node
							listNodeValues.add(root.val);
							root = root.right;
							break;
						}
						
						currentNode = currentNode.right;
					}
					
					continue;
				} 
				
				currentNode.right = root;
				root = root.left;
			}
		}
	}
	
	
	/**
	 * create a mirror of given BST
	 * this method will modify the given tree rather than creating a copy of it
	 * 
	 * In this approch  
	 * 
	 * */
	public Node createMirror(Node root) {
		
		if(root != null) {
			
			createMirror(root.left);
			createMirror(root.right);
			
			// swap both the nodes (XOR can also be performed as an alternate approach)
			Node temp = root.left;
			root.left = root.right;
			root.right = temp;
		}
		
		return root;
	}
	
	/**
	 * validates a BST
	 * 
	 * this method assumes:
	 * 1. the values in tree are between Integer.MIN_VALUE and Integer.MAX_VALUE
	 * 2. left node value < root and right node value > root 
	 * 
	 * Note: It has one more approach where recursion will stop if next value not
	 * greater than current value
	 * 
	 * */
	public boolean isValidBST(Node root, int min, int max) {
		
		if(root != null) {
		
			if(root.val > min && root.val < max // Note: && is short-circuit operator, so when first condition w.r.t root.val fails, it'll not go for further recursion call
					&& isValidBST(root.left, min, root.val) 
					&& isValidBST(root.right, root.val, max)) {
				return true;
			} else {
				return false;
			}
			
		}
		
		return true;
	}
	
	/**
	 * This method assumes that:
	 * 1. both the nodes for which LCA is to be found exist in the tree
	 * 2. First value node1 is smaller than second value node2
	 * 3. calling function will take care of null root
	 * 
	 * */
	public int findLCA(Node root, int node1, int node2) {
		
		if(root.val == node1 || root.val == node2 || (root.val > node1 && root.val < node2)) {
			return root.val;
		} else if (root.val > node1 && root.val > node2) {
			return findLCA(root.left, node1, node2);
		} else {
			return findLCA(root.right, node1, node2);
		}
	}
	
	
	// alternate method
	/*TreeNode lca(TreeNode root, TreeNode one, TreeNode two) {
	    // Check if one and two are in the root tree.
	    while (root != null) {
	        if (root.data < one.data && root.data < two.data) {
	            root = root.right;
	        }
	        else if (root.data > one.data && root.data > two.data) {
	            root = root.left;
	        }
	        else {
	            return root;
	        }
	    }
	 
	    return null;
	}*/
	
	// another version of findLCA
	// LCA of BST
	// meta: BST13
	// calling function will take care of null root
	/*public Node<Integer> lcaBST(Node<Integer> root, Node<Integer> node1, Node<Integer> node2) {
		
		if(root.data > Math.max(node1.data, node2.data)) {
			return lca(root.left, node1, node2);
		} else if(root.data < Math.max(node1.data, node2.data)) {
			return lca(root.right, node1, node2);
		} else {
			return root;
		}
	}*/
	
	/**
	 * This method assumes K >= 1
	 * */
	/*public int count = 1;
	public Node kthNode;
	public void findKthSmallest(Node root, int k) {
		
		if(root == null) return;
		
		findKthSmallest(root.left, k);
		
		if(count == k) {
			kthNode = root;
			return;
		}
		
		count++;
	
		findKthSmallest(root.right, k);
	}*/
	

	/*public void findKthSmallest(Node root, int k, int count) {
		
		if(count == k) return;
		
		findKthSmallest(root.left, k, count + 1);
		
		if(count == k) {
			kthNode = root;
			return;
		}
		
		count++;
	
		findKthSmallest(root.right, k);
	}*/
	
	
	/**
	 * calling function will handle null root
	 * */
	//public List<Integer> listPaths = new ArrayList<Integer>(200);
	public int[] arr = new int[256];
	public List<List<Integer>> listAllRootToLeafPaths = new ArrayList<List<Integer>>();
	public void getAllRootToLeafPaths(Node root, int pathIndex) {
		
		if(root == null) return;
		
		//listPaths.set(pathIndex, root.val);
		arr[pathIndex] = root.val;
		pathIndex++;
		// in case of leaf node, print the path 
		if(root.left == null && root.right == null) {
			// print
			//System.out.println("Path: "+listPaths);
			/*for(int i = 0; i < pathIndex; i++) {
				System.out.print(listPaths.get(i) + " ");
			}*/
			
			for(int i = 0; i < pathIndex; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			//listAllRootToLeafPaths.add(Collections.unmodifiableList(listPaths)); // this needs to be changed
			//return;
		} else {
			if(root.left != null) {
				getAllRootToLeafPaths(root.left, pathIndex);
				//listPaths.remove(listPaths.size() -1);
			}
			
			if(root.right != null) {
				getAllRootToLeafPaths(root.right, pathIndex);
				//listPaths.remove(listPaths.size() -1);
			}
		}
	}
	
	public void getAllRootToLeafPaths(Node root, List<Integer> path) {
		
		path.add(root.val);
		
		// in case of leaf node, print the path 
		if(root.left == null & root.right == null) {
			// print
			System.out.println("Path (2): "+path);
			//listAllRootToLeafPaths.add(Collections.unmodifiableList(listPaths)); // this needs to be changed
		} else {
			if(root.left != null) {
				getAllRootToLeafPaths(root.left, path);
				path.remove(path.size() -1);
			}
			
			if(root.right != null) {
				getAllRootToLeafPaths(root.right, path);
				path.remove(path.size() -1);
			}
		}
	}
	
	/**
	 * Calling method will handle root as null
	 * 
	 * */
	public List<Integer> listAncestorsOfANode = new ArrayList<Integer>();
	public void findAncestorsOfANode(Node root, int val) {
		
		listAncestorsOfANode.add(root.val);
		
		if(root.val == val) {
			// node found
			System.out.println("All the ancestors: "+listAncestorsOfANode);
			return;
		} else {
			if(root.left != null) {
				findAncestorsOfANode(root.left, val);
				listAncestorsOfANode.remove(listAncestorsOfANode.size() -1);
			}
			if(root.right != null) {
				findAncestorsOfANode(root.right, val);
				listAncestorsOfANode.remove(listAncestorsOfANode.size() -1);
			}
		}
	}
	
	
	public int[] arrAncestors = new int[256];
	public void findAncestorsOfANodeUsingArray(Node root, int val, int pathIndex) {

		if(root == null) return;

		arrAncestors[pathIndex++] = root.val;

		if(root.val == val) {
			// node found
			for(int i = 0; i < pathIndex; i++) {
				System.out.print(arrAncestors[i]+" ");
			}
			System.out.println("");
		} else {
			findAncestorsOfANodeUsingArray(root.left, val, pathIndex);
			findAncestorsOfANodeUsingArray(root.right, val, pathIndex);
		}
	}
		
	// this is for testing purpose only for Binary Tree. To be moved in Binary Tree class
	public int findMax(Node root) {
		
		if(root == null) return Integer.MIN_VALUE;
		
		int max = Integer.MIN_VALUE;
		
		if(findMax(root.left) > findMax(root.right)) {
			max = findMax(root.left);
		} else {
			max = findMax(root.right);
		}
		
		if(root.val > max) {
			return root.val;
		} else {
			return max;
		}
	}
	
	
	// get the number of nodes in a tree recursively
	public int getSize(Node root) {
		
		if(root == null) return 0;
		
		return getSize(root.left) + 1 + getSize(root.right);
	}
	
	// get the number of nodes in a tree iteratively
	public int getSizeIteratively(Node root) {
		
		if(root == null) return 0;
		
		int count = 0;
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		
		while(!queue.isEmpty()){
			Node temp = queue.poll();
			count++;
			
			if(temp.left != null) {
				queue.add(temp.left);
			}
			
			if(temp.right != null){
				queue.add(temp.right);
			}
		}
		
		return count;
	}
	
	// height / depth / level of the tree
	public int getHeight(Node root) {
		
		if(root == null) return -1;
		
		int heightOfLeftSubTree = getHeight(root.left);
		int heightOfRightSubTree = getHeight(root.right);
		
		if(heightOfLeftSubTree > heightOfRightSubTree) {
			return heightOfLeftSubTree + 1;
		} else {
			return heightOfRightSubTree + 1;
		}
	}

	// height / depth / level of the tree
	public int getHeightIteratively(Node root) {
		
		if(root == null) return -1;
		
		int level = -1;
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		queue.add(null); // identifier for each level
		
		while(!queue.isEmpty()) {
			
			Node temp = queue.poll();
			
			if(temp == null) {
				level++;
				
				if(!queue.isEmpty()) {
					queue.add(null);
				}
			} else {
				if(temp.left != null) {
					queue.add(temp.left);
				}
				
				if(temp.right != null) {
					queue.add(temp.right);
				}				
			}
		}
		
		return level;
	}
	

	// RC07008
	public List<Integer> printLevelOrderReverse(Node root) {
        Queue<Node> queue = new LinkedList<Node>();
        Stack<Integer> stack = new Stack<Integer>();
    
        List<Integer> listValuesReverse = new ArrayList<Integer>(); // for testing purpose in junit
        
        if(root == null) {
        	return null;
        }
        
        queue.add(root);
        while (!queue.isEmpty()) {
            // poll() removes the present head.
            Node tempNode = queue.poll();
 
            /*Enqueue right child */
            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }

            /*Enqueue left child */
            if (tempNode.left != null) { 
                queue.add(tempNode.left);
            }
            
            stack.push(tempNode.val);
        }
        
        while(!stack.isEmpty()) {
        	//System.out.print(" " + stack.pop());
        	listValuesReverse.add(stack.pop());
        }
        
        return listValuesReverse;
        
    }
	
	
	// identical trees
	public boolean areIdenticalTrees(Node root1, Node root2) {
		
		if(root1 == null && root2 == null) return true;
		
		if(root1 == null || root2 == null) return false;
		
		return root1.val == root2.val && areIdenticalTrees(root1.left, root2.left) && areIdenticalTrees(root1.right, root2.right);
		
	}
	

	public boolean areMirrors(Node root1, Node root2) {
		
		if(root1 == null && root2 == null) return true;
		
		// improve it
		if((root1 == null && root2 != null) || (root1 != null && root2 == null)) return false;
		
		return root1.val == root2.val && areMirrors(root1.left, root2.right) && areMirrors(root1.right, root2.left);
		
	}
	
	
	public boolean doesSumExist(Node root, int sum) { // 109, 59, 45, 36
		
		if(root.val == sum) {
			return true;
		}
		
		// leaf node
		if(root.left == null && root.right == null) {
			return false;
		}
		
		boolean leftSide = false;
		if(root.left != null) {
			leftSide = doesSumExist(root.left, sum - root.val);
		}
		
		boolean rightSide = false;
		if(root.right != null) {
			rightSide = doesSumExist(root.right, sum - root.val);
		}
		
		return leftSide || rightSide;
		
	}
	
	
	// sum
	public int sum(Node root) {
		if(root == null) return 0;
		
		return root.val + sum(root.left) + sum(root.right);
	}
	
	
	public List<Node> findLeafNodesIteratively(Node root) {
		
		List<Node> leafNodes = new LinkedList<Node>(); 
		
		if(root == null) return leafNodes;
		
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		
		
		while(!queue.isEmpty()) {
			
			Node currentNode = queue.poll();
			
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
	public List<Node> findFullNodesIteratively(Node root) {
		
		List<Node> fullNodes = new LinkedList<Node>();
		
		if(root == null) return fullNodes;
		
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			
			Node currentNode = queue.poll();
			
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
	public List<Node> findHalfNodesIteratively(Node root) {
		
		List<Node> halfNodes = new LinkedList<Node>();
		
		if(root == null) return halfNodes;
		
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			
			Node currentNode = queue.poll();
			
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
	}
	
	
	public int findLevelHavingMaxSumIteratively(Node root) {
		
		if(root == null) return -1; // -1 means no tree exist
		
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		queue.add(null); // level delimiter
		
		int sum = 0;
		int maxSum = Integer.MIN_VALUE;
		int level = 0;
		int levelWithMaxSum = 0;
		
		while(!queue.isEmpty()){
			
			Node currentNode = queue.poll();
			
			if(currentNode != null) {
				sum += currentNode.val;
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
		
	}
	
	
	public int getSumIteratively(Node root) {

		if(root == null) return 0;
		
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		
		int sum = 0;
		
		while(!queue.isEmpty()) {

			Node currentNode = queue.poll();
			sum += currentNode.val;
			
			if(currentNode.left != null) {
				queue.add(currentNode.left);
			}
			
			if(currentNode.right != null) {
				queue.add(currentNode.right);
			}
		}
		
		return sum;
	}
	
	
	public int findDiameter(Node root) {
		
		Height height = new Height();
		//return findDiameter1(root, height);
		return findDiameter2(root, height);
		
	}
	
	// post-order type
	/*public int findDiameter1(Node root, Height height) {
		
		Height hLeft = new Height();
		Height hRight = new Height();
		
		if(root == null) {
			height.val = 0;
			return 0;
		}
		
		hLeft.val++;
		hRight.val++;
		
		int leftDiameter = findDiameter1(root.left, hLeft);
		int rightDiameter = findDiameter1(root.right, hRight);
		
		// height of current node
		height.val = Math.max(hLeft.val, hRight.val) + 1;
		
		return Math.max(hLeft.val + hRight.val + 1, Math.max(leftDiameter, rightDiameter));
	}*/
	
	
	public int findDiameter2(Node root, Height height) {
		
		Height hLeft = new Height();
		Height hRight = new Height();
		
		if(root == null) {
			height.val = 0;
			return 0;
		}
		
		//hLeft.val++;
		//hRight.val++;
		
		int leftDiameter = findDiameter2(root.left, hLeft);
		int rightDiameter = findDiameter2(root.right, hRight);
		
		// height of current node
		height.val = Math.max(hLeft.val, hRight.val) + 1;
		
		return Math.max(hLeft.val + hRight.val + 1, Math.max(leftDiameter, rightDiameter));
	}
	
	
	class Height {
		int val;
	}
	
	
	public void printConvexHull(Node root) {
		
		if(root == null) return;
		
		System.out.println("Convex Hull: ");
		System.out.print(root.val + " ");
		printConvexHullHelper(root);
		
	}
	
	
	private Node printConvexHullHelper(Node root) {
		
		if(root == null) return null;
		
		Node leftNode = printConvexHullHelper(root.left);
		Node rightNode = printConvexHullHelper(root.right);
		
		if((leftNode == null && rightNode == null) 
				|| (leftNode == null && rightNode != null)
				|| (leftNode != null && rightNode == null)) {
			System.out.print(root.val + " ");
		}
		
		return root;
	}
	
	
	
	/*public void fillSiblingIteratively(Node root) {
		
		if(root == null) return;
		
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		queue.add(null); // level identifier
		
		while(!queue.isEmpty()) {
			
			Node currentNode = queue.poll();
			
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
	public void fillSibling(Node root) {
		
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

}


class Node {
	
	Node(int val) {
		this.val = val;
	}

	int val;
	Node left; // left child
	Node right; // right child
}
