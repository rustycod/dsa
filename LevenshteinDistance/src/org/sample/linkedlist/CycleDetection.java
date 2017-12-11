package org.sample.linkedlist;

public class CycleDetection {

	private Node createLinkedListWithCycle() {
		LinkedList llCycle = new LinkedList();
		llCycle.add(1);llCycle.add(2);llCycle.add(3);llCycle.add(4);llCycle.add(5);
		
		Node nodeWhereLoopStarts = llCycle.add(6);
		
		llCycle.add(7);
		llCycle.add(8);
		llCycle.add(9);
		Node nodeWhereLoopEnds = llCycle.add(10);
		
		// form the loop
		nodeWhereLoopEnds.setNext(nodeWhereLoopStarts);
		
		return llCycle.getHead();
		
	}
	
	public static void main (String[] args) {
		CycleDetection cd = new CycleDetection();
		cd.cycleDetection(cd.createLinkedListWithCycle());
	}
	
	public void cycleDetection(Node head) {
		
		Node slowPointer = head;
		Node fastPointer = head;
		
		boolean cycleDetected = false;
		
		while(fastPointer.getNext() != null){
			
			System.out.println("iteration starts with slowPointer at: "+slowPointer.getData() +" and fastPointer at: "+fastPointer.getData());
			
			// fastPointer moving two steps
			fastPointer = fastPointer.getNext();

			if(fastPointer.getNext() != null) {
				fastPointer = fastPointer.getNext();
			}
			
			// slowPointer moving one step
			slowPointer = slowPointer.getNext();
			
			// both the pointers have performed one set of their operations, so compare now whether they meet
			if(fastPointer == slowPointer) {
				cycleDetected = true;
				break;
			}
			
		}
		
		if(cycleDetected){
			
			fastPointer = slowPointer;
			slowPointer = head;
			
			while(slowPointer != fastPointer) {
				
				System.out.println("cycleDetected - slowPointer at: "+slowPointer.getData() +" and fastPointer at: "+fastPointer.getData());
				slowPointer = slowPointer.getNext();
				fastPointer = fastPointer.getNext();
				
			}
			
			System.out.println("loop starts at: "+slowPointer.getData());
		}
		
	}
	
}
