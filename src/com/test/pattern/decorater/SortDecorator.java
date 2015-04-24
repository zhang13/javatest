package com.test.pattern.decorater;

public class SortDecorator extends Decorator{

	public SortDecorator(SchoolReport sr) {
		super(sr);
	}

	@Override
	public void report() {
		sortReport();
		super.report();
	}

	private void sortReport(){
		System.out.println("这次不错，是30名");
	}
	
}
