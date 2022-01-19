package com.sist.exam07;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/sist/exam07/beans07.xml");
		//context를 통해서 객체를 참조한다.
		WriteArticleServiceImpl impl =(WriteArticleServiceImpl)context.getBean("ws");
		impl.insert();
	}

}
