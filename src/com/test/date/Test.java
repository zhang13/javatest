package com.test.date;

import java.util.GregorianCalendar;
/**
 * 为什么 year%4的效果等于year&3呢，3的2进制为11，与上后两位都为0的数字，结果才为0，所以效果一样
 * 而且运算速度较快。
11
100
101
110
111
1000
1001
1010
1011
1100
1101
1110
1111
10000
 * 
 * @author 张超
 * 2012-4-26下午04:39:22
 *
 */
public class Test {

	public static boolean isLeapYear(int year){
		if(year<1582){
			return false;
		}
		return (year%400 == 0)||(year%100 != 0) &&((year & 3)==0);
	}
	
	
	public static void main(String[] args) {
		int year = 2004;
		System.out.println(new GregorianCalendar().isLeapYear(year));
		System.out.println(isLeapYear(year));
	}
}
