package com.test.test;

import java.util.Date;
import java.util.Random;

public class IdTest {

	private static int id=1999999999;
	public static void main(String[] args) {
		new IdTest().idcreament();
	}
	private void idcreament() {
		Random rd=new Random();
		for(;;){
			System.out.println(id++);
		}
	}

	private void testMemory(){
		 Runtime rt=Runtime.getRuntime();
		 long freeMemory = rt.freeMemory();
		 long maxMemory = rt.maxMemory();
		 long totalMemory = rt.totalMemory();
	}
	
	
	
}
