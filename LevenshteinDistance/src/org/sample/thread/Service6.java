package org.sample.thread;

import java.util.concurrent.CountDownLatch;

public class Service6 implements Runnable {

	private CountDownLatch latch;
	
	public Service6(CountDownLatch latch)  {
		this.latch = latch;
	}

	@Override
	public void run() {
		System.out.println("service6...");
		latch.countDown();
	}
}
