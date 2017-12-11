package org.sample.thread;

import java.util.concurrent.CountDownLatch;

public class Service4 implements Runnable {

	private CountDownLatch latch;
	
	public Service4(CountDownLatch latch)  {
		this.latch = latch;
	}

	@Override
	public void run() {
		System.out.println("service4...");
		latch.countDown();
	}
}
