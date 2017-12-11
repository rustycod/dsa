package org.sample.thread.barrier;

import java.util.concurrent.CyclicBarrier;

public class BarrierExample {

	public static void process() {
		
		int count = 4;
		CyclicBarrier barrier = new CyclicBarrier(count);
		
		for(int i = 1; i <= count; i++) {
			new Thread(new Worker(barrier, i)).start();
		}
		
	}
	
	public static void main(String[] args) {
		process();
	}
}
