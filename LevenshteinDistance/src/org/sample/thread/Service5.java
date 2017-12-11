package org.sample.thread;

import java.util.concurrent.CountDownLatch;

public class Service5 implements Runnable {

	private CountDownLatch latch;
	
	public Service5(CountDownLatch latch)  {
		this.latch = latch;
	}

	@Override
	public void run() {
		System.out.println("service5...");
		latch.countDown();
	}
}
