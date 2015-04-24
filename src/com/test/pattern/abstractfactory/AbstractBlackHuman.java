package com.test.pattern.abstractfactory;

public abstract class AbstractBlackHuman implements Human {

	@Override
	public void cry() {
		System.out.println("黑色人会哭");

	}

	@Override
	public void laugh() {
		System.out.println("黑色人会笑");

	}

	@Override
	public void talk() {
		System.out.println("黑色人会讲话");
	}

}
