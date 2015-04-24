package com.test.thiss;

//将当前对象传递给其他方法,为了显示我不是闲的蛋疼，在传递过程中对此对象做了一些处理，给x赋值。
public class PersonEatApple {

	public void eat(Apple apple){
		Apple peeled = apple.getPeeled();
		System.out.println(peeled.x);
	}
	
	public static void main(String[] args) {
		new PersonEatApple().eat(new Apple());
	}
}

class Peeler{
	static Apple peel(Apple apple){
		apple.x=1;
		return apple;
	}
}

class Apple{
	int x;
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	Apple getPeeled(){
		return Peeler.peel(this);
	}
}
/*Output:
 * 1
 * *///:~
