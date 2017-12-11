package org.sample.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class CountdownAtomicInteger {

	public static AtomicInteger count = new AtomicInteger(0);
	
	public static void process() {
		
		processPrerequisites();
		
		while(count.get() != 3) {
			System.out.println("Main Thread waiting!");
		}
		
		System.out.println("main thread continues now!");
	}
	
	
	public static void processPrerequisites() {
		(new Thread(new Service1(count))).start();
		(new Thread(new Service2(count))).start();
		(new Thread(new Service3(count))).start();
	}
	
	public static void main(String[] args) {
		process();
	}
	
	
}
