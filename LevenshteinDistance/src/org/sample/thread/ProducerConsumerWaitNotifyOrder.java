package org.sample.thread;

public class ProducerConsumerWaitNotifyOrder {

	private static SharedObject sharedObject = new SharedObject();
	
	public static void start() {
		
		ProducerWaitNotifyOrder producer = new ProducerWaitNotifyOrder(sharedObject, 1);
		ConsumerWaitNotifyOrder consumer1 = new ConsumerWaitNotifyOrder(sharedObject, 1, 1);
		ConsumerWaitNotifyOrder consumer2 = new ConsumerWaitNotifyOrder(sharedObject, 2, 2);
		ConsumerWaitNotifyOrder consumer3 = new ConsumerWaitNotifyOrder(sharedObject, 3, 3);
		ConsumerWaitNotifyOrder consumer4 = new ConsumerWaitNotifyOrder(sharedObject, 4, 4);
		ConsumerWaitNotifyOrder consumer5 = new ConsumerWaitNotifyOrder(sharedObject, 5, 5);
		ConsumerWaitNotifyOrder consumer6 = new ConsumerWaitNotifyOrder(sharedObject, 6, 6);
		ConsumerWaitNotifyOrder consumer7 = new ConsumerWaitNotifyOrder(sharedObject, 7, 7);
		ConsumerWaitNotifyOrder consumer8 = new ConsumerWaitNotifyOrder(sharedObject, 8, 8);
		ConsumerWaitNotifyOrder consumer9 = new ConsumerWaitNotifyOrder(sharedObject, 9, 9);
		ConsumerWaitNotifyOrder consumer10 = new ConsumerWaitNotifyOrder(sharedObject, 10, 10);
		
		(new Thread(producer)).start();
		(new Thread(consumer1)).start();
		(new Thread(consumer2)).start();
		(new Thread(consumer3)).start();
		(new Thread(consumer4)).start();
		(new Thread(consumer5)).start();
		(new Thread(consumer6)).start();
		(new Thread(consumer7)).start();
		(new Thread(consumer8)).start();
		(new Thread(consumer9)).start();
		(new Thread(consumer10)).start();
		
	}
	
	public static void main (String[] args) {
		start();
	}
		
}
