package com.test.gc;
/*
 * finalize方法只在两种情况下调用，一种是jvm准备垃圾回收，会先调用它，还有就是手动调用System.gc()调用它；
 * 但是垃圾回收只和内存有关系，只有内存不够用的时候才会执行回收机制，而finalize或者将对象应用置为null都只是说明
 * 此对象可以被回收，但不一定就会被回收。
 * 对象引用置为null只是释放了在栈中的内从，并没有释放在堆中new的内存，堆中的内存有jvm垃圾回收控制。
 */
public class FinalizeTest {

	@Override
	protected void finalize() throws Throwable {
		System.out.println("finalize called");
	}
	
	public static void main(String[] args) {
		new FinalizeTest();
		System.gc();
		System.gc();
	}
}
/*output:finalize called*///:~
