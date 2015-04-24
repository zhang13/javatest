package com.test.thread.future;

import java.util.concurrent.Callable;

public class ReturnResultThread implements Callable<Object>{

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
