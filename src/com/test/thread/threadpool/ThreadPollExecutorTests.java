package com.test.thread.threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
/**
 * 
 * @author ÕÅ³¬
 *
 * Jan 6, 2014
 */
public class ThreadPollExecutorTests {

	public static void main(String[] args) throws Exception {
		ThreadPollExecutorTests t = new ThreadPollExecutorTests();
		List<Task> tasks = new ArrayList<Task>();
		Random rand = new Random(47);
		for(int i =0;i<10;i++){
			tasks.add(t.new Task(i,rand.nextInt(10)*100));
		}
		long beforeMillis = System.currentTimeMillis();
		ExecutorService service = Executors.newCachedThreadPool();
		List<Future<String>> list = service.invokeAll(tasks);
		for(Future<String> future : list){
			System.out.println(future.get());
		}
		long afterMillis = System.currentTimeMillis();
		System.out.println((afterMillis-beforeMillis));
		//System.out.println("invokeAny£º"+service.invokeAny(tasks));

		service.shutdown();
	}
	
	class Task implements Callable<String>{

		private int delayTime;
		private int i;
		private Task(int i,int delayTime) {
			this.i=i;
			this.delayTime=delayTime;
		}

		@Override
		public String call() throws Exception {
			Thread.sleep(delayTime);
			return "µÚ"+i+"¸öÑÓ³Ù£º"+delayTime;
		}
		
	}
}
