package com.sist.exam01;

public class Person {
	private String name;
	private int age;
	
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
		System.out.println("�Ű��������� ������ ����, ���޵� ��:" + name + "," + age);
	}

	public void sayHello() {
		System.out.println("Hello");
	}
}