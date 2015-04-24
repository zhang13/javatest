package com.test.pattern.LSP;

public class Rifle extends AbstractGun {

	@Override
	public void shoot() {
		System.out.println("步枪开始射击了");

	}

	@Override
	public void shape() {
		System.out.println("步枪的形状！！");
		
	}

}
