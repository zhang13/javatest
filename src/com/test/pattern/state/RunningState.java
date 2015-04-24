package com.test.pattern.state;

public class RunningState extends LiftState {

	@Override
	public void close() {
		// do nothing

	}

	@Override
	public void open() {
		// do nothing

	}

	@Override
	public void run() {
		System.out.println("电梯运行了！");

	}

	//运行后，可以停止
	@Override
	public void stop() {
		super.context.setLiftState(Context.stoppingState);
		super.context.getLiftState().stop();

	}

}
