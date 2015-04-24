package com.test.pattern.LSP;

public class HandGun extends AbstractGun {

	@Override
	public void shoot() {
		System.out.println("手枪开始射击了");

	}

	@Override
	public void shape() {
		System.out.println("手枪的形状！！");
		
	}

}
