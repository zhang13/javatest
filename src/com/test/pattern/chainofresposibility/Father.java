package com.test.pattern.chainofresposibility;

public class Father extends Handler {

	public Father(){
		super(1);
	}
	
	@Override
	public void response() {
		System.out.println("¸¸Ç×Í¬Òâ");
	}

}
