package com.test.test;

public class MathTest {
	
	public static void main(String[] args) {
		float x1=110.43729658f;
		float y1=33.472249037f;
		float x2=110.569958263f;
		float y2=33.453205774f;
		
		System.out.println(Math.sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1)));
		
		System.out.println(String.format("%.4f",1d/3));
	}

}
