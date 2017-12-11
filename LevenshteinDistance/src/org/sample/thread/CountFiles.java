package org.sample.thread;

import java.io.File;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public class CountFiles {
	

	private AtomicInteger countWorkers = new AtomicInteger(0);
	
	public void listFiles(String rootFolderPath) {

		ExecutorService executorService = Executors.newFixedThreadPool(5);
		CompletionService<Integer> completionService = new ExecutorCompletionService<Integer>(executorService);
		
		Worker worker = new Worker(rootFolderPath, completionService, countWorkers);
		completionService.submit(worker);
		countWorkers.incrementAndGet();
		
		int countFiles = 0;
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		for(int i = 1; i >= Integer.MIN_VALUE; i++) {
		//while(countWorkers.intValue() > 0) {
			try {
				Future<Integer> future = completionService.take();
				System.out.println("output: "+future.get());
				countFiles += future.get();
				countWorkers.decrementAndGet();
				System.out.println("current countWorkers: "+countWorkers.intValue());
				System.out.println("current countFiles: "+countFiles);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}			
		}

		System.out.println("Total files: "+countFiles);
		executorService.shutdown();
	}


	public static void main(String[] args) {
		CountFiles obj = new CountFiles();
		obj.listFiles("C:\\Backup\\Naveen\\P\\Books\\Hadoop");
	}

}

class Worker implements Callable<Integer> {

	private String folderPath;
	private CompletionService<Integer> completionService;
	private AtomicInteger countWorkers;
	
	Worker(String folderPath, CompletionService<Integer> completionService, AtomicInteger countWorkers) {
		this.folderPath = folderPath;
		this.completionService = completionService;
		this.countWorkers = countWorkers;
	}

	@Override
	public Integer call() throws Exception {

		int countFiles = 0;
		
		File folder = new File(folderPath);
		File[] listOfFiles = folder.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				System.out.println("File " + listOfFiles[i].getName());
				countFiles++;
			} else if (listOfFiles[i].isDirectory()) {
				// start new thread
				//System.out.println("Directory " + listOfFiles[i].getName());
				//System.out.println("Directory Path: " + listOfFiles[i].getAbsolutePath());
				//listFiles(listOfFiles[i].getAbsolutePath());
				
				Worker worker = new Worker(listOfFiles[i].getAbsolutePath(), completionService, countWorkers);
				completionService.submit(worker);
				countWorkers.incrementAndGet();
			}
		}
		
		return countFiles;
	}


}
