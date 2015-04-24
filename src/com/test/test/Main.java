package com.test.test;

import java.math.BigDecimal;

public class Main {

	public static void main(String[] args) {
		
//		Float  t = new Float(0.9f);
//		Float  s = new Float(0.9f);
//		Double d = new Double(0.9);
//		System.out.println(s==t);
//		System.out.println(s.equals(t));
//		System.out.println(s.equals(d));
		
		new BigDecimal(9555/100);
		
		String rate =  String.valueOf((new Double(9555.00/100)));
		System.out.println(rate);
		System.out.println(new BigDecimal(9550).divide(new BigDecimal(105),2,BigDecimal.ROUND_HALF_DOWN));
		
		System.out.println(Double.parseDouble(String.format("%.4f",Double.parseDouble(String.valueOf(100))/3))*100+"%");
	}

}
