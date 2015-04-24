package com.test.pattern.state;
/**
 * 电梯的状态接口(一般5个以内的状态可以用状态模式，如果状态太多会导致子类疯涨，会疯掉哦！)
 * @author 张超
 * 2012-8-2下午02:03:35
 *
 */
public abstract class LiftState {
	
	//封装电梯状态变更引起的功能变化
	protected Context context;

	public void setContext(Context context) {
		this.context = context;
	}
	
	public abstract void open();

	public abstract void close();

	public abstract void run();

	public abstract void stop();
}
