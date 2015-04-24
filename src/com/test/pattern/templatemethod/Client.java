package com.test.pattern.templatemethod;

public class Client {

	public static void main(String[] args) {
		
		HummerModel1 m1 = new HummerModel1();
		HummerModel2 m2 = new HummerModel2();
		
		m1.setAlarm(false);
		m1.run();
		m2.run();
	}

}
