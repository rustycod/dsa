package org.sample.thread;

public class ProducerWaitNotifyOrder implements Runnable {

	private SharedObject sharedObject;
	private int id;

	public ProducerWaitNotifyOrder(SharedObject sharedObject, int id) {
		this.sharedObject = sharedObject;
		this.id = id;
	}
	
	private int[] arr = {7, 5, 4, 1, 10, 3, 8, 2, 9, 6};

	@Override
	public void run() {

		for(int i : arr) {

			while(sharedObject.getValue() != 0) {
				try {
					synchronized(sharedObject) {
						sharedObject.wait();
					}

				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} 

			synchronized(sharedObject) {
				
				sharedObject.setValue(i);
				System.out.println("Producer(" +id +") put: "+i);
				sharedObject.notifyAll();
			}
		}

	}
}
