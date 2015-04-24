package com.utils;


import com.test.pattern.factorymethod.Human;

public class ClassUtilsTests {

	public static void main(String[] args) {
		System.out.println(ClassUtils.getAllSubClassesOrInterfaceImplementsClasses(Human.class));
		System.out.println(ClassUtils.getAllSubClassesOrInterfaceImplementsClasses(com.test.extend.T1.class));
	}

}
