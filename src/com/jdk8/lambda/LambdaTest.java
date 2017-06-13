package com.jdk8.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaTest {

	private static List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
	 
	private void sort(){
		Collections.sort(names, new Comparator<String>() {
			@Override
			public int compare(String a, String b) {
				return b.compareTo(a);
			}
		});
	}
	
	private void sortJdk8(){
//		Collections.sort(names, (String a,String b)->{
//			return b.compareTo(a);
//		});
//		Collections.sort(names, (String a, String b) -> b.compareTo(a));
		Collections.sort(names, (a,b) -> b.compareTo(a));
	}
	
	public static void main(String[] args) {
		LambdaTest lt = new LambdaTest();
		lt.sort();
		System.out.println(names);
		names = Arrays.asList("peter", "anna", "mike", "xenia");
		System.out.println(names);
		lt.sortJdk8();
		System.out.println(names);
	}

}
