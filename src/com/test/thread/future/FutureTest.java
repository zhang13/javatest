package com.test.thread.future;

import static org.junit.Assert.*;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.Callable;

import org.junit.Test;


/**
 * 当另外一个线程需要使用某一个线程的结果时，可以通过Future引用的get()方法去获得，
 * 如果结果还未出来，调用此方法的线程被block，直到结果出来。
 * 如下例子，在示例中，如果超时了，那么就不会执行assertEquals(i, future.get(500,TimeUnit.MILLISECONDS));
 * 直到future.get(500,TimeUnit.MILLISECONDS)有了结果，才继续执行此线程。其他线程则继续执行。
 * @author 张超  
 * 2012-7-25下午05:18:54
 *
 */
public class FutureTest {

	@Test
	public void checkThreadIsDone(){
		ExecutorService es = Executors.newCachedThreadPool();
		Future<?> future=null;
		for(int i=1;i<10;i++){
			int timeOut = new Random().nextInt(10)*100;
			future = es.submit(new FutureTest().new ReturnResultThread(i,timeOut));
			try {
				assertEquals(i, future.get(500,TimeUnit.MILLISECONDS));
				System.out.println(i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			} catch (TimeoutException e) {
				boolean result = timeOut-500>0?true:false;
				assertTrue(result);
				System.out.println(i+" outTime");
			}
		}
		
		System.out.println("mainThread");
		
	}
	
class ReturnResultThread implements Callable<Object>{

	private int num;
	private int timeOut;
	public ReturnResultThread(int num, int timeOut) {
		this.num = num;
		this.timeOut = timeOut;
	}

	@Override
	public Object call() throws Exception {
		Thread.sleep(timeOut);
		System.out.println(num+" is done "+timeOut);
		return num;
	}

	
}
	
	
}
