package com.test.pattern.chainofresposibility;

public class Client {

	public static void main(String[] args) {
		IWomen women1 = new Women(1);
		IWomen women2 = new Women(2);
		IWomen women3 = new Women(3);
		
		Handler father = new Father();
		Handler husband = new Husband();
		Handler son = new Son();
		
		father.setNextHandler(husband);
		husband.setNextHandler(son);
		
		father.handlerMessage(women1);
		father.handlerMessage(women2);
		father.handlerMessage(women3);

	}

}
