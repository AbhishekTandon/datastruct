package com.tandon.java.concurrency;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class ExecutorServiceTest {

	static final int NUMBER_OF_THREAD = 2;
	static final int NUMBER_OF_TASK = 20;

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(NUMBER_OF_THREAD);
		ExchangerRunnable[] runnable = new ExchangerRunnable[NUMBER_OF_TASK];
		for (int i = 0; i < NUMBER_OF_TASK; i++) {
			runnable[i] = new ExchangerRunnable("Task-"+i);
			executorService.execute(runnable[i]);
		}

		executorService.shutdown();

	}

	static class ExchangerRunnable implements Runnable {

		private String taskName = null;

		public ExchangerRunnable(String name) {
			this.taskName = name;
		}

		public void run() {
			try {
				System.out.println(Thread.currentThread().getName() + " running task " + this.taskName);
				Thread.sleep(1000);

				System.out.println(Thread.currentThread().getName() + " completed task " + this.taskName);
			} catch (InterruptedException  ex) {
				ex.printStackTrace();;
			}
		}
	}

}
