package com.test.memory;

import java.util.concurrent.CountDownLatch;

public class TestNativeOutOfMemoryError {

	public static void main(String[] args) {

		//Runtime Runtime = Runtime.getRuntime();
		System.out.println(Runtime.getRuntime().freeMemory()/1024);
		System.out.println(Runtime.getRuntime().maxMemory());
		System.out.println(Runtime.getRuntime().totalMemory());
		
		for (int i = 0;; i++) {
			System.out.println("i = " + i);
			new Thread(new HoldThread()).start();
//			System.out.println(Runtime.getRuntime().freeMemory());
//			System.out.println(Runtime.getRuntime().maxMemory());
//			System.out.println(Runtime.getRuntime().totalMemory());
			//System.out.println(findAllThreads().length);
			//System.out.println(Thread.getAllStackTraces().size());
		}
		
	}
	
	public static Thread[] findAllThreads() {
		ThreadGroup group = Thread.currentThread().getThreadGroup();
		ThreadGroup topGroup = group;
		// traverse the ThreadGroup tree to the top
		while (group != null) {
			topGroup = group;
			group = group.getParent();
		}
		// Create a destination array that is about
		// twice as big as needed to be very confident
		// that none are clipped.
		int estimatedSize = topGroup.activeCount() * 2;
		Thread[] slackList = new Thread[estimatedSize];
		// Load the thread references into the oversized
		// array. The actual number of threads loaded
		// is returned.
		int actualSize = topGroup.enumerate(slackList);
		// copy into a list that is the exact size
		Thread[] list = new Thread[actualSize];
		System.arraycopy(slackList, 0, list, 0, actualSize);
		return list;
	}

}

class HoldThread extends Thread {
	CountDownLatch cdl = new CountDownLatch(1);

	public HoldThread() {
		this.setDaemon(true);
	}

	public void run() {
		try {
			cdl.await();
		} catch (InterruptedException e) {
		}
	}
}