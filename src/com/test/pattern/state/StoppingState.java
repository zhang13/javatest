package com.test.pattern.state;

public class StoppingState extends LiftState {

	@Override
	public void close() {
		// do nothing

	}

	//停止后，可以开门了
	@Override
	public void open() {
		super.context.setLiftState(Context.openningState);
		super.context.getLiftState().open();
	}

	//停止后，继续运行
	@Override
	public void run() {
		super.context.setLiftState(Context.runningState);
		super.context.getLiftState().run();
	}

	@Override
	public void stop() {
		System.out.println("电梯停止了！");

	}

}
