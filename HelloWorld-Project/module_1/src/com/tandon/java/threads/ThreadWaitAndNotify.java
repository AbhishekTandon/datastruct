package com.tandon.java.threads;

public class ThreadWaitAndNotify {
	public static void main(String[] args){
		String lock =  "lck";
		ThreadB b = new ThreadB(lock);


		synchronized(lock){
			try{
				System.out.println("Waiting for b to complete...");
				b.start();
				lock.wait();
			}catch(InterruptedException e){
				e.printStackTrace();
			}

			System.out.println("Total is: " + b.total);
		}
	}
}

class ThreadB extends Thread{

	String lock;

	ThreadB(String lock) {
		this.lock = lock;
	}

	int total;
	@Override
	public void run(){
		synchronized(lock){
			System.out.println("Running Thread B" );
			for(int i=0; i<100 ; i++){
				total += i;
			}

			System.out.println("Calling notify on lock" );
			lock.notify();
		}
	}
}