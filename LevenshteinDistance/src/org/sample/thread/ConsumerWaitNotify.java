package org.sample.thread;

public class ConsumerWaitNotify implements Runnable {

	private SharedObject sharedObject;
	private int id;

	public ConsumerWaitNotify(SharedObject sharedObject, int id) {
		this.sharedObject = sharedObject;
		this.id = id;
	}

	@Override
	public void run() {

		while(true) {
			while(sharedObject.getValue() == 0) {
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
				if(sharedObject.getValue() == 0) {
					sharedObject.notifyAll();
					continue;
				}
				
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
