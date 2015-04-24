package com.test.pattern.factorymethod;

public class WhiteHuman implements Human {

	@Override
	public void cry() {
		System.out.println("白人在哭");

	}

	@Override
	public void laugh() {
		System.out.println("白人在笑");

	}

	@Override
	public void talk() {
		System.out.println("白人在讲话");

	}

}
