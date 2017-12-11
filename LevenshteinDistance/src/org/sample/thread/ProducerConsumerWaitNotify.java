package org.sample.thread;

public class ProducerConsumerWaitNotify {

	private static SharedObject sharedObject = new SharedObject();
	
	public static void start() {
		
		ProducerWaitNotify producer = new ProducerWaitNotify(sharedObject, 1);
		ConsumerWaitNotify consumer1 = new ConsumerWaitNotify(sharedObject, 1);
		ConsumerWaitNotify consumer2 = new ConsumerWaitNotify(sharedObject, 2);
		
		(new Thread(producer)).start();
		(new Thread(consumer1)).start();
		(new Thread(consumer2)).start();
		
	}
	
	public static void main (String[] args) {
		start();
	}
		
}
