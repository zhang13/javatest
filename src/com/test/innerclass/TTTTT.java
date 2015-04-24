package com.test.innerclass;

class Car {
	public void drive() {
		System.out.println("Driving a car!");
	}
}

public class TTTTT {
	protected int a=0;
	
	public  void out2(){
		System.out.println("this is a test~!~!");
	}
	private void out3(){
		System.out.println("TTTT.out3");
	}
	
	public static void main(String[] args) {
		Car car = new Car() {
			public void drive() {
				System.out.println("Driving another car!");
			}
		};
		car.drive();
	}
}
