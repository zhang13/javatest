package com.test.classs;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ClassGetter {

	// java反射机制的实现
	public static JavaBeanExp converStr2ServerBean(String beanName,
			String fieldSetter, String paraValue) {
		JavaBeanExp base = null;
		try {
			Class cls = Class.forName(beanName);
			base = (JavaBeanExp) cls.newInstance();// 获得该类的一个实例
			Class[] paraTypes = new Class[] { String.class };
			Method method = cls.getMethod(fieldSetter, paraTypes);
			String[] paravalues = new String[] { paraValue };
			method.invoke(base, paravalues);
		} catch (Throwable e) {
			System.err.println(e);
		}
		return base;
	}

	public static void main(String[] args) throws Exception {
		/*JavaBeanExp bean = (JavaBeanExp) ClassGetter.converStr2ServerBean("com.test.classs.JavaBeanExp", "setName", "徐徐");

		// 函数相当于执行了JavaBeanExp类的setName(“徐徐")函数，
		System.out.println(bean.getName());*/

		Class cls = Class.forName("com.test.classs.JavaBeanExp");
		Class[] paramTypes = { String.class};
		Object[] params = { "charles" }; // 方法传入的参数

		Constructor<?> con = cls.getConstructor(paramTypes); // 主要就是这句了
		JavaBeanExp base = (JavaBeanExp) con.newInstance(params);
		System.out.println(base);
	}

}
