package org.sample.thread;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerFairOrder {

	public static void start() {
		
		BlockingQueue<Integer> bq = new ArrayBlockingQueue<Integer>(10);
		
		ProducerFair producerFair1 = new ProducerFair(bq, 1, 1, 50);
		
		Queue<Integer> order = new LinkedList<Integer>();
		
		ConsumerFair consumerFair1 = new ConsumerFair(bq, 1, order);
		order.add(1);
		
		ConsumerFair consumerFair2 = new ConsumerFair(bq, 2, order);
		order.add(2);
		
		ConsumerFair consumerFair3 = new ConsumerFair(bq, 3, order);
		order.add(3);
		
		ConsumerFair consumerFair4 = new ConsumerFair(bq, 4, order);
		order.add(4);
		
		
		Thread producerFair1Thread = new Thread(producerFair1);
		producerFair1Thread.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		(new Thread(consumerFair1)).start();
		(new Thread(consumerFair2)).start();
		(new Thread(consumerFair3)).start();
		(new Thread(consumerFair4)).start();
		
	}
	
	
	public static void main (String[] args) {
		start();
	}
}
