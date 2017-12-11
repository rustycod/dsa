package org.sample.thread.atomic;

import java.util.concurrent.atomic.AtomicInteger;

// it'll count the number of times the method was processed in multi-threaded environment
public class HitCounter {

	private AtomicInteger count = new AtomicInteger(0);
	
	public void process() {
		count.incrementAndGet();
	}
	
	public static void main(String[] args) {
		HitCounter hitCounter = new HitCounter();
		
		hitCounter.process();
		
		for(int i = 1; i <= 10; i++) {
			new Thread(new RequestThread(hitCounter)).start();
		}
		
		hitCounter.process();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		hitCounter.process();
		
		System.out.println("Final Count: "+hitCounter.count);
	}



}





// RequestThread
class RequestThread implements Runnable {

	private HitCounter hitCounter;
	
	public RequestThread(HitCounter hitCounter) {
		this.hitCounter = hitCounter;
	}
	
	@Override
	public void run() {
		hitCounter.process();
	}
	
}