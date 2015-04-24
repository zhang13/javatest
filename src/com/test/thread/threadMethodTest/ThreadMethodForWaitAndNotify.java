package com.test.thread.threadMethodTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * wait/notify方式
 * @author 张超
 * 2012-7-26下午05:10:45
 *
 */
public class ThreadMethodForWaitAndNotify {

	public static void main(String[] args) {
		ThreadMethodForWaitAndNotify t = new ThreadMethodForWaitAndNotify();
		// 创建并发访问的账户
		MyCountTest myCount = new MyCountTest("95599200901215522", 100);
		// 创建一个线程池
		ExecutorService pool = Executors.newFixedThreadPool(2);
		Thread t1 = new SaveThreadTest("张三", myCount, 2000);
		Thread t2 = new SaveThreadTest("李四", myCount, 100);
		Thread t3 = new DrawThreadTest("王五", myCount, 2700);
		Thread t4 = new SaveThreadTest("老张", myCount, 600);
		Thread t5 = new SaveThreadTest("老牛", myCount, 4000);
		Thread t6 = new DrawThreadTest("胖子", myCount, 800);
		// 执行各个线程
		pool.execute(t1);
		pool.execute(t2);
		pool.execute(t3);
		pool.execute(t4);
		pool.execute(t5);
		pool.execute(t6);
		// 关闭线程池
		pool.shutdown();
	}
}

/**
 * 存款线程类
 */
class SaveThreadTest extends Thread {
	private String name; // 操作人
	protected MyCountTest myCount; // 账户
	private int x; // 存款金额

	SaveThreadTest(String name, MyCountTest myCount, int x) {
		this.name = name;
		this.myCount = myCount;
		this.x = x;
	}

	public void run() {
		myCount.saving(x, name);
	}
}

/**
 * 取款线程类
 */
class DrawThreadTest extends Thread {
	private String name; // 操作人
	private MyCountTest myCount; // 账户
	private int x; // 存款金额

	DrawThreadTest(String name, MyCountTest myCount, int x) {
		this.name = name;
		this.myCount = myCount;
		this.x = x;
	}

	public void run() {
		myCount.drawing(x, name);
	}
}

/**
 * 普通银行账户，不可透支
 */
class MyCountTest {
	private String oid; // 账号
	private int cash; // 账户余额

	MyCountTest(String oid, int cash) {
		this.oid = oid;
		this.cash = cash;
	}

	/**
	 * 存款
	 * 
	 * @param x
	 *            操作金额
	 * @param name
	 *            操作人
	 */
	public synchronized void saving(int x, String name) {
		if (x > 0) {
			cash += x; // 存款
			System.out.println(name + "存款" + x + "，当前余额为" + cash);
		}
		notifyAll(); // 唤醒所有等待线程。
	}

	/**
	 * 取款
	 * 
	 * @param x
	 *            操作金额
	 * @param name
	 *            操作人
	 */
	public synchronized void drawing(int x, String name) {
		while(cash - x < 0) {
			try {
				System.out.println(name+"取款失败，余额不足！");
				wait();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		} 
		cash -= x; // 取款
		System.out.println(name + "取款" + x + "，当前余额为" + cash);
		notifyAll(); // 唤醒所有存款操作
	}
}