package org.sample.heap;

import org.sample.tree.BTreePrinterTest;
import org.sample.tree.BinaryTree;
import org.sample.tree.Node;

/**
 * This is based on zero-based index
 * 
 * Operations Supported:
 * 	- offer 
 *  - peek 
 *  - poll
 * 
 * 
 */

public class MinHeap {

	private int[] internalArray = new int[100];
	private int size = 0;
	
	public int size() {
		return size;
	}
	
	public void offer(int newValue) {

		internalArray[size++] = newValue;
		
		if(size == 1) {
			return;
		}
		
		// start it from parent of last element to root
		int lastIndex = size - 1;
		
		for(int i = (lastIndex - 1) / 2; i >= 0; i--) {
			heapify(i); // TODO change it
		}
		
		
	}
	
	public int peek() {
		return internalArray[0];
	}
	
	public int poll() {
		int rootValue = internalArray[0];
		internalArray[0] = internalArray[size - 1];
		internalArray[size - 1] = Integer.MAX_VALUE;
		size--;
		              
		// start it from parent of last element to root
		int lastIndex = size - 1;
		
		for(int i = (lastIndex - 1) / 2; i >= 0; i--) {
			heapify(i);
		}
		
		return rootValue;
	}
	
	// this is a convenience method to print a heap and is not related to heap data structure
	public void print(int size) {
		System.out.println("Min Heap is: ");
		for(int i = 0; i < size; i++) {
			System.out.print(internalArray[i] + " ");
		}
		System.out.println();
	}

	private void heapify(int index) {
		
		int min; 
		int minIndex;
	
		// find the min of three
		if(left(index) < right(index)) {
			min = left(index);
			minIndex = 2*index + 1;
		} else {
			min = right(index);
			minIndex = 2*index + 2;
		}	
			
		if(min < internalArray[index]) {
			// swap
			int temp = internalArray[index];
			internalArray[index] = min;
			internalArray[minIndex] = temp;
		}
	}
	
	private int parent(int index) {
		
		return internalArray[(index - 1) / 2];
	}
	
	private int left(int index) {
		
		if(2*index + 1 >= size) {
			return Integer.MAX_VALUE; // TODO change it
		} 
		return internalArray[2*index + 1];
	}
	
	private int right(int index) {

		if(2*index + 2 >= size) {
			return Integer.MAX_VALUE; // TODO change it
		} 
		
		return internalArray[2*index + 2];
	}
	
	public static void main (String[] args) {
		MinHeap minHeap = new MinHeap();
		minHeap.offer(16);
		minHeap.offer(17);
		minHeap.offer(4);
		minHeap.offer(3);
		minHeap.offer(15);
		minHeap.offer(2);
		minHeap.offer(1);
		
		minHeap.print(minHeap.size());
		
		for(int i = minHeap.size(); i > 0; i--) {
			System.out.println("Peek: "+i+": "+minHeap.peek());
			System.out.println("Poll: "+i+": "+minHeap.poll());
			minHeap.print(minHeap.size());
			System.out.println("-------------------------------");
		}
		
		
		
	}
}
