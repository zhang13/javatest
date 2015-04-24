package com.test.pattern.chainofresposibility;

public class Son extends Handler {

	protected Son() {
		super(3);
	}

	@Override
	public void response() {
		System.out.println("¶ù×ÓÍ¬Òâ");
	}

}
