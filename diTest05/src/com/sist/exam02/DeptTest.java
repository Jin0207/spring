package com.sist.exam02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DeptTest {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/sist/exam02/beans02.xml");
		Dept dept = (Dept)context.getBean("dept");
		System.out.println(dept);
	}

}
