package org.sample.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class Service3 implements Runnable {

	private AtomicInteger count;
	
	public Service3(AtomicInteger count)  {
		this.count = count;
	}

	@Override
	public void run() {
		System.out.println("service3...");
		count.incrementAndGet();
	}
}
