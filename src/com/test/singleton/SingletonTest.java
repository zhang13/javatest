package com.test.singleton;

public class SingletonTest {

	private static SingletonTest instance = new SingletonTest();
	
	public static SingletonTest getInstance(){
		return instance;
	}
	
	public static void test(){
		System.out.println(instance);
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
