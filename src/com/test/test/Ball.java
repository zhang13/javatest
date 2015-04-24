package com.test.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ball {

	private List<Integer> redBalls;
	private Integer blueBall;

	public Ball() {
		calculateRedBalls();
		calculateBlueBall();
	}

	private void calculateRedBalls() {
		List<Integer> balls = new ArrayList<Integer>();
		for (int i = 1; i <= 33; i++) {
			balls.add(i);
		}
		Collections.shuffle(balls);//Ëæ»úÖÃ»»
		redBalls = new ArrayList<Integer>(balls.subList(0, 6));
		Collections.sort(redBalls);
	}

	private void calculateBlueBall() {
		blueBall = (int) (Math.random() * 16 + 1);
	}

	@Override
	public String toString() {
		return "red balls is " + redBalls + " and blue ball is " + blueBall;
	}

	public static void main(String[] args) {
		Ball ball = new Ball();
		System.out.println(ball);
	}

}
