package org.sample.thread;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {
	
	private static CountDownLatch latch = new CountDownLatch(3);
	
	public static void process() {
		
		processPrerequisites();
		
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Main Thread continues!");
	}
	
	
	public static void processPrerequisites() {
		(new Thread(new Service4(latch))).start();
		(new Thread(new Service5(latch))).start();
		(new Thread(new Service6(latch))).start();
	}
	
	public static void main(String[] args) {
		process();
	}

}
