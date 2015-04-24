package com.test.pattern.chainofresposibility;

public abstract class Handler {

	private int level;
	private Handler nextHandler;

	protected Handler(int level) {
		this.level = level;
	}

	protected void setNextHandler(Handler handler) {
		this.nextHandler = handler;
	}

	public void handlerMessage(IWomen women) {
		if (women.getType() == this.level) {
			this.response();
		}else{
			if(this.nextHandler!=null){
				this.nextHandler.handlerMessage(women);
			}else{
				System.out.println("nothing to do~~~~~~~~~~~!");
			}
		}
	}

	public abstract void response();
}
