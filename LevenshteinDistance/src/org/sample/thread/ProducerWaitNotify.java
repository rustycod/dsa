package org.sample.thread;

public class ProducerWaitNotify implements Runnable {

	private SharedObject sharedObject;
	private int id;

	public ProducerWaitNotify(SharedObject sharedObject, int id) {
		this.sharedObject = sharedObject;
		this.id = id;
	}

	@Override
	public void run() {

		for(int i = 1; i <= 100; i++) {

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
