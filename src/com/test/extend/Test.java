package com.test.extend;

public class Test extends T1{

	//重写父类的构造方法，没用。
	public void T1() {
		System.out.println("test");
	}
	public Test() {
		System.out.println("Test");
	}

	public static void main(String[] args) {
		//T1 t = new Test();
		//先初始化父类，在初始化子类，在调用方法。
		new Test().T1();
	}
}
