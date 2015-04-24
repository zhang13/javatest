package com.test.thiss;

//返回对象本身的引用，可以做到非常有趣的事情。
public class ReturnThis {

	int i;
	public ReturnThis increment(){
		i++;
		return this;
	}
	
	public static void main(String[] args) {
		System.out.println(new ReturnThis().increment().increment().increment().i);
	}
}
/*output:3
 *///:~
