package com.test.pattern.decorater;

//用于动态的给对象添加新功能。
public abstract class Decorator implements SchoolReport {

	private SchoolReport sr;
	
	public Decorator(SchoolReport sr) {
		this.sr = sr;
	}

	@Override
	public void report() {
		sr.report();

	}

	@Override
	public void sign(String name) {
		sr.sign(name);
	}

}
