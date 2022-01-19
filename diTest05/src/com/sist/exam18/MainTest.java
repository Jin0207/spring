package com.sist.exam18;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {

	public static void main(String[] args) {
		//ApplicationContext context = new ClassPathXmlApplicationContext("com/sist/exam18/beans.xml");
		 //Monitor m = (Monitor)context.getBean("monitor");
		// m.start();
		
		 AbstractApplicationContext context
		 = new ClassPathXmlApplicationContext("com/sist/exam18/beans.xml");
		 
		 try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		 context.close();
	}

}
