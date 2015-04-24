package com.test.pattern.adapter;

public class OracleDo implements TargetDB{
	@Override
	public void getConn() {
		System.out.println("get oracle conn~!");
	}

	@Override
	public void sendMsg() {
		System.out.println("send oracle msg~!");
	}
}
