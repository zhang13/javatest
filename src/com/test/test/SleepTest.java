package com.test.test;

public class SleepTest {

	public static void main(String[] args) {
		System.out.println("begin");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("end");
	}
}
