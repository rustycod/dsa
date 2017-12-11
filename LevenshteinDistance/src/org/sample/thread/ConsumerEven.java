package org.sample.thread;

import java.util.concurrent.BlockingQueue;

public class ConsumerEven implements Runnable {

	private BlockingQueue<Integer> bq;
	private int id;
	
	public ConsumerEven(BlockingQueue<Integer> bq, int id) {
		this.bq = bq;
		this.id = id;
	}

	@Override
	public void run() {
		while(true) {
			try {
				if(bq.peek() != null && bq.peek()%2 == 0) {
					System.out.println("ConsumerEven get: "+bq.take());
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
