package org.sample.thread.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProducerConsumerExecutor implements Runnable {

	private static ExecutorService executor = Executors.newFixedThreadPool(5);
	
	public static void process() {
		
		for(int i = 1; i > 0; i++) { // infinite loop
			Task task = new Task(i);
			//if(!executor.isShutdown()) {
				/*try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}*/
				//System.out.println("is shutdown("+i+"): "+executor.isShutdown());
				executor.submit(task);
				System.out.println("task("+i+") submitted!");
			//}
		}
		
	}
	

	public static void main(String[] args) {
		(new Thread(new ProducerConsumerExecutor())).start();
		//System.out.println("isShutdown: "+executor.isShutdown());
		//(new Thread(new ExecutorController(executor))).start();
		Thread statusThread = new Thread(new ExecutorStatus(executor));
		statusThread.setDaemon(true);
		statusThread.start();
		
		//process();
	}


	@Override
	public void run() {
		process();
	}
}
