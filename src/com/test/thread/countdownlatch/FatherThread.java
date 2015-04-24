package com.test.thread.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * 用作主线程等待多有子线程执行到某处
 * @author 张超
 *
 * Apr 18, 2013
 */
public class FatherThread implements Runnable{

	private int LOOP_SIZE=5;
	final CountDownLatch threadSize = new CountDownLatch(LOOP_SIZE);
	
	@Override
	public void run() {
		excute();
		try {
			threadSize.await();//如果没有等待，那么就直接结束了，体现不出子线程等待的5秒。
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("执行结束了");
	}


	private void excute() {
		for(int i =LOOP_SIZE;i>0;i--){
			Thread childThread = new Thread(i+""){

				@Override
				public void run() {
					System.out.println("子线程方法执行----"+this.getName());
					try {
						Thread.sleep(5000);//为了体现效果，我在这里让子线程睡了5秒。
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					threadSize.countDown();
				}
			};
			childThread.start();
			System.out.println("子线程开始了----"+childThread.getName());
		}
	}

	public static void main(String[] args) {
		FatherThread ft = new FatherThread();
		new Thread(ft).start();
	}
	
	
	
	
}
