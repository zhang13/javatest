package com.test.pattern.chainofresposibility;

public class Husband extends Handler {

	protected Husband() {
		super(2);
	}

	@Override
	public void response() {
		System.out.println("ÕÉ·òÍ¬Òâ");

	}

}
