package com.test.pattern.decorater;

public class Client {

	public static void main(String[] args) {
		//原始四年级成绩单
		SchoolReport sr = new ForthGrateReport();
		
		//加了最高分说明的成绩单
		sr = new HighScoreDecorator(sr);
		
		//加了排名说明的成绩单
		sr = new SortDecorator(sr);
		
		sr.report();
		sr.sign("老爸");

	}
}
