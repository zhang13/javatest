package com.test.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class CollcetionsTest {

	public static void main(String[] args) {
		ArrayList<Object> list = new ArrayList<Object>();
		list.add(1);
		list.add(5);
		list.add(2);
		list.add(3);
		list.add(6);
		List<Object> lis =Collections.synchronizedList(list);
		synchronized (lis) {
			Iterator<Object> it = lis.iterator();
			while(it.hasNext()){
				System.out.println(it.next());
			}
		}
		//new CollcetionsTest().test();
	}
	public void test(){
		int i=2;
		do{
			System.out.println(i);
		}while(--i>0);
		//
		System.out.println("fuck");
	}
}
