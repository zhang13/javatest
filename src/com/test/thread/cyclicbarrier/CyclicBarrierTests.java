package com.test.thread.cyclicbarrier;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier在多有参与者都调用await方法之后一起执行。
 * @author 张超
 * 2012-7-26下午03:16:51
 *
 */
public class CyclicBarrierTests extends Thread {

	private String name;
	
	static CyclicBarrier oneCyclicBarrier ;
	public CyclicBarrierTests(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		Random rd = new Random();
		int sleepTime = (rd.nextInt(10)+1)*100;
		try {
			System.out.println(name+"_"+sleepTime);
			Thread.sleep(sleepTime);
			oneCyclicBarrier.await();
			System.out.println(name+"done"+System.currentTimeMillis());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		CyclicBarrierTests t1 = new CyclicBarrierTests("one");
		CyclicBarrierTests t2 = new CyclicBarrierTests("two");
		t1.start();
		t2.start();
		oneCyclicBarrier = new CyclicBarrier(2);
		
	}
}
