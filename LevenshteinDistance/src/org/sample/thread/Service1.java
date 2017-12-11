package org.sample.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class Service1 implements Runnable {

	private AtomicInteger count;
	
	public Service1(AtomicInteger count)  {
		this.count = count;
	}

	@Override
	public void run() {
		System.out.println("service1...");
		count.incrementAndGet();
	}
}
