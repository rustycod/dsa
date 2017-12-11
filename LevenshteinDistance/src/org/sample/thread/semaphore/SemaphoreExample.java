package org.sample.thread.semaphore;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {

	public static void process() {
		int size = 5;
		Semaphore sem = new Semaphore(size);
		
		for(int i = 1; i <= 100; i++) {
			
			(new Thread(new Worker(sem, i))).start();
			
		}
	}
	
	
	public static void main(String[] args) {
		process();
	}
}
