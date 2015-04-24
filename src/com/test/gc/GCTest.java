package com.test.gc;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * 如果一个对象没有了被引用，那么就能被垃圾回收机回收。
 * @author 张超
 * 2012-7-27上午11:32:41
 *
 */
public class GCTest {

	private List<String> paramsList = null;
	@Before
	public void setUp(){
		paramsList = new ArrayList<String>();
		paramsList.add("a");
		paramsList.add("b");
		paramsList.add("c");
		paramsList.add("d");
		paramsList.add("e");
	}
	
	@Test
	public void strongReference(){
		String str = "hello";//这一句，首先创建了"hello"这个对象，然后str引用了"hello"对象的地址。
		String newStr = str;//newStr这个对象引用了str所引用的地址。只是复制了引用,并没有复制对象。
		str=null;
		//System.gc();
		assertNotNull(newStr);
		assertNull(str);
	}
	
	@Test
	public void paramObjectTests(){
		assertEquals(paramsList, removeOneObject(paramsList));
		System.out.println(paramsList);//[b, c, d, e]
		
		assertNull(setNull(paramsList));
		assertNotNull(paramsList);
		
		assertEquals(paramsList, removeOneObject2(paramsList));
		System.out.println(paramsList);//[c, d, e]
	}
	
	public List<String> removeOneObject(List<String> list){
		List<String> data =list;
		data.remove(0);
		return data;
	}
	
	public List<String> setNull(List<String> list){
		List<String> data =list;
		data=null;
		return data;
	}
	
	public List<String> removeOneObject2(List<String> list){
		list.remove(0);
		return list;
	}
}
