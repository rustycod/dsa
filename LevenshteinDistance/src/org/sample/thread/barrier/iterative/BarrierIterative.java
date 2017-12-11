package org.sample.thread.barrier.iterative;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class BarrierIterative {

	public static void process() {
		
		Runnable shipmentMessage = new Runnable() {
			public void run() {
				System.out.println("Product Shipment Done!!!");
			}
		};
		
		CyclicBarrier barrier = new CyclicBarrier(3, shipmentMessage);
		
		(new Thread(new Product(barrier))).start();
		(new Thread(new Wrapper(barrier))).start();
		(new Thread(new Ship(barrier))).start();
	}
	
	
	public static void main(String[] args) {
		process();
	}
	
}


class Ship implements Runnable {

	private List<Integer> addressIDs = new ArrayList<Integer>();;
	private CyclicBarrier barrier;
	
	Ship(CyclicBarrier barrier) {
		addressIDs.add(1);addressIDs.add(2);addressIDs.add(3);addressIDs.add(4);
		this.barrier = barrier; 
	}
	
	
	@Override
	public void run() {
		int totalAddresses = addressIDs.size();
		
		int count = 1;
		while(count <= totalAddresses) {
		
			System.out.println("Ship to address("+count+")");
			
			try {
				barrier.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				e.printStackTrace();
			}
			
			count++;
		}
	}
}


class Product implements Runnable {

	private List<Integer> productIDs = new ArrayList<Integer>();
	private CyclicBarrier barrier;
	
	Product(CyclicBarrier barrier) {
		productIDs.add(1);productIDs.add(2);productIDs.add(3);productIDs.add(4);
		this.barrier = barrier; 
	}
	
	
	@Override
	public void run() {
		int totalProducts = productIDs.size();
		
		int count = 1;
		while(count <= totalProducts) {
		
			System.out.println("Get the Product("+count+")");
			
			try {
				barrier.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				e.printStackTrace();
			}
			
			count++;
		}
	}
}


class Wrapper implements Runnable {

	private List<Integer> wrapperIDs = new ArrayList<Integer>();;
	private CyclicBarrier barrier;
	
	Wrapper(CyclicBarrier barrier) {
		wrapperIDs.add(1);wrapperIDs.add(2);wrapperIDs.add(3);wrapperIDs.add(4);
		this.barrier = barrier; 
	}
	
	
	@Override
	public void run() {
		int totalWrappers = wrapperIDs.size();
		
		int count = 1;
		while(count <= totalWrappers) {
		
			System.out.println("Package with wrapper("+count+")");
			
			try {
				barrier.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				e.printStackTrace();
			}
			
			count++;
		}
	}
}