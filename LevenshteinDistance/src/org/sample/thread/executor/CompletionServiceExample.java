package org.sample.thread.executor;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CompletionServiceExample {

	public static void process() {
		System.out.println("starts...");
		int size = 20;
		
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		CompletionService<Integer> completionService = new ExecutorCompletionService<Integer>(executorService);
		
		for(int i = size; i >= 1; i--) {
			completionService.submit(new Square(i));
		}
		
		
		for(int count = 1; count <= size; count++) {
			try {
				Future<Integer> future = completionService.take();
				System.out.println("squred value: "+future.get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("All values calculated!");
		executorService.shutdown();
		
	}
	
	
	public static void main(String[] args) {
		process();
	}
}

