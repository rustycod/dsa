package org.sample.practice.queue;

import java.util.Queue;

public class QueueMisc {
	
	public static void reverse(Queue<Integer> queue) {
		
		if(queue.isEmpty()) return;
		
		int currElement = queue.poll();
		reverse(queue);
		queue.add(currElement);
		
	}

}
