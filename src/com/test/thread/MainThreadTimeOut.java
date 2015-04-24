package com.test.thread;

public class MainThreadTimeOut {

	public static void main(String[] args) {
		
		TimeOutThread t = new TimeOutThread(5000,new TimeOutException("超时"));
		try{
			t.start();
			//.....要检测超时的程序段....
			try {
				Thread.sleep(6000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			t.cancel();
		}catch (TimeOutException e)
		{
			//...对超时的处理...
			System.out.println(e.getMessage());
		}
	}

}
