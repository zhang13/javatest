package com.test.reflect;

public class Person{

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private String id;
	private String name;

	public Person(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Person() {
		super();
	}

	public static final Person NULL = new NullPerson();
	
	public static class NullPerson extends Person implements Null{
		private NullPerson(){
			super("none","none");
		}
		
		public String toString(){
			return "NullPerson";
		}
	}
	
}
