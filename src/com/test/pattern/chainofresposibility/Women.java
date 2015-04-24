package com.test.pattern.chainofresposibility;

public class Women implements IWomen {

	private int type=0;
	
	
	public Women(int type) {
		this.type = type;
	}

	@Override
	public int getType() {
	
		return this.type;
	}

}
