package org.sample.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class Service2 implements Runnable {

	private AtomicInteger count;
	
	public Service2(AtomicInteger count)  {
		this.count = count;
	}

	@Override
	public void run() {
		System.out.println("service2...");
		count.incrementAndGet();
	}
}
