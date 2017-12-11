package org.sample.thread;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

	private BlockingQueue<Integer> bq;
	private int id;
	
	public Consumer(BlockingQueue<Integer> bq, int id) {
		this.bq = bq;
		this.id = id;
	}

	@Override
	public void run() {
		
		for(int i = 0; i < 100; i++) {
			try {
				System.out.println("Consumer(" +id +") get: "+bq.take());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}
