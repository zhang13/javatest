package com.test.pattern.adapter;

public class SqlserverAdapter implements TargetDB {

	TargetDB ds ;
	
	public SqlserverAdapter(TargetDB ds) {
		super();
		this.ds = ds;
	}

	@Override
	public void getConn() {
		ds.getConn();
		System.out.println("sqlserverAdapter~~!");
	}

	@Override
	public void sendMsg() {
		ds.sendMsg();
		System.out.println("sqlserverSendMsg~!");
	}

	

}
