package com.test.pattern.state;

public class OpeningState extends LiftState {

	//在开启后，门是可以关闭的。
	@Override
	public void close() {
		super.context.setLiftState(Context.closeingState);
		super.context.getLiftState().close();

	}

	@Override
	public void open() {
		System.out.println("电梯门开启！");

	}

	@Override
	public void run() {
		// do nothing!

	}

	@Override
	public void stop() {
		// do nothing!

	}

}
