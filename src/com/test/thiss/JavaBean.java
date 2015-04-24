package com.test.thiss;

//javabean中用于区分数据成员和参数名的区别，这算是一种规范。
public class JavaBean {

	int x;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public JavaBean(int x) {
		super();
		this.x = x;
	}
	
}
