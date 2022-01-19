package com.sist.exam06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/sist/exam06/beans06.xml");
		Person p = (Person)context.getBean("person");
		p.info();
	}

}
