package org.sample.thread.executor;

import java.util.concurrent.Callable;

public class Square implements Callable<Integer> {

	private int val;
	
	public Square(int val) {
		this.val = val;
	}

	@Override
	public Integer call() throws Exception {
		Thread.sleep(val*1000);
		return val * val;
	}
	
	
}
