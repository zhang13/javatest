package com.jdk8.interfaces;

public class DefaultInterfaceImpl implements DefaultInterface {

	@Override
	public double calculate(int a) {
		return sqrt(a);
	}

	@Override
	public double sqrt(int a) {
		System.out.println(" µœ÷¿‡");
		return DefaultInterface.super.sqrt(a);
	}
	
	public static void main(String[] args) {
		new DefaultInterfaceImpl().calculate(1);
	}
}
