package com.test.thread.thisUsed;

public class ThreadUsedThis implements Runnable{

	Thread thisThread=null;
	
	@Override
	public void run() {
		System.out.println("run");
	}
	
	public void start(){
		thisThread=new Thread(this);
		thisThread.start();
	}
	
	public static void main(String[] args) {
		new ThreadUsedThis().start();
	}

}
