package com.test.innerclass;

public class InnerClass {

	private int a = 1;
	private static int b = 2;

	class A {
		public void outA() {
			System.out.println(a + "  A outA()");
		}
	}

	// 静态内部类，不能调用外部类的非静态属性
	static class B {
		private void outB() {
			System.out.println(b + " B outB()");
			new InnerClass().new A().outA();
		}
	}

	// 方法内部类,使用的本方法内的属性，必须是final的。
	public void methodA() {
		final int c = 0;
		class innerA {
			private void innerMethodClass() {
				System.out.println("innerMethodClass  " + c);
			}
		}
		innerA ia = new innerA();
		ia.innerMethodClass();
	}

	interface InnerA{
		void inA();
	}
	// 匿名内部类
	public void methodB(final int a){
		InnerA aa =new InnerA(){
			@Override
			public void inA() {
				System.out.println(a+"  接口式匿名内部类methodB");
			}
		};
		aa.inA();
	}

	//继承是的匿名内部类，如果outA方法在A内部类中是private，那么在C类中的方法outA是没有重写A类的方法的。
	class C{
		A aaa = new A(){
			public void outA() {
				System.out.println("继承式的匿名内部类");
			}
		};
	}
	
	public static void main(String[] args) {
		InnerClass ic = new InnerClass();
		ic.new A().outA();
		new B().outB();
		ic.methodA();
		ic.methodB(3);
		ic.new C().aaa.outA();
	}
}
