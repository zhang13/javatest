package com.test.pattern.adapter;

public class Client {

	public static void main(String[] args) {
		SqlserverDo sd = new SqlserverDo();
		TargetDB sa = new SqlserverAdapter(sd);
		sa.getConn();
		sa.sendMsg();
		
		OracleDo od = new OracleDo();
		TargetDB oa = new OracleAdapter(od);
		oa.getConn();
		oa.sendMsg();
	}
}
