package com.jdk8.lambda;

/**
 * 
 * 函数式接口
 * 
 * Lambda表达式如何匹配Java的类型系统？每一个lambda都能够通过一个特定的接口，与一个给定的类型进行匹配。
 * 一个所谓的函数式接口必须要有且仅有一个抽象方法声明
 * 。每个与之对应的lambda表达式必须要与抽象方法的声明相匹配。由于默认方法不是抽象的，因此你可以在你的函数式接口里任意添加默认方法。
 * 
 * 任意只包含一个抽象方法的接口，我们都可以用来做成lambda表达式。为了让你定义的接口满足要求，你应当在接口前加上@FunctionalInterface
 * 标注。编译器会注意到这个标注，如果你的接口中定义了第二个抽象方法的话，编译器会抛出异常
 *
 */
public class UserDefineLambdaTest {

	/**
	 * 函数式接口,只能有一个抽象方法(如果想用lambda表达式的话)
	 */
	@FunctionalInterface
	interface IntegerMath {
		int operation(int a, int b);
		// int operation2(int a,int b);//如果放开，lambda表达式会报错
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
		//可以通过静态方法引用，使之更加简洁
		Converter<String, Integer> converter = Integer::valueOf;
		Integer converted = converter.convert("123");
		System.out.println(converted);    // 123
		
		Something something = lt.new Something();
		//Java 8 允许你通过::关键字获取方法或者构造函数的的引用。上面的例子就演示了如何引用一个静态方法。而且，我们还可以对一个对象的方法进行引用
		Converter<String, String> converter2 = something::startsWith;
		String converted2 = converter2.convert("Java");
		System.out.println(converted2);    // "J"
		
	}
}
