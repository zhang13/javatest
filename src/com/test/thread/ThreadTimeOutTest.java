package com.test.thread;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeoutException;

public class ThreadTimeOutTest {

	public static void main(String[] args) {
		ThreadTimeOutTest tt = new ThreadTimeOutTest();
		final Test t = tt.new Test();
		t.start();
		TimeoutException te = new TimeoutException();
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	class Test extends Thread{
		@Override
		public void run() {
			System.out.println("11111111111");
			new Timer().schedule(new TimerTask() {
				@Override
				public void run() {
					throw new RuntimeException();
				}
			}, 3000);
		}
	}
}
