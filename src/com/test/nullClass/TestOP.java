package com.test.nullClass;

import com.test.nullClass.after.NullTestOP;

public class TestOP {

	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public static NullTestOP newNull(){
		return new NullTestOP();
	}
}
