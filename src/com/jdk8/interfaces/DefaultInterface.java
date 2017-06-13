package com.jdk8.interfaces;

/**
 * 
 * @author charles.zhang13
 * <li>Java 8 允许我们使用default关键字，为接口声明添加非抽象的方法实现。这个特性又被称为扩展方法。
 * 实现类只需要实现接口方法，默认方法可以直接使用！！！也可被重写！！要抽象类还有何用呢？？？？
 * 
 */
public interface DefaultInterface {

	double calculate(int a);
	
	default double sqrt(int a){
		System.out.println("接口");
		return Math.sqrt(a);
	}
}
