package com.test.thread;

class Lock {
}

public class HoldsLockTests {
	static Lock lock = new Lock();

	public static void main(String args[]) throws InterruptedException {
		HoldsLockTests thl = new HoldsLockTests();

		thl.check();
		synchronized (lock) {
			thl.check();
		}
		thl.check();
	}

	public void check() {
		Thread this_thread = Thread.currentThread();
		System.out.println(this_thread.holdsLock(lock));
	}
}
