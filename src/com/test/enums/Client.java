package com.test.enums;

public class Client {

	public static void main(String[] args) {
		EnumTest et = EnumTest.ONE;
		System.out.println(et);
		System.out.println(et.name());
		System.out.println(et.ordinal());
	}
}
