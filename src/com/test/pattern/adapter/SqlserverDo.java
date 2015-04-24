package com.test.pattern.adapter;

public class SqlserverDo implements TargetDB{

	@Override
	public void getConn() {
		System.out.println("get sqlserver conn~!");
	}

	@Override
	public void sendMsg() {
		System.out.println("send sqlserver msg~!");
	}
}
