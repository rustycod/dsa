package org.sample.thread;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

	private BlockingQueue<Integer> bq;
	private int id;
	
	public Producer(BlockingQueue<Integer> bq, int id) {
		this.bq = bq;
		this.id = id;
	}

	@Override
	public void run() {

		for(int i = 1; i <= 10; i++) {
			try {
				bq.put(i);
				System.out.println("Producer(" +id +") put: "+i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}
