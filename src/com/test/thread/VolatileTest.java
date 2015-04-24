package com.test.thread;

public class VolatileTest extends Thread{

	private static volatile int n = 0;

	public void run() {
		for (int i = 0; i < 10; i++)
			try {
				inc();
				sleep(3); // 为了使运行结果更随机，延迟3毫秒

			} catch (Exception e) {
		}
	}

	private static synchronized void inc(){//不加static就不行??why???
		n++;
	}
	
	public static void main(String[] args) throws Exception {

		Thread threads[] = new Thread[100];
		for (int i = 0; i < threads.length; i++)
			// 建立100个线程
			threads[i] = new VolatileTest();
		for (int i = 0; i < threads.length; i++)
			// 运行刚才建立的100个线程
			threads[i].start();
		for (int i = 0; i < threads.length; i++)
			// 100个线程都执行完后继续
			threads[i].join();
		
		System.out.println(VolatileTest.n);
		
	}
}
