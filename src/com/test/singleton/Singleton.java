package com.test.singleton;

public class Singleton {

	private static Singleton instance = null;

	public static synchronized Singleton getSingleton() {
		if(instance==null){
			instance=new Singleton();
		}
		return instance;
	}
	
	public static void main(String[] args) {
		for(int i=0;i<10;i++){
			new Thread(){

				@Override
				public void run() {
					System.out.println(getSingleton());
				}
				
			}.start();
		}
	}
}
