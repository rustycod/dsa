package org.sample.thread;

import java.util.concurrent.BlockingQueue;

public class ProducerFair implements Runnable {

	private BlockingQueue<Integer> bq;
	private int id;
	private int start;
	private int end;
	
	public ProducerFair(BlockingQueue<Integer> bq, int id, int start, int end) {
		this.bq = bq;
		this.id = id;
		this.start = start;
		this.end = end;
	}

	@Override
	public void run() {

		for(int i = start; i <= end; i++) {
			try {
				bq.put(i);
				System.out.println("Producer(" +id +") put: "+i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}
