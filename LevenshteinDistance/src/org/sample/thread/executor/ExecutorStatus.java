package org.sample.thread.executor;

import java.util.concurrent.ExecutorService;

public class ExecutorStatus implements Runnable {

	private ExecutorService executor;
	
	public ExecutorStatus(ExecutorService executor) {
		this.executor = executor;
	}
	
	@Override
	public void run() {
		while(true) {
			System.out.println("executor isShutdown: "+executor.isShutdown());
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
