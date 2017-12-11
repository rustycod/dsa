package org.sample.linkedlist;

import java.util.Set;

public class MergeTwoSortedLinkedLists {

	public void merge(LinkedList ll1, LinkedList ll2, Node currentll1Node, Node currentll2Node, LinkedList mergedll) {
		
		if(currentll1Node == null) {
			// merge remaining nodes of ll2 to result
			mergedll.add(currentll2Node);
			return;
		}
		
		if(currentll2Node == null) {
			// merge remaining nodes of ll1 to result
			mergedll.add(currentll1Node);
			return;
		}
		
		if(currentll1Node.getData() < currentll2Node.getData()) {
			mergedll.add(currentll1Node.getData());
			currentll1Node = currentll1Node.getNext();
		} else {
			mergedll.add(currentll2Node.getData());
			currentll2Node = currentll2Node.getNext();
		}
		
		merge(ll1, ll2, currentll1Node, currentll2Node, mergedll);
		
	}
	
	private void appendNodes(LinkedList firstll, Node node) {
		
		Node currentNode = firstll.getHead();
		Node previousNode = null;
		
		while(currentNode != null) {
			previousNode = currentNode;
			currentNode = currentNode.getNext();
		}
		
		if(previousNode == null) {
			
		}

		previousNode.setNext(node);
		
	}
	
	public static void main (String[] args) {
		LinkedList ll1 = new LinkedList();
		ll1.add(1);ll1.add(3);ll1.add(5);ll1.add(7);ll1.add(9);
		
		LinkedList ll2 = new LinkedList();
		ll2.add(2);ll2.add(4);ll2.add(6);ll2.add(8);ll2.add(10);
		
		LinkedList merged = new LinkedList();
		
		MergeTwoSortedLinkedLists obj = new MergeTwoSortedLinkedLists();
		obj.merge(ll1, ll2, ll1.getHead(), ll2.getHead(), merged);
		
		Set<Integer> mergedValues = merged.traverse();
		System.out.println("Merged LinedList: "+mergedValues);
		
	}
	
}
