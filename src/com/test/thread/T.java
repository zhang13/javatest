package com.test.thread;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class T {
	private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	private static ThreadLocal<DateFormat> threadLocal = new ThreadLocal<DateFormat>();

	public static DateFormat getSimpleDateFormat() {
		DateFormat sdf = threadLocal.get();
		if (sdf == null) {
			System.out.println("--------");
			sdf = new SimpleDateFormat(DATE_FORMAT);
			threadLocal.set(sdf);
		}
		return sdf;
	}

	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				System.out.println("t1:" + getSimpleDateFormat());
			}
		});
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				System.out.println("t2:" + getSimpleDateFormat());
			}
		});
		t1.start();
		t2.start();
	}
}