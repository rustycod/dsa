package org.sample.thread.misc;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReaderWriterSingleThreadExample {

	private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
	private Map<Integer, String> map = new HashMap<Integer, String>();
	

	public void put(Integer key, String value) {
		
		Lock writeLock = readWriteLock.writeLock();
		writeLock.lock();
		
		try {
			map.put(key, value);
		} finally {
			writeLock.unlock();
		}		
	}

	public String get(Integer key) {
		
		Lock readLock = readWriteLock.readLock();
		readLock.lock();
		
		System.out.println("activeCount: "+Thread.activeCount());
		System.out.println("Thread reading: "+key);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		try {
			return map.get(key);
			
		} finally {
			readLock.unlock();
			System.out.println("Thread reading done: "+key);
		}
		
	}
	
	
	public static void main(String[] args) {
		ReaderWriterSingleThreadExample obj = new ReaderWriterSingleThreadExample();
		for(int i = 1; i <= 10; i++) {
			obj.put(i, "value"+i);
		}
		
		for(int i = 1; i <= 10; i++) {
			obj.get(i);
		}
		
	}
}

