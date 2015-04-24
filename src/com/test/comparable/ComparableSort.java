package com.test.comparable;

import java.util.Arrays;
import java.util.TreeMap;

public class ComparableSort {

	public static void main(String[] args) {
		/*Person[] ps = { new Person(20, "Tom"), new Person(20, "Jeff"),
				new Person(30, "Mary"), new Person(20, "Jeff"),
				new Person(40, "Walton"), new Person(61, "Peter"),
				new Person(20, "Bush") };
		System.out.println(Arrays.toString(ps));
		//Arrays.sort(ps);
		System.out.println(ps[1].equals(ps[3]));
		//Collections.sort(Arrays.asList(ps));
		System.out.println(Arrays.toString(ps));
		
		//在加入数据的时候，就调用了compareTo方法了。
		TreeMap<Person, String> map = new TreeMap<Person,String>();
		map.put(new Person(20, "Tom"), "Tom");
		map.put(new Person(20, "Mary"), "Mary");
		map.put(new Person(30, "karsh"), "karsh");
		map.put(new Person(40, "Jeff"), "Jeff");
		map.put(new Person(61, "Peter"), "Peter");
		map.put(new Person(52, "Walton"), "Walton");
		map.put(new Person(19, "Bush"), "Bush");
		map.put(new Person(20, "hult"), "hult");
		System.out.println(map);*/
		
		String str = new String ("123");
		String str2 = new String("123");
		//System.out.println(str==str2);
		System.out.println(str.equals(str2));
		System.out.println(str.hashCode());
		System.out.println(str2.hashCode());
		
		Person p1 = new Person(1,"tom");
		Person p2 = new Person(1,"tom");
		System.out.println(p1.equals(p2));
		System.out.println(p1.hashCode());
		System.out.println(p2.hashCode());
		
		PersonT pt1 = new PersonT(1,"tom");
		PersonT pt2 = new PersonT(1,"tom");
		System.out.println(pt1.equals(pt2));
		System.out.println(pt1.hashCode());
		System.out.println(pt2.hashCode());
	}
}
