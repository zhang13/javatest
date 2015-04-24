package com.test.collectionOperation;

import java.util.Set;

public class Test {

	public static void main(String[] args) {
		Set<Object> setA = GenericUtils.getHashSet();
		Set<Object> setB = GenericUtils.getHashSet();
		setA.add(1);
		setA.add(2);
		setB.add("x");
		setB.add(2);
		System.out.println(GenericUtils.unionHashSet(setA, setB));
		System.out.println(GenericUtils.intersectHashSet(setA, setB));
		System.out.println(GenericUtils.differenceHashSet(setA, setB));
		System.out.println(GenericUtils.complementHashSet(setA, setB));
		
	}
}
