package com.test.comparable;
/**
 * 这个类没有对name进行比较操作，也没有定义比较器，在用sort()排序时，会按照自然排序。
 * @author 张超
 * 2012-2-24上午11:33:14
 *
 */
public class Person implements Comparable<Person> {

	/** 定义两个对比参数 **/
	private int age;
	private String name;

	public Person(int age, String name) {
		this.age = age;
		this.name = name;
	}

	@Override
	public int compareTo(Person o) {
		int result = age - o.getAge();
		if (result != 0) {
			return result;// 第一个对比对象age
		} else {
			return name.compareTo(o.name);// 如果第一个不相等，则比对第二个
		}
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Person)) {
			return false;
		}
		Person p = (Person) o;
		return (age == p.getAge()) && (name.equals(p.getName()));
	}
	
	/**Object的hashCode方法返回的是对象的内存地址**/
	@Override
	public int hashCode() {
		int result = 17;
		result = 37 * result + age;
		result = 37 * result + name.hashCode();
		return result;
	}

	public String toString() {
		return age + "{ " + name + " }";
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
