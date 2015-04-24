package com.test.pattern.state;

public class CloseingState extends LiftState {

	@Override
	public void close() {
		System.out.println("电梯在关门了！");

	}

	//关门后当然可以打开
	@Override
	public void open() {
		super.context.setLiftState(Context.openningState);
		super.context.getLiftState().open();
	}

	//关门后可以运行了
	@Override
	public void run() {
		super.context.setLiftState(Context.runningState);
		super.context.getLiftState().run();

	}

	//相当于关门后，我一直不运行，大家都知道。
	@Override
	public void stop() {
		super.context.setLiftState(Context.stoppingState);
		super.context.getLiftState().stop();

	}

}
