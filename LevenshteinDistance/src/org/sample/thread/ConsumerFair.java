package org.sample.thread;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;

public class ConsumerFair implements Runnable {

	private BlockingQueue<Integer> bq;
	private int id;
	private Queue<Integer> order;
	
	public ConsumerFair(BlockingQueue<Integer> bq, int id, Queue<Integer> order) {
		this.bq = bq;
		this.id = id;
		this.order = order;
	}

	@Override
	public void run() {
		
		while(true) {
			synchronized(order) {
				while(!order.isEmpty() && order.peek() != id) {
					try {
						order.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			
			synchronized(order) {
				order.add(order.poll());
				if(bq.peek() != null) {
					try {
						System.out.println("Consumer("+id+"): "+bq.take());
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				order.notifyAll();
			}			
		}
	}
}
