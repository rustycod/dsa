package org.sample.thread.semaphore;

import java.util.concurrent.Semaphore;

public class Worker implements Runnable {

	private Semaphore semaphore;
	private int id;
	
	public Worker(Semaphore semaphore, int id) {
		this.semaphore = semaphore;
		this.id = id;
	}
	
	@Override
	public void run() {
		System.out.println("Worker("+id+") starts running");
		
		try {
			semaphore.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Worker("+id+") running with semaphore");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		semaphore.release();
	}

}
