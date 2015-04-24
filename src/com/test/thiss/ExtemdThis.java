package com.test.thiss;

//this构造器
/*这个类说明了2个问题，一个是this构造器，一个是创建子类对象的时候，必然先创建父类对象，
 * 即在this(1)，方法前边默认插入了一个super();
 * 用IDE生成构造器的时候会自动加入，不知道大家注意过没有。*/
public class ExtemdThis extends Father{

	int x;
	
	public ExtemdThis() {
		this(1);//这种调用必须在此方法中的第一样，否则报错。
		super.p();
	}
	
	public ExtemdThis(int x) {
		this.x = x;
	}
	
	public static void main(String[] args) {
		System.out.println(new ExtemdThis().x);
	}
}

class Father{
	protected void p(){
		System.out.println("Father");
	}
}
/*
Father
1
*///:~