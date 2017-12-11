package org.sample.thread.barrier.iterative;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class WorkerIterative implements Runnable {
	
	private CyclicBarrier barrier;
	private int id;
	
	public WorkerIterative(CyclicBarrier barrier, int id) {
		this.barrier = barrier;
		this.id = id;
	}
	
	
	@Override
	public void run() {
		try {
			Thread.sleep(id*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		try {
			System.out.println("Worker("+id+") before barrier");
			barrier.await();
			System.out.println("Worker("+id+") after barrier");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}
		
	}

}
