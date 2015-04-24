package com.test.pattern.templatemethod;

public class HummerModel1 extends Template {
	private boolean isAlarm = true;

	@Override
	protected boolean isAlarm() {
		return isAlarm;
	}

	//就看是否需要可以在外部设置了，如果需要就添加一个set方法。
	public void setAlarm(boolean isAlarm){
		this.isAlarm = isAlarm;
	}

	@Override
	protected void alarm() {
		System.out.println("HummerModel悍马车叫了");

	}

	@Override
	protected void start() {
		System.out.println("HummerModel悍马车启动了");

	}

	@Override
	protected void stop() {
		System.out.println("HummerModel悍马车停止了");

	}

}
