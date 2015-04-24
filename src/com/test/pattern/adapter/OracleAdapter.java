package com.test.pattern.adapter;

public class OracleAdapter implements TargetDB {
	TargetDB ds;

	public OracleAdapter(TargetDB ds) {
		super();
		this.ds = ds;
	}

	@Override
	public void getConn() {
		ds.getConn();
		System.out.println("oracleAdapter connected~!");
	}

	@Override
	public void sendMsg() {
		ds.sendMsg();
		System.out.println("oracleAdapter sendMsg~!");
	}

}
