package com.test.comparator;

import java.util.Comparator;
/**
 * 
 * @author 张超
 * 2012-2-24上午11:07:49
 *	用firstName优先排序
 */
public class FirstNameComparator implements Comparator<Person> {

	@Override
	public int compare(Person o1, Person o2) {
		String fn1 = o1.getFirstName().toUpperCase();
		String fn2 = o2.getFirstName().toUpperCase();
		String ln1 = o1.getLastName().toUpperCase();
		String ln2 = o2.getLastName().toUpperCase();
		if(fn1.equals(fn2)){
			return ln1.compareTo(ln2);
		}
		return fn1.compareTo(fn2);
	}
	

}
