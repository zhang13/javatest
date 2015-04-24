package com.test.pattern.templatemethod;

public class HummerModel2 extends Template {

	@Override
	protected boolean isAlarm() {

		return false;
	}

	@Override
	protected void alarm() {
		System.out.println("HummerMode2悍马车叫了");

	}

	@Override
	protected void start() {
		System.out.println("HummerMode2悍马车启动了");

	}

	@Override
	protected void stop() {
		System.out.println("HummerMode2悍马车停止了");

	}

}
