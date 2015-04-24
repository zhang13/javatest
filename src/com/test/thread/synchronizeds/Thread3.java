package com.test.thread.synchronizeds;

public class Thread3 {

	public static void main(String[] args) {
		final Thread3 t3 = new Thread3();  
		 Thread t1 = new Thread(  new Runnable() {  public void run() {  t3.m4t3();  }  }, "t1"  );  
         Thread t2 = new Thread(  new Runnable() {  public void run() { t3.m4t3();   }  }, "t2"  );  
         t1.start();  
         t2.start(); 
	}
	
    public synchronized void m4t3() {  
        int i = 5;  
        while( i-- > 0) {  
             System.out.println(Thread.currentThread().getName() + " : " + i);  
             try {  
                  Thread.sleep(500);  
             } catch (InterruptedException ie) {  
             }  
        }  
   }  
}
