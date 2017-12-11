package org.sample.thread.exchanger;

import java.util.concurrent.Exchanger;

public class Worker implements Runnable{

	private Exchanger<String> exchanger;
	private int id;
	private String value;
	
	public Worker(Exchanger<String> exchanger, int id, String value) {
		this.exchanger = exchanger;
		this.id = id;
		this.value = value;
	}
	
	@Override
	public void run() {

		System.out.println("Worker("+id+"): original value: "+value);
		try {
			value = exchanger.exchange(value);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Worker("+id+"): new value: "+value);
		
	}
}
