package org.sample.thread.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReaderWriterExample {

	private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
	private Map<Integer, String> map = new HashMap<Integer, String>();
	

	public void put(Integer key, String value) {
		
		Lock writeLock = readWriteLock.writeLock();
		writeLock.lock();
		
		System.out.println("activeCount (write): "+Thread.activeCount());
		System.out.println("Thread writing: { "+key+", "+value+"}");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		try {
			map.put(key, value);
		} finally {
			System.out.println("Thread writing done: { "+key+", "+value+"}");
			writeLock.unlock();
		}		
	}

	public String get(Integer key) {
		
		Lock readLock = readWriteLock.readLock();
		readLock.lock();
		
		System.out.println("activeCount (read): "+Thread.activeCount());
		System.out.println("Thread reading: "+key);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		try {
			return map.get(key);
			
		} finally {
			System.out.println("Thread reading done: "+key);
			readLock.unlock();
		}
		
	}
	
	
	public static void main(String[] args) {
		ReaderWriterExample obj = new ReaderWriterExample();
		for(int i = 1; i <= 10; i++) {
			new Thread(new Writer(i, "value"+i, obj)).start();
		}
		
		for(int i = 1; i <= 5; i++) {
			new Thread(new Reader(i, obj)).start();
		}
		
		new Thread(new Writer(11, "value11", obj)).start();
		new Thread(new Writer(12, "value12", obj)).start();
		
		for(int i = 6; i <= 10; i++) {
			new Thread(new Reader(i, obj)).start();
		}
		
		new Thread(new Writer(13, "value13", obj)).start();
		
		for(int i = 11; i <= 13; i++) {
			new Thread(new Reader(i, obj)).start();
		}
		
		new Thread(new Writer(14, "value14", obj)).start();
		new Thread(new Writer(15, "value15", obj)).start();
		
		
		try {
			Thread.sleep(30000000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}


//Reader
class Reader implements Runnable {
	
	private int id;
	private ReaderWriterExample obj;
	
	public Reader(int i, ReaderWriterExample obj) {
		this.id = i;
		this.obj = obj;
	}

	@Override
	public void run() {
		obj.get(id);
	}
}


//Writer
class Writer implements Runnable {
	
	private int key;
	private String value;
	private ReaderWriterExample obj;
	
	public Writer(int key, String value, ReaderWriterExample obj) {
		this.key = key;
		this.value = value;
		this.obj = obj;
	}

	@Override
	public void run() {
		obj.put(key, value);
	}
}