package com.test.string;

public class Test1 {

	@Override
	public String toString() {
		return "Test1 address:"+super.toString();
	}

	public static void main(String[] args) {
		System.out.println(new Test1());
		String h="s";
		String m=new String("s");
		System.out.println(h.equals(m));
		System.out.println(h==m);
		System.out.println(h.intern()==m.intern());
		System.out.println("s".intern());
	}
	
}
