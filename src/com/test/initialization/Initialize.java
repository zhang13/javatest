package com.test.initialization;

public class Initialize {

	private static Test t = new Test();
	
	{
		System.out.println("{}");
	}
	
	private int n=2;
	
	static{
		System.out.println("static{}");
	}
	
	public Initialize() {
		System.out.println("initialize:Constructor");
		System.out.println(n);
	}

	public void f(){
		System.out.println("f():execute");
	}
	
	public static void main(String[] args) {
		new Initialize().f();
	}

}

class Test{

	public Test() {
		System.out.println("Test:Constructor");
	}
}
/*
Test:Constructor
static{}
{}
initialize:Constructor
2
f():execute
*///:~
