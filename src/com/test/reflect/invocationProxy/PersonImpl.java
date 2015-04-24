package com.test.reflect.invocationProxy;

public class PersonImpl implements Person {

	@Override
	public void sayHello(String name) {
		System.out.println("hello"+"______"+name);

	}

	@Override
	public void walk() {
		System.out.println("I'm walking");

	}

}
