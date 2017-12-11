package org.sample.thread.executor;

public class Task implements Runnable {

	private int id;
	
	public Task(int id) {
		this.id = id;
	}
	@Override
	public void run() {
		System.out.println("Task "+id+" running ...");
		try {
			
			//Thread.interrupted()
			Thread.sleep(30000000);
			System.out.println("Inteerupt "+Thread.interrupted());
		} catch (InterruptedException e) {
			e.printStackTrace();
			//System.out.println("Task "+id+" interrupted during sleep ...");
		}
		System.out.println("Task "+id+" completed!");
	}

}
