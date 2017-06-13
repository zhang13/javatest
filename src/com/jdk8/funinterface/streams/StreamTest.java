package com.jdk8.funinterface.streams;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * java.util.Stream��ʾ��ĳһ��Ԫ�ص����У�����ЩԪ���Ͽ��Խ��и��ֲ�����Stream�����������м������Ҳ��������������
 * �������᷵��һ��ĳ�����͵�ֵ
 * �����м�����᷵�������������������ͨ����ε���ͬһ�����������������������������������StringBuffer��append����һ��
 * ������������ע����
 * Stream����һ��Դ�Ļ����ϴ��������ģ�����java.util.Collection�е�list����set��map������ΪStream��Դ
 * ����Stream������������ͨ��˳����߲������ַ�ʽ��ִ��
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
		//sort sortedֻ�Ǵ���һ���������������ͼ��������ı�ԭ��������Ԫ�ص�˳��ԭ��string�����е�Ԫ��˳����û�иı��
		stringCollection.stream().sorted((a,b)->a.compareTo(b)).forEach((s)->System.out.println(s));
		System.out.println("~~~~~~~~~~");
		//distinct ȥ�ظ�
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
