package org.sample.thread;

import java.util.concurrent.BlockingQueue;

public class ConsumerBlockingQueueOrder implements Runnable {

	private BlockingQueue<Integer> bq;
	private int id;
	private int itemRequired;
		
	public ConsumerBlockingQueueOrder(BlockingQueue<Integer> bq, int id, int itemRequired) {
		this.bq = bq;
		this.id = id;
		this.itemRequired = itemRequired;
	}

	@Override
	public void run() {
		
		while(true) {
			try {
				if(bq.peek() != null && bq.peek() == itemRequired) {
					System.out.println("Consumer(" +id +") get: "+bq.take());
					break;
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}
