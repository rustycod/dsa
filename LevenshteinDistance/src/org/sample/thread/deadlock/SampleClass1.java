package org.sample.thread.deadlock;

public class SampleClass1 {
	
	private SampleClass2 sc2;
	
	public synchronized void method1() {
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		sc2.method1();
	}
	
	public void setSC2(SampleClass2 sc2) {
		this.sc2 = sc2;
	}
	
	public static void main(String[] args) {
		SampleClass1 sc1 = new SampleClass1();
		SampleClass2 sc2 = new SampleClass2();
		
		sc1.setSC2(sc2);
		sc2.setSC1(sc1);
		
		sc1.method1();
		sc2.method1();
		
	}

}
