package org.sample.thread;

public class ConsumerWaitNotifyOrder implements Runnable {

	private SharedObject sharedObject;
	private int id;
	
	private int itemRequired;

	public ConsumerWaitNotifyOrder(SharedObject sharedObject, int id, int itemRequired) {
		this.sharedObject = sharedObject;
		this.id = id;
		this.itemRequired = itemRequired;
	}

	@Override
	public void run() {

		while(true) {
			while(sharedObject.getValue() != itemRequired) {
				try {
					synchronized(sharedObject) {
						sharedObject.wait();	
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} 

			synchronized(sharedObject) {
				
				// in case any other consumer has already picked the item from shared space
				/*if(sharedObject.getValue() == 0) {
					sharedObject.notifyAll();
					continue;
				}*/
				
				System.out.println("Consumer(" +id +"): "+sharedObject.getValue());
				sharedObject.setValue(0);
				
				try {
					Thread.currentThread().sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				sharedObject.notifyAll();
			}
		}
	}
}
