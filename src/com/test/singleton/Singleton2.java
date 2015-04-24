package com.test.singleton;

public class Singleton2 {

	private static class InstanceHolder {
		public static final Singleton2 instance = new Singleton2();
	}

	public static Singleton2 getInstance() {
		return InstanceHolder.instance;
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
