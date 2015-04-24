package com.test.thread.synchronizeds;

public class Thread2 {  
    public void m4t1() {  
         synchronized(this) {  
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
    public void m4t2() {  
         int i = 5;  
         while( i-- > 0) {  
              System.out.println(Thread.currentThread().getName() + " : " + i);  
              try {  
                   Thread.sleep(500);  
              } catch (InterruptedException ie) {  
              }  
         }  
    }  
    public static void main(String[] args) {  
         final Thread2 myt2 = new Thread2();  
         Thread t1 = new Thread(  new Runnable() {  public void run() {  myt2.m4t1();  }  }, "t1"  );  
         Thread t2 = new Thread(  new Runnable() {  public void run() { myt2.m4t2();   }  }, "t2"  );  
         t1.start();  
         t2.start();  
    }
}/*output:
t2 : 4
t1 : 4
t1 : 3
t2 : 3
t2 : 2
t1 : 2
t2 : 1
t1 : 1
t2 : 0
t1 : 0 *///:~