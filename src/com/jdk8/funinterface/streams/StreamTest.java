package com.jdk8.funinterface.streams;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * java.util.Stream表示了某一种元素的序列，在这些元素上可以进行各种操作。Stream操作可以是中间操作，也可以是完结操作。
 * 完结操作会返回一个某种类型的值
 * ，而中间操作会返回流对象本身，并且你可以通过多次调用同一个流操作方法来将操作结果串起来（就像StringBuffer的append方法一样
 * ————译者注）。
 * Stream是在一个源的基础上创建出来的，例如java.util.Collection中的list或者set（map不能作为Stream的源
 * ）。Stream操作往往可以通过顺序或者并行两种方式来执行
 *
 */
public class StreamTest {

	public static void main(String[] args) {
		List<String> stringCollection = new ArrayList<>();
		stringCollection.add("ddd2");
		stringCollection.add("aaa2");
		stringCollection.add("bbb1");
		stringCollection.add("aaa1");
		stringCollection.add("bbb1");
		stringCollection.add("ccc");
		stringCollection.add("bbb2");
		stringCollection.add("ddd1");
		

		//filter  and forEach
		stringCollection.stream().filter((s)->s.startsWith("a")).forEach((s)->System.out.println(s));
		System.out.println("~~~~~~~~~~");
		//sort sorted只是创建一个流对象排序的视图，而不会改变原来集合中元素的顺序。原来string集合中的元素顺序是没有改变的
		stringCollection.stream().sorted((a,b)->a.compareTo(b)).forEach((s)->System.out.println(s));
		System.out.println("~~~~~~~~~~");
		//distinct 去重复
		stringCollection.stream().distinct().forEach((s)->System.out.println(s));
		System.out.println("~~~~~~~~~~");
		//count
		System.out.println(stringCollection.stream().distinct().count());
		System.out.println("~~~~~~~~~~");
		//findAny
		System.out.println(stringCollection.stream().findAny());
		System.out.println("~~~~~~~~~~");
		
	}
}
