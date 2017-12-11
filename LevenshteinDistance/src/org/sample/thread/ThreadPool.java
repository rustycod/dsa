package org.sample.thread;

import java.util.concurrent.LinkedBlockingQueue;

public class ThreadPool {
    
	private final int nThreads;
    private final PoolWorker[] threads;
    private final LinkedBlockingQueue<Integer> queue;

    public ThreadPool(int numThreads) {
        
    	this.nThreads = numThreads;
        queue = new LinkedBlockingQueue<Integer>();
        threads = new PoolWorker[nThreads];

        for (int i = 0; i < nThreads; i++) {
            threads[i] = new PoolWorker(i);
            threads[i].start();
        }
    }

    public void execute(int id) {
        synchronized (queue) {
            queue.add(id);
            System.out.println("Producer: "+id);
            queue.notify();
        }
    }

    
    // worker thread
    private class PoolWorker extends Thread {
    	
    	private int id;
    	
    	public PoolWorker(int poolWorkerID) {
    		this.id = poolWorkerID;
    	}
    	
        public void run() {
        	
        	System.out.println("Worker("+id+") started!");
            int itemId;

            while (true) {
                synchronized (queue) {
                    while (queue.isEmpty()) {
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            System.out.println("An error occurred while queue is waiting: " + e.getMessage());
                        }
                    }
                    itemId = queue.poll();
                    System.out.println("Worker("+id+"): "+itemId);
                    
                    try {
						Thread.currentThread().sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                }
            }
        }
    }
    
    
    public static void main(String[] args) {
    	ThreadPool tp = new ThreadPool(5);
    	
    	for(int i = 1; i <= 100; i++) {
    		tp.execute(i);
    	}
    }
}
