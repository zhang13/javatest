package com.test.innerclass;
/**
 * 
 * @author 张超
 * 2012-2-28下午03:10:15
 * 如果一个类，继承的类和接口中有相同的方法，那么必须用内部类还实现接口中的方法。
 */
public class TestClass extends AbstractClass implements InterfaceClass {

	/**
	 * 这个实现是抽象类中的run方法。
	 *
	 */
	@Override
	public void run() {
		System.out.println("this is abstract run()");
	}

	class inner implements InterfaceClass{
		@Override
		public void run() {
			System.out.println("this is interface run()");
		}
	}
	public static void main(String[] args) {
		TestClass tc = new TestClass();
		tc.run();
		inner in = tc.new inner();
		in.run();
	}
	
}
