package com.sist.exam17;

public class Person {
	private String name;
	private int age;
	
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
		System.out.println("매개변수지닌 생성자 동작");
	}

	public void sayHello() {
		System.out.println("Hello" + name);
		System.out.println("나이" + age);
	}
}
