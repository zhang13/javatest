package com.test.reflect.invocationProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 
 * 现在再也不用编写限制适配器类了！如果想创建代理对象安全地把对象限制在接口 T，只要调用 getProxy(T.class,object)
 * 就可以了，不需要一堆适配器类的额外累赘。
 * 
 * 
 * 2012-6-26下午06:08:48 通用的限制适配器工厂类
 */
public class GenericProxyFactory {
	@SuppressWarnings("unchecked")
	public static <T> T getProxy(Class<T> intf, final T obj) {
		return (T) Proxy.newProxyInstance(obj.getClass().getClassLoader(),
				new Class[] { intf }, new InvocationHandler() {
					public Object invoke(Object proxy, Method method,
							Object[] args) throws Throwable {
						System.out.println("代理测试--");
						Object result = method.invoke(obj, args);
						System.out.println("----");
						return result;
					}
				});
	}
	
	
	public static void main(String[] args) {
		Person p = GenericProxyFactory.getProxy(Person.class,new PersonImpl());
		p.sayHello("haha");
		p.walk();
	}
}
