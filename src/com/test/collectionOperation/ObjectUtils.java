package com.test.collectionOperation;

import java.util.Collection;

public class ObjectUtils {

	public static <T> boolean isEmpty(Collection<T> c){
		if(c.isEmpty()){
			return true;
		}
		return false;
	}
	public static <T> boolean isNotEmpty(Collection<T> c){
		if(c.isEmpty()){
			return false;
		}
		return true;
	}
}
