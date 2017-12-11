package org.sample.thread;

import java.util.concurrent.BlockingQueue;

public class ConsumerOdd implements Runnable {

	private BlockingQueue<Integer> bq;
	private int id;
	
	public ConsumerOdd(BlockingQueue<Integer> bq, int id) {
		this.bq = bq;
		this.id = id;
	}

	@Override
	public void run() {
		while(true) {
			try {
				if(bq.peek() != null && bq.peek()%2 == 1) {
					System.out.println("ConsumerOdd get: "+bq.take());
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
