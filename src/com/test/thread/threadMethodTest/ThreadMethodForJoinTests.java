package com.test.thread.threadMethodTest;


public class ThreadMethodForJoinTests {
	
	
	public ThreadMethodForJoinTests() {
	}

	class ThreadTestForJoinMethod extends Thread{
		@Override
		public void run() {
			for(int i=1;i<10;i++){
				try {
					sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(i);
			}
		}
	}
	
	public static void main(String[] args) {
		ThreadTestForJoinMethod t = new ThreadMethodForJoinTests().new ThreadTestForJoinMethod();
		t.start();
		try {
			//t.join();//一直等待线程t执行完成，才继续执行主线程。
			t.join(3000);//等待3秒，不管线程t有没有执行完，都继续执行主线程。
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("main thread is done!");
	}

}
