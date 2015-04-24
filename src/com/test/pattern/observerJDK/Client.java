package com.test.pattern.observerJDK;

import java.util.Observer;

public class Client {

	public static void main(String[] args) {
		HanFeiZi hanfeizi = new HanFeiZi();
		
		Observer lisi = new LiSi();
		
		
		hanfeizi.addObserver(lisi);
		hanfeizi.haveBreakfast();
		hanfeizi.haveFun();
	}
	
	
}
