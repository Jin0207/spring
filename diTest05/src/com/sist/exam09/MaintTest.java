package com.sist.exam09;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MaintTest {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/sist/exam09/beans.xml");
		
		GoodsVO g = (GoodsVO)context.getBean("goods");
		System.out.println(g);
	}

}
