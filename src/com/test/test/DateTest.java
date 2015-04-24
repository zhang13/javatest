package com.test.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTest {

	public static void main(String[] args) {
		SimpleDateFormat format=new SimpleDateFormat("HH:mm");
		String strDate = format.format(new Date());
		Date date =null;
		try {
			date = format.parse(strDate);
			System.out.println(date);
			Date d = new Date();
			System.out.println(d.getHours()+":"+d.getMinutes());
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}
