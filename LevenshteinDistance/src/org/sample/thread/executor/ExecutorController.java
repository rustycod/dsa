package org.sample.thread.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorController implements Runnable {

	private ExecutorService executor;
	
	public ExecutorController(ExecutorService ExecutorService) {
		this.executor = ExecutorService;
	}
	
	@Override
	public void run() {
		// call for shutdown
		try {
			
			Thread.sleep(5000);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("shutdown called ...");
		executor.shutdown();
		try {
			executor.awaitTermination(1, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
