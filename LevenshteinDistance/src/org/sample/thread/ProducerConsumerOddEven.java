package org.sample.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerOddEven {

	public static void start() {
		
		BlockingQueue<Integer> bq = new ArrayBlockingQueue<Integer>(10);
		
		Producer producer1 = new Producer(bq, 1);
		ConsumerOdd consumerOdd = new ConsumerOdd(bq, 1);
		ConsumerEven consumerEven = new ConsumerEven(bq, 2);
		
		(new Thread(producer1)).start();
		(new Thread(consumerOdd)).start();
		(new Thread(consumerEven)).start();
		
	}
	
	
	public static void main (String[] args) {
		start();
	}
}
