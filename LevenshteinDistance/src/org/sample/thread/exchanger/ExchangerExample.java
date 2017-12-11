package org.sample.thread.exchanger;

import java.util.concurrent.Exchanger;

public class ExchangerExample {

	public static void process() {
		Exchanger<String> exchanger = new Exchanger<String>();
		
		(new Thread(new Worker(exchanger, 1, "A"))).start();
		(new Thread(new Worker(exchanger, 2, "B"))).start();
		
	}
	
	public static void main(String[] args) {
		process();
	}
	
}
