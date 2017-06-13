package com.jdk8.lambda;

/**
 * 
 * ����ʽ�ӿ�
 * 
 * Lambda���ʽ���ƥ��Java������ϵͳ��ÿһ��lambda���ܹ�ͨ��һ���ض��Ľӿڣ���һ�����������ͽ���ƥ�䡣
 * һ����ν�ĺ���ʽ�ӿڱ���Ҫ���ҽ���һ�����󷽷�����
 * ��ÿ����֮��Ӧ��lambda���ʽ����Ҫ����󷽷���������ƥ�䡣����Ĭ�Ϸ������ǳ���ģ�������������ĺ���ʽ�ӿ����������Ĭ�Ϸ�����
 * 
 * ����ֻ����һ�����󷽷��Ľӿڣ����Ƕ�������������lambda���ʽ��Ϊ�����㶨��Ľӿ�����Ҫ����Ӧ���ڽӿ�ǰ����@FunctionalInterface
 * ��ע����������ע�⵽�����ע�������Ľӿ��ж����˵ڶ������󷽷��Ļ������������׳��쳣
 *
 */
public class UserDefineLambdaTest {

	/**
	 * ����ʽ�ӿ�,ֻ����һ�����󷽷�(�������lambda���ʽ�Ļ�)
	 */
	@FunctionalInterface
	interface IntegerMath {
		int operation(int a, int b);
		// int operation2(int a,int b);//����ſ���lambda���ʽ�ᱨ��
	}

	private int operationBinary(int a, int b, IntegerMath im) {
		return im.operation(a, b);
	}

	/**
	 * 
	 * @param <F>
	 * @param <T>
	 */
	@FunctionalInterface
	interface Converter<F, T> {
	    T convert(F from);
	}
	
	class Something {
	    String startsWith(String s) {
	        return String.valueOf(s.charAt(0));
	    }
	}
	
	public static void main(String[] args) {
		UserDefineLambdaTest lt = new UserDefineLambdaTest();
		IntegerMath im = (a, b) -> a + b;
		IntegerMath sb = (a, b) -> a - b;
		System.out.println(lt.operationBinary(1, 3, im));
		System.out.println(lt.operationBinary(1, 3, sb));
		
		
//		Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
		//����ͨ����̬�������ã�ʹ֮���Ӽ��
		Converter<String, Integer> converter = Integer::valueOf;
		Integer converted = converter.convert("123");
		System.out.println(converted);    // 123
		
		Something something = lt.new Something();
		//Java 8 ������ͨ��::�ؼ��ֻ�ȡ�������߹��캯���ĵ����á���������Ӿ���ʾ���������һ����̬���������ң����ǻ����Զ�һ������ķ�����������
		Converter<String, String> converter2 = something::startsWith;
		String converted2 = converter2.convert("Java");
		System.out.println(converted2);    // "J"
		
	}
}
