package org.sample.thread;

public class ProducerConsumerWaitNotifyStandard {

	public static void start() {
		
		CommonObject CommonObject = new CommonObject();
		ProducerStandard producer1 = new ProducerStandard(CommonObject);
		ConsumerStandard consumer1 = new ConsumerStandard(CommonObject);
		
		Thread p1 = new Thread(producer1);
		p1.setName("Producer1");
		p1.start();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		Thread c1 = new Thread(consumer1);
		c1.setName("consumer1");
		c1.start();
		
	}
	
	public static void main (String[] args) {
		start();
	}
		
}


// common object
class CommonObject {
	
	private boolean occupied = false; // it's not occupied initially
	private int value = 0;
	
	public synchronized int get() {
		while(occupied == false) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		occupied = false;
		notifyAll();
		return value;			
	}
	
	public synchronized void set(int value) {
		while(occupied == true) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		occupied = true;
		this.value = value;
		notifyAll();
	}
}


// producer
class ProducerStandard implements Runnable {
	
	private CommonObject commonObject;
	
	ProducerStandard(CommonObject commonObject) {
		this.commonObject = commonObject;
	}
	
	@Override
	public void run() {
		for(int i = 1; i <= 10; i++) {
			commonObject.set(i);
			System.out.println("Producer has put "+i);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}


// consumer
class ConsumerStandard implements Runnable {
	
	private CommonObject commonObject;
	
	ConsumerStandard(CommonObject commonObject) {
		this.commonObject = commonObject;
	}
	
	@Override
	public void run() {
		for(int i = 1; i <= 10; i++) {
			System.out.println("Consumer has picked: "+commonObject.get());
		}
		
	}
	
}