package com.test.nullClass.after;

import com.test.nullClass.NullAble;
import com.test.nullClass.TestOP;

public class NullTestOP extends TestOP implements NullAble {

	@Override
	public int getId() {
		return 333;
	}
}
