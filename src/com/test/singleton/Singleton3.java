package com.test.singleton;

public class Singleton3 {

	private volatile static Singleton3 singleton;
	
	private Singleton3(){
		
	}
	public static Singleton3 getInstance(){
		if(singleton==null){
			synchronized (Singleton3.class) {
				if(singleton==null){
					singleton = new  Singleton3();
				}
			}
		}
		return singleton;
	}
	
	public static void main(String[] args) {
		for(int i=0;i<10;i++){
			new Thread(){

				@Override
				public void run() {
					System.out.println(getInstance());
				}
				
			}.start();
		}
	}
}
