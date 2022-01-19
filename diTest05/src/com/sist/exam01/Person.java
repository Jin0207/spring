package com.sist.exam01;

public class Person {
	private String name;
	private int age;
	
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
		System.out.println("매개변수지닌 생성자 동작, 전달된 값:" + name + "," + age);
	}

	public void sayHello() {
		System.out.println("Hello");
	}
}
