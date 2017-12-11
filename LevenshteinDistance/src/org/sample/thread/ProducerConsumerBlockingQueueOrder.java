package org.sample.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerBlockingQueueOrder {

	public static void start() {
		
		BlockingQueue<Integer> bq = new ArrayBlockingQueue<Integer>(10);
		
		ProducerBlockingQueueOrder producer1 = new ProducerBlockingQueueOrder(bq, 1);
		
		ConsumerBlockingQueueOrder consumer10 = new ConsumerBlockingQueueOrder(bq, 10, 10);
		ConsumerBlockingQueueOrder consumer9 = new ConsumerBlockingQueueOrder(bq, 9, 9);
		ConsumerBlockingQueueOrder consumer8 = new ConsumerBlockingQueueOrder(bq, 8, 8);
		ConsumerBlockingQueueOrder consumer7 = new ConsumerBlockingQueueOrder(bq, 7, 7);		
		ConsumerBlockingQueueOrder consumer6 = new ConsumerBlockingQueueOrder(bq, 6, 6);
		ConsumerBlockingQueueOrder consumer5 = new ConsumerBlockingQueueOrder(bq, 5, 5);		
		ConsumerBlockingQueueOrder consumer4 = new ConsumerBlockingQueueOrder(bq, 4, 4);
		ConsumerBlockingQueueOrder consumer3 = new ConsumerBlockingQueueOrder(bq, 3, 3);
		ConsumerBlockingQueueOrder consumer2 = new ConsumerBlockingQueueOrder(bq, 2, 2);
		ConsumerBlockingQueueOrder consumer1 = new ConsumerBlockingQueueOrder(bq, 1, 1);
		

		(new Thread(producer1)).start();
		(new Thread(consumer10)).start();
		(new Thread(consumer9)).start();
		(new Thread(consumer8)).start();
		(new Thread(consumer7)).start();
		(new Thread(consumer6)).start();
		(new Thread(consumer5)).start();
		(new Thread(consumer4)).start();
		(new Thread(consumer3)).start();
		(new Thread(consumer2)).start();
		(new Thread(consumer1)).start();
		
	}
	
	
	public static void main (String[] args) {
		start();
	}
}
