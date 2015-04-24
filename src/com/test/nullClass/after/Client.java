package com.test.nullClass.after;

import com.test.nullClass.TestOP;

public class Client {

	public static void main(String[] args) {
		TestOP tp =TestOP.newNull();
		System.out.println(info(tp));
		tp = new TestOP();
		tp.setId(555);
		System.out.println(info(tp));
	}
	
	private static int info(TestOP tp){
		return tp.getId();
	}
}
