package org.sample.linkedlist;

import java.util.LinkedHashSet;
import java.util.Set;

// linkedList will not contain duplicate nodes
public class LinkedList {
	
	private Node head;
	
	// add a node with data given
	public Node add(int data) {
		
		Node newNode = new Node(data);

		if(head == null) {
			head = newNode;
			return newNode;
		}
		
		Node currentNode = head;
		
		while(currentNode.getNext() != null){
			currentNode = currentNode.getNext();
		}
		
		currentNode.setNext(newNode);
		return newNode;
	}
	
	// add a node in the end
	/*public Node add(Node node) {

		Node currentNode = head;
		Node previousNode = null;
		
		while(currentNode != null) {
			previousNode = currentNode;
			currentNode = currentNode.getNext();
		}
		
		if(previousNode == null) {
			head = node;
		}
		
		previousNode.setNext(node);
		
		return node;
		
	}*/
	
	
	public Node add(Node node) {

		if(head == null) {
			head = node;
			return node;
		}
		
		Node currentNode = head;
		
		while(currentNode.getNext() != null) {
			currentNode = currentNode.getNext();
		}
		
		currentNode.setNext(node);
		
		return node;
		
	}
	
	// traverse
	public Set<Integer> traverse() {
		Node currentNode = head;
		
		Set<Integer> linkedListValues = new LinkedHashSet<Integer>(); // for unit testing
		
		while(currentNode != null) {
			System.out.print(currentNode.getData() + " ");
			linkedListValues.add(currentNode.getData());
			currentNode = currentNode.getNext();
		}
		
		return linkedListValues;
	}

	// remove a node
	public Node remove(int data) {
		
		Node removedNode = null;
		
		// corner case 1
		if(head == null) {
			return null; // node not found
		}
		
		// corner case 2: head is the only node in list
		if(head.getNext() == null && head.getData() == data){
			removedNode = head;
			head = null;
			return removedNode;
		} 

		Node currentNode = head.getNext();
		Node previousNode = currentNode;
		
		while(currentNode != null) {
			if(currentNode.getData() == data) {
				previousNode.setNext(currentNode.getNext());
				currentNode.setNext(null);
				return currentNode;
			}
			previousNode = currentNode;
			currentNode = currentNode.getNext();
		}
		
		return null; // node not found
		
	}
	
	
	// reverse
	public Node reverse() {
		
		Node currentNode = head;
		Node previous = null;

		while(currentNode != null) {
			Node tempNode = currentNode.getNext();
			currentNode.setNext(previous);
			
			previous = currentNode;
			currentNode = tempNode;
		}
		
		head = previous;
		return head;
		
	}
	
	
	public void printReverse() {
		printReverse(head);
	}
	
	private void printReverse(Node node) {
		
		if(node != null) {
			
			printReverse(node.getNext());
			System.out.println(node.getData());
		}
	}
	
	public int size() {
		return traverse().size();
	}
	
	public Node getHead() {
		return head;
	}
	
	public Node search(int val) {	
		Node currentNode = head;
		while(currentNode != null && currentNode.getData() != val) {
			currentNode = currentNode.getNext();
		}
		
		return currentNode;
	}
	
	
	@Override
	public String toString() {
		
		Node currentNode = head;
		StringBuilder nodes = new StringBuilder();
		
		while(currentNode != null) {
			nodes.append(currentNode.getData() + " ");
			currentNode = currentNode.getNext();
		}
		
		return "LinkedList [" + nodes + "]";
	}

}

class Node {
	private int data;
	private Node next;
	
	// constructor
	Node(int data) {
		this.data = data;
		this.next = null;
	}
	
	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

} 



