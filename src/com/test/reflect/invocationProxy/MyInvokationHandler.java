package com.test.reflect.invocationProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyInvokationHandler implements InvocationHandler {

	/**
	 * 执行动态代理对象的所有方法，都会被替代成执行如下的invoke方法,我们可以再这个方法中做一些特殊的处理。
	 * 比如hibernate的事务处理：在执行insert、update等方法的时候，加入开启和关闭事务的方法。
	 * 其中：
	 *  proxy 代表动态代理对象
	 *  method 代表正在执行的方法
	 *  args 代表执行代理对象方法时的参数
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("正在执行的方法：" + method);
		if (args != null) {
			for (Object arg : args) {
				System.out.println("参数"+arg);
			}
		} else {

		}
		return null;
	}

	public static void main(String[] args) {
		InvocationHandler invoke = new MyInvokationHandler();
		Person p = (Person) Proxy.newProxyInstance(Person.class
				.getClassLoader(), new Class[] { Person.class }, invoke);
//		Person p = (Person)GenericProxyFactory.getProxy(Person.class, new PersonImpl());
		p.walk();
		p.sayHello("charles");
	}

}
