package com.test.comparator;

import java.util.Arrays;
import java.util.Collections;

import com.test.comparator.Person;

public class ComparatorSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Person[] ps = { new Person(25, "Tom", "A"),
				new Person(20, "Jeff", "C"), new Person(30, "Mary", "B"),
				new Person(20, "Jeff", "A"), new Person(40, "Walton", "E"),
				new Person(61, "Peter", "B"), new Person(20, "Bush", "C") };
		System.out.println(Arrays.asList(ps).toString());
		//Collections.sort(Arrays.asList(ps) , new LastNameComparator());
		Arrays.sort(ps , new LastNameComparator());
		System.out.println(Arrays.asList(ps).toString());
		//Collections.sort(Arrays.asList(ps) , new FirstNameComparator());
		Arrays.sort(ps , new FirstNameComparator());
		System.out.println(Arrays.asList(ps).toString());
	}

}
