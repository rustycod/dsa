package org.sample.practice.stack;

import org.sample.practice.linkedlist.LinkedList;
import org.sample.practice.linkedlist.Node;

// internally it's using likedlist
public class Stack {

	private int size;
	private int top;
	private LinkedList ll = new LinkedList();
	
	public Stack(int size) {
		this.size = size;
	}
	
	public boolean push(int data) {
		
		if(top == size) {
			return false; // stack already full
		}
		
		// add to head
		ll.add(data);
		top++;
		
		return true;
	}
	
	public int pop() {
		if(top == 0) return -1;
		
		Node val = ll.getHead();
		ll.setHead(val.next);
		
		top--;
		return val.data;
		
	}
	
	public int size() {
		return ll.size();
	}
}
