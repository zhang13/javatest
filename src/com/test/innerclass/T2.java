package com.test.innerclass;

public class T2 extends TTTTT{
	public void out(){
		System.out.println(a);
	}
	public void out2(){
		System.out.println("tststs");
	}
	private void out3(){
		System.out.println("T2.out3");
	}
	
	public static void main(String[] args) {
		T2 t = new T2();
		t.out();
		t.out2();
		t.out3();
	}
}
