package com.test.nullClass.before;

import com.test.nullClass.TestOP;

public class Client {

	public static void main(String[] args) {
		TestOP tp =null;
		System.out.println(info(tp));
		tp = new TestOP();
		tp.setId(555);
		System.out.println(info(tp));
	}
	
	private static int info(TestOP tp){
		if(tp==null) return 333;
		else return tp.getId();
	}
}
