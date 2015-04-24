package com.test.thread.threadpool;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolTest {

	public static void main(String[] args) {
		ThreadPoolTest tp=new ThreadPoolTest();
		ExecutorService es = Executors.newFixedThreadPool(5);
		for(int i=0;i<10;i++){
			es.execute(tp.new newThread(i));
		}
		es.shutdown();
	}
	
	class newThread  extends Thread{
		private int i ;
		
		public newThread(int i) {
			this.i = i;
		}

		@Override
		public void run() {
			Random rd = new Random();
			int sleep=(rd.nextInt(10)+1)*1000;
			System.out.println("start_"+i+"_"+sleep);
			try {
				sleep(sleep);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("end_"+i+"_"+sleep);
		}
		
	}
}
