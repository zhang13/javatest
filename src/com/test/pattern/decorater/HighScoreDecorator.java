package com.test.pattern.decorater;

public class HighScoreDecorator extends Decorator {

	public HighScoreDecorator(SchoolReport sr) {
		super(sr);
	}

	@Override
	public void report() {
		reportHighScore();
		super.report();
	}
	
	private void reportHighScore(){
		System.out.println("最高成绩是80");
	}
	
}
