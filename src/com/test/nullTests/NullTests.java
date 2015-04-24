package com.test.nullTests;

/**
 * 静态方法可以被null对象调用并且不会跑空指针。
 * 因为变量、构造方法、private、static、final的都是前期绑定（静态绑定）
 * @author 张超
 *
 */
public class NullTests {

	/**
	 * 张超
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		NullTests obj = null;
		obj.iAmStaticMethod();
		obj.iAmNonStaticMethod();
	}
	
	private static int x=1;
	private static void iAmStaticMethod() {
		
		System.out.println("I am static method, can be called by null reference"+x);
	}

	private void iAmNonStaticMethod() {
		System.out.println("I am NON static method, don't date to call me by null"+x);
	}
}
