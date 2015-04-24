package com.test.pattern.abstractfactory;

public abstract class AbstractYellowHuman implements Human {

	@Override
	public void cry() {
		System.out.println("黄色人会哭");

	}

	@Override
	public void laugh() {
		System.out.println("黄色人会大笑");

	}

	@Override
	public void talk() {
		System.out.println("黄色人会讲话");

	}
}
