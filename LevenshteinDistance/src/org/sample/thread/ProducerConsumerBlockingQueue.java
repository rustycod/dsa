package org.sample.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerBlockingQueue {

	public static void start() {
		
		BlockingQueue<Integer> bq = new ArrayBlockingQueue<Integer>(10);
		
		Producer producer1 = new Producer(bq, 1);
		Consumer consumer1 = new Consumer(bq, 1);
		Consumer consumer2 = new Consumer(bq, 2);
		
		
		(new Thread(producer1)).start();
		(new Thread(consumer1)).start();
		(new Thread(consumer2)).start();
		
	}
	
	
	public static void main (String[] args) {
		start();
	}
}
