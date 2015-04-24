package com.test.classs;

public class JavaBeanExp {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public JavaBeanExp() {
	}

	@Override
	public String toString() {
		return "JavaBeanExp [name=" + name + "]";
	}

	public JavaBeanExp(String name) {
		this.name = name;
	}
}
