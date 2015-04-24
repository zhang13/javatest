package com.test.volatiles;

import java.util.concurrent.CountDownLatch;

public class CheesyCounter {

	private volatile int value;

	public int getValue() {
		return value;
	}

	public synchronized int increment() {
		return value++;
	}

	public static void main(String[] args) {
		CountDownLatch cdl = new CountDownLatch(2);
		long begin = System.currentTimeMillis();
		CheesyCounter cheesyCounter = new CheesyCounter();
		new SubThread(cheesyCounter, cdl).start();
		new SubThread(cheesyCounter, cdl).start();

		try {
			cdl.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		System.out.println(end - begin);
	}
}

class SubThread extends Thread {
	private CheesyCounter cheesyCounter;
	CountDownLatch cdl;

	public SubThread(CheesyCounter cheesyCounter, CountDownLatch cdl) {
		this.cheesyCounter = cheesyCounter;
		this.cdl = cdl;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10000; i++) {
			cheesyCounter.increment();
			System.out.println(Thread.currentThread().getName() + "@"
					+ cheesyCounter.getValue());
		}
		cdl.countDown();
	}
}
