package com.test.pattern.decorater;

public class ForthGrateReport implements SchoolReport{

	@Override
	public void report() {
		System.out.println("原始的成绩单");
		
	}

	@Override
	public void sign(String name) {
		System.out.println("签名："+name);
		
	}

}
