package org.sample.thread.deadlock;

public class SampleClass2 {

	private SampleClass1 sc1;
	
	public synchronized void method1() {
		sc1.method1();
	}
	
	public void setSC1(SampleClass1 sc1) {
		this.sc1 = sc1;
	}

}
