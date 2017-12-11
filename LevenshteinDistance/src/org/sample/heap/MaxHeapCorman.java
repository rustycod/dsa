package org.sample.heap;

public class MaxHeapCorman {

	int heapSize;
	
	private int parent(int index) {
		return (index - 1) / 2;
	}
	
	private int left(int index) {
		return 2*index + 1;
	}
	
	private int right(int index) {
		return 2*index + 2;
	}
	
	// maxHeapify
	public void maxHeapify(int[] arr, int index) {
	
		int leftIndex = left(index);
		int rightIndex = right(index);
		int largest = index;
		
		if(leftIndex < heapSize && arr[leftIndex] > arr[index]){
			largest = leftIndex;
		}
		
		if(rightIndex < heapSize && arr[rightIndex] > arr[largest]){ // notice here rightIndex is being compared with largest
			largest = rightIndex;
		}
		
		if(largest != index) {
			
			// swap
			int temp = arr[index];
			arr[index] = arr[largest];
			arr[largest] = temp;
			
			maxHeapify(arr, largest);
		}
		
	}
	
	
	// buildMaxHeap
	public void buildMaxHeap(int[] arr) {
		heapSize = arr.length;
		int index = (heapSize - 2) / 2;
		for(int i = index; i >= 0; i--) {
			maxHeapify(arr, i);
		}
	}
	
	// heapSort
	public void heapSort(int[] arr) {
		buildMaxHeap(arr);
		
		while(heapSize > 1) {

			// swap
			int temp = arr[0];
			arr[0] = arr[heapSize - 1];
			arr[heapSize - 1] = temp;
			
			heapSize = heapSize - 1;
			maxHeapify(arr, 0);
			
		}
	}
	
	
	// priority queue method ...
	
	// max
	public int max(int[] arr) {
		return arr[0];
	}
	
	// extractMax
	public int extractMax(int[] arr) {
		if(arr.length < 0) {
			return Integer.MIN_VALUE; // error condition
		}
		
		int result = arr[0];
		arr[0] = arr[heapSize - 1];
		
		heapSize = heapSize - 1;
		maxHeapify(arr, 0);
		
		return result;
	}
	
	// increaseKey
	public void increaseKey(int[] arr, int index, int key) {
		if(arr[index] > key) {
			return; // error condition
		}
		
		arr[index] = key;
		
		// maintain max-heap property
		while(index > 0 && arr[index] > arr[parent(index)]) {
			
			// swap
			int temp = arr[index];
			arr[index] = arr[parent(index)];
			arr[parent(index)] = temp;
			
			index = parent(index);
		}
		
	}
	
	// insert
	public void insert(int[] arr, int key){
		arr[heapSize] = Integer.MIN_VALUE;
		heapSize = heapSize + 1;
		increaseKey(arr, heapSize, key);
		
	}
	
	
	// main method
	public static void main(String[] args){
		int[] arr = new int[] {27, 17, 3, 16, 13, 10, 1, 5, 7, 12, 4, 8, 9, 0};
		MaxHeapCorman maxHeap = new MaxHeapCorman();
		//maxHeap.buildMaxHeap(arr);
		
		/*System.out.println("Result:");
		for(int val : arr) {
			System.out.print(val + " ");
		}
		System.out.println();*/
		
		maxHeap.heapSort(arr);
		System.out.println("Sorted Array:");
		for(int val : arr) {
			System.out.print(val + " ");
		}
		System.out.println();
	}

}
