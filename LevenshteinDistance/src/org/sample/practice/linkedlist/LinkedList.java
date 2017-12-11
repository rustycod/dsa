package org.sample.practice.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class LinkedList {

	private Node head;
	
	public Node getHead() {
		return head;
	}
	
	public void setHead(Node head) {
		
		this.head = head;
	}
	
	// traverse
	public List<Integer> traverse() {
		
		List<Integer> linkedList = new ArrayList<Integer>(); // for junit

		Node currentNode = head;
		
		while(currentNode != null) {
			linkedList.add(currentNode.data);
			currentNode = currentNode.next;
		}
		
		return linkedList;
	}
	
	// size
	public int size() {
		return traverse().size();
	}
	
	// adding to head
	public void add(int data) {
		Node newNode = new Node(data);
		newNode.next = head;
		this.head = newNode;
	}
	
	// adding to head
	public Node addNode(int data) {
		Node newNode = new Node(data);
		newNode.next = head;
		this.head = newNode;
		return newNode;
	}
	
	// adding to tail
	public void addToTail(int data) {
		Node newNode = new Node(data);
		
		Node currentNode = head;
		
		if(currentNode == null) {
			head = newNode;
			return;
		}
		
		while(currentNode.next != null) {
			currentNode = currentNode.next;
		}
		
		currentNode.next = newNode;
	}
	
	// adding node to tail
	public Node addNodeToTail(int data) {
		Node newNode = new Node(data);
		
		Node currentNode = head;
		
		if(currentNode == null) {
			head = newNode;
			return head;
		}
		
		while(currentNode.next != null) {
			currentNode = currentNode.next;
		}
		
		currentNode.next = newNode;
		return newNode;
	}
	
	// adding to tail
	public void addToTail(Node newNode) {
		
		Node currentNode = head;
		
		if(currentNode == null) {
			head = newNode;
			return;
		}
		
		while(currentNode.next != null) {
			currentNode = currentNode.next;
		}
		
		currentNode.next = newNode;

	}
	
	// insert after
	public void insertAfter(int data1, int data2) {
		
		Node currentNode = head;
		
		while(currentNode != null && currentNode.data != data1) {
			currentNode = currentNode.next;
		}
		
		if(currentNode == null) return; // data1 doesn't exist
		
		// add data2 to currentNode
		Node newNode = new Node(data2);
		Node nextNode = currentNode.next;
		currentNode.next = newNode;
		newNode.next = nextNode;
	}
	
	
	// RC04016
	public void insertInSortedOrder(int data) {
		
		Node currentNode = head;
		Node newNode = new Node(data);
		
		if(currentNode == null) {
			head = newNode;
			return;
		}
		
		Node previous = null;
		
		while(currentNode != null && currentNode.data < data) {
			previous = currentNode;
			currentNode = currentNode.next;
		}
		
		
		if(previous == null) {
			head = newNode;
		} else {
			previous.next = newNode;
		}
		
		newNode.next = currentNode;
	}
	
	
	// delete
	public void delete(int data) {
		
		Node currentNode = head;
		Node prevNode = null;
		
		while(currentNode != null && currentNode.data != data) {
			prevNode = currentNode;
			currentNode = currentNode.next;
		}
		
		if(currentNode == null) return; // node to be deleted not found
		
		// prevNode
		Node nextNode = currentNode.next;
		prevNode.next = nextNode;
	}
	
	
	// isEmpty
	public boolean isEmpty() {
		return head == null? true: false;
	}
	
	// reverse: RC04016
	public Node reverse(Node node) {
		
		Node currentNode = node;
		Node prevNode = null;
		Node nextNode = null;
		
		while(currentNode != null) {
			nextNode = currentNode.next;
			currentNode.next = prevNode;
			prevNode = currentNode;
			currentNode = nextNode;
		}
		
		return prevNode;
	}
	
	// reverse recursively - yet to be corrected
	public Node reverseRecursively(Node prevNode, Node node, Node nextNode) {
		
		if(nextNode.next == null) {
			nextNode.next = node;
			node.next = prevNode;
			return nextNode;
		} 
		
		Node newNode = reverseRecursively(prevNode.next, node.next, nextNode.next);
		newNode.next = node;
		
		return newNode;
	}
	

	// recursive method
	public int i = 0;  
	public Node findnthToLastRecursion(Node node, int pos) {

	    Node result = node;

	    if(node != null) {
	        result = findnthToLastRecursion(node.next, pos);

	        i++;
	        if(i == pos){
	            result = node;
	        }
	    }
	    return result;
	}

	
	// book's answer: kept here for an example of code not working
	// spot the mistake
	int counter = 0;
	public Node nthNodeFromEndBookAnswer(Node node, int n) {
		
		if(node != null) {
			nthNodeFromEndBookAnswer(node.next, n);
			counter++;
			if(n == counter) {
				return node;
			}
		}
		
		return null;
	}
	
	
	// nth node form the end
	public int nodeValue = -100;
	public int nthNodeFromEnd(Node node, int n) {
		
		if(node == null) return 0;
		
		int count = nthNodeFromEnd(node.next, n) + 1;
		if(count == n) {
			nodeValue = node.data;
		}
		
		return count;
	}
	
	
	// iterative method
	public Node nthNodeFromEnd(int n) {
		
		Node startPositionPointer1 = head;
		
		while(n > 1) {
			startPositionPointer1 = startPositionPointer1.next;
			if(startPositionPointer1 == null) {
				return null; // not enough nodes in linkedlist
			}
			n--;
		}
		
		
		Node nthNodePointer2 = head;
		
		while(startPositionPointer1.next != null){
			startPositionPointer1 = startPositionPointer1.next;
			nthNodePointer2 = nthNodePointer2.next;
		}
		
		return nthNodePointer2;
	}

	
	// whether cycle exists
	public boolean whetherCycleExists() {
		
		// both the pointers are at head initially
		Node slowPointer = head;
		Node fastPointer = head;
		
		while(true) {
			slowPointer = slowPointer.next;
			
			if(fastPointer == null) return false;
			fastPointer = fastPointer.next; 
			
			if(fastPointer == null) return false;
			fastPointer = fastPointer.next;
			
			// compare only when fastPointer has completed two steps atomically, otherwise we can't find start of the loop
			if(slowPointer == fastPointer) return true;
		}
	}
	
	// break the cycle
	public Node breakCycle() {
		
		// both the pointers are at head initially
		Node slowPointer = head;
		Node fastPointer = head;
		
		while(true) {
			slowPointer = slowPointer.next;

			fastPointer = fastPointer.next; 
			fastPointer = fastPointer.next;
			
			if(slowPointer == fastPointer) break;
		}
		
		slowPointer = head;
		
		while(true) {
			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next;
			
			if(slowPointer == fastPointer) {
				return slowPointer;
			}
		}
	}
	
	
	// find length of loop
	public int getLoopLength() {
		
		Node startLoopNode = breakCycle();
		Node currentNode = startLoopNode.next;
		int count = 1;
		
		while(startLoopNode != currentNode) {
			currentNode = currentNode.next;
			count++;
		}
		
		return count;
	}
	
	// RC04023
	public Node findMergingPoint(LinkedList ll1, LinkedList ll2) {
		
		int length1 = ll1.size();
		int length2 = ll2.size();
		
		int diff = 0;
		boolean firstLLBigger = false;
		
		if(length1 > length2) {
			diff = length1 - length2;
			firstLLBigger = true;
		} else {
			diff = length2 - length1;
			firstLLBigger = false;
		}
		
		Node pointer1 = ll1.getHead();
		Node pointer2 = ll2.getHead();
		
		if(firstLLBigger) {
			while(diff > 0) {
				pointer1 = pointer1.next;
				diff--;
			}
		} else {
			while(diff > 0) {
				pointer2 = pointer2.next;
				diff--;
			}
		}
		
		
		while(true) {
			
			pointer1 = pointer1.next;
			pointer2 = pointer2.next;
			
			if(pointer1 == pointer2) {
				return pointer1;
			}
		}
	}
	
	// find middle // RC04024
	public Node findMiddle() {
		
		if(head == null || head.next == null) return head;
		
		Node fastPointer = head;
		Node slowPointer = head;
		
		while(fastPointer.next != null) {
			fastPointer = fastPointer.next;
			if(fastPointer.next != null) {
				fastPointer = fastPointer.next;
			}
			
			slowPointer = slowPointer.next;
		}
		
		return slowPointer;
		
	}
	
	// find middle // RC04024 - another version
	public Node findMiddle(Node node) {
		
		if(node == null || node.next == null) return node;
		
		Node fastPointer = node;
		Node slowPointer = node;
		
		while(fastPointer.next != null) {
			fastPointer = fastPointer.next;
			if(fastPointer.next != null) {
				fastPointer = fastPointer.next;
			}
			
			slowPointer = slowPointer.next;
		}
		
		return slowPointer;
		
	}
	
	
	// RC04025
	public List<Integer> nodesReverse = new ArrayList<Integer>();
	public void printReverse(Node node) {
		if(node != null) {
			printReverse(node.next);
			nodesReverse.add(node.data);
		}
	}
	
	// RC04026
	public boolean whetherLengthIsEven() {
		
		boolean whetherLengthIsEven = true;
		
		Node currentNode = head;
		
		while(currentNode != null) {
			currentNode = currentNode.next;
			whetherLengthIsEven = false;
			
			if(currentNode != null) {
				currentNode = currentNode.next;
				whetherLengthIsEven = true;
			}
		}
		
		return whetherLengthIsEven;
	}
	

	// RC04028
	public Node mergeTwoSortedLinkedLists(Node ll1Head, Node ll2Head) {
		
		LinkedList ll3 = new LinkedList();
		
		while(ll1Head != null && ll2Head != null) {
			
			int data1 = ll1Head.data;
			int data2 = ll2Head.data;
			
			if(data1 >= data2) {
				ll3.addToTail(data2);
			} else {
				ll3.addToTail(data1);
			}
			
			ll1Head = ll1Head.next;
			ll2Head = ll2Head.next;
		}
		
		
		while(ll1Head != null) {
			ll3.addToTail(ll1Head.data);
			ll1Head = ll1Head.next;
		}
		
		while(ll2Head != null) {
			ll3.addToTail(ll2Head.data);
			ll2Head = ll2Head.next;
		}
		
		return ll3.getHead();
		
	}
	
	
	// RC04028
	public Node mergeTwoSortedLinkedListsRecuesively(Node ll1Node, Node ll2Node) {
		
		if(ll1Node == null) return ll2Node;
		
		if(ll2Node == null) return ll1Node;
		
		if(ll1Node.data <= ll2Node.data) {
			return ll1Node.next = mergeTwoSortedLinkedListsRecuesively(ll1Node.next, ll2Node);
		} else {
			return ll2Node.next = mergeTwoSortedLinkedListsRecuesively(ll1Node, ll2Node.next);
		}
		
	}
	
	// check whether linkedlist is in sorted order
	public boolean isInOrder(Node node) {
		if(node == null) return true;
		
		if(node.next != null) {
			return node.data <= node.next.data && isInOrder(node.next);
		} else {
			return true;
		}
	}
	
	// RC04029
	public Node reverseLinkedListInPairs(Node node) {
		
		if(node == null || node.next == null) return node;
		
		Node nextNode = node.next;
		Node futureNode = nextNode.next;
		
		// swap pointers
		nextNode.next = node;
		node.next = reverseLinkedListInPairs(futureNode);
		
		return nextNode; 
	}
	
	
	public Node reverseLinkedListInPairsIteratively(Node node) {
		
		if(node == null || node.next == null) return node;
		
		Node head = node;
		
		Node currentNode = node;
		Node prevNode = head;
		Node temp1 = null;
		Node temp2 = null;
		
		int i = 0;
		
		while(currentNode != null && currentNode.next != null) {
						
			//prevNode = currentNode;
			if(i == 0) {
				head = currentNode.next;
				i++;
			} else {
				prevNode.next = currentNode.next;
			}
			
			
			temp1 = currentNode.next;
			temp2 = currentNode.next.next;

			currentNode.next.next = currentNode;
			currentNode.next = temp2;
			
			prevNode = temp1.next;
			currentNode = temp2;
		}
		
		if(currentNode != null) {
			prevNode.next = currentNode;
		}

		return head; 
	}


	// Circular Linked List
	
	// RC04030
	// returns node of second CLL
	public Node splitCircularLinkedList(Node node) {
		
		if(node == null) return null;
		
		Node headNode = node;
		
		int sizeCLL = sizeofCLL(node);
		int sizeSecondCLL = sizeCLL / 2;
		int sizeFirstCLL = sizeCLL - sizeSecondCLL;
		
		int countFirstCLL = 1;
		Node currentNodeFirstCLL = headNode;
		Node prevNode = null;
		while(countFirstCLL <= sizeFirstCLL) {
			prevNode = currentNodeFirstCLL;
			currentNodeFirstCLL = currentNodeFirstCLL.next;
			countFirstCLL++;
		}
		
		// first CLL
		prevNode.next = headNode;
		
		if(sizeSecondCLL == 0) return null;
		
		Node headNodeSecondCLL = currentNodeFirstCLL;
		Node currentNodeSecondCLL = headNodeSecondCLL;
		Node prevNodeSecondDLL = null;
		int countSecondCLL = 1;
		while(countSecondCLL <= sizeSecondCLL) {
			prevNodeSecondDLL = currentNodeSecondCLL;
			currentNodeSecondCLL = currentNodeSecondCLL.next;
			countSecondCLL++;
		}
		
		prevNodeSecondDLL.next = headNodeSecondCLL;
		
		return headNodeSecondCLL;
		
	}
	
	public int sizeofCLL(Node head) {
		return traverseCircularLinkedList(head).size();
	}

	/*public void traverseCircularLinkedList(Node head, Node currentNode) {
		
		if(head == null || head == currentNode) return;
		
		listCLL.add(currentNode.data);
		traverseCircularLinkedList(head, currentNode.next);
	}*/
	
	public List<Integer> traverseCircularLinkedList(Node head) {
		
		List<Integer> listCLL = new ArrayList<Integer>();
		
		if(head == null) return listCLL;
		
		listCLL.add(head.data);
		Node currentNode = head;
		
		while(currentNode.next != head) {
			listCLL.add(currentNode.next.data);
			currentNode = currentNode.next;
		}
		
		return listCLL;
	}
	
	
	public Node reverseSetOfThree(Node node) {
		
		if(node == null || node.next == null || node.next.next == null) {
			return node;
		}
		
		// swap pointers
		Node currentNode = node;
		Node nextNode1 = node.next;
		Node nextNode2 = node.next.next;
		Node temp = nextNode2.next;
		
		nextNode2.next = nextNode1;
		nextNode1.next = node;
		
		currentNode.next = reverseSetOfThree(temp);
		
		return nextNode2;
	}
	
	// RC04032
	public Node reverseSetOfKNodes(Node node, int k) {
		
		Node currentNode = node;
	
		int count = k;
		while(count > 0) {
			if(currentNode == null) return node; 
			currentNode = currentNode.next;
			count--;
		}
		
		// swap pointers
		Node startNodeNextSet = currentNode;
		
		currentNode = node;
		Node prevNode = null;
		Node nextNode = null;
		
		while(currentNode != startNodeNextSet) {
			nextNode = currentNode.next;
			currentNode.next = prevNode;
			prevNode = currentNode;
			currentNode = nextNode;
		}
		
		node.next = reverseSetOfKNodes(startNodeNextSet, k);
		return prevNode;
		
	}
	
	
	// RC04031
	public boolean isPalindrome(final Node node) {

		if(node == null || node.next == null) return true;
		
		int length = 0;
		Node currNode = node;
		while(currNode != null) {
			length++;
			currNode = currNode.next;
		}
		
		int breakPoint = length / 2 + 1;
		
		Node breakPointNode = null;
		Node prevNode = null;
		int currenrPosition = 0;
		Node currentNode = node;
		
		while(currentNode != null) {
			currenrPosition++;
			if(breakPoint == currenrPosition) {
				breakPointNode = currentNode; 
				break;
			}
			prevNode = currentNode;
			currentNode = currentNode.next;
		}
		
		
		// reverse linkedlist at breakpoint
		prevNode.next = reverse(breakPointNode);		
		
		Node nodeSecondHalf = prevNode.next;  // second half of linkedlist
		Node startNode = node; 
		Node cuurNodeSecond = nodeSecondHalf;
			
		boolean isPalindrome = true;
		  
			
		while(startNode != nodeSecondHalf) {
			if(startNode.data != cuurNodeSecond.data) {
				isPalindrome = false;
				break;
			}
			startNode = startNode.next;
			cuurNodeSecond = cuurNodeSecond.next;
		}
		
		
		// correct the linkedlist again, i.e. reverse the second half again
		prevNode.next = reverse(nodeSecondHalf);
		
		return isPalindrome;
	}
	
	
	public boolean areSameLinkedLists(Node node1, Node node2) {
		
		if(node1 == null && node2 == null) return true;
		
		if(node1 == null || node2 == null) return false;
		
		return node1.data == node2.data && areSameLinkedLists(node1.next, node2.next);
		// keep the comparison of data first, so that recursion stops if data is not equal as && is short-circuit operator and algorithm becomes more efficient
		
	}

	
	// RC04035
	// clone special linkedlist
	public NodeWithRandomPointer cloneSpecialTree(NodeWithRandomPointer node) {
		
		LinkedList llClone = new LinkedList();
		
		NodeWithRandomPointer currentNode = node;
		
		// first traversal
		while(currentNode != null) {
			//llClone.addToTail(currentNode);
			llClone.addToTail(new NodeWithRandomPointer(currentNode.data));
			currentNode = (NodeWithRandomPointer)currentNode.next;
		}
		
		// second traversal
		currentNode = node;
		NodeWithRandomPointer currentNodeClone = (NodeWithRandomPointer)llClone.getHead();
		while(currentNode != null) {
			currentNodeClone.random = currentNode.random;
			currentNode = (NodeWithRandomPointer)currentNode.next;
			currentNodeClone = (NodeWithRandomPointer)currentNodeClone.next;
		}
		
		return (NodeWithRandomPointer)llClone.getHead();
	}
	
	// traverse: RC04035
	public void traverseSpecialTree(NodeWithRandomPointer node) {
		
		NodeWithRandomPointer currentNode = node;
		
		while(currentNode != null) {
			int randomNodeData = currentNode.random == null ? -1 : currentNode.random.data;
			System.out.println("{"+currentNode.data+", "+randomNodeData+"}");
			currentNode = (NodeWithRandomPointer)currentNode.next;
		}
		
	}
	
	// RC04034: josephus circle
	public Node getLeader(Node node, int k) {
		
		int count = 0;
		
		Node currentNode = node;
		Node prevNode = null;
		
		while(currentNode != null && currentNode != currentNode.next) {
			
			if(count == k) {
				currentNode = currentNode.next;
				prevNode.next = currentNode;
				count = 1;
				continue;
			}
			prevNode = currentNode;
			currentNode = currentNode.next;
			count++;
		}
		
		
		return currentNode;
	}

}
