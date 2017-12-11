package org.sample.thread.futureTask;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTaskExample {

	public static void process() {
		Callable<Integer> callableObject = new Callable<Integer>() {
			@Override
			public Integer call() throws Exception {
				Thread.sleep(5000);
				return 1000;
			}
		};
		
		// wrap FutureTask with Callable
		//Future<Integer> runnable = new FutureTask<Integer>(callableObject);
		FutureTask<Integer> runnable = new FutureTask<Integer>(callableObject);
		
		// start the future
		//(new Thread((Runnable)runnable)).start();
		(new Thread(runnable)).start();
		
		try {
			System.out.println("Try to get the value...");
			long start = System.currentTimeMillis();
			runnable.get();
			System.out.println("Time Elapsed in gettig the result... "+(System.currentTimeMillis() - start));
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		process();
	}

}
