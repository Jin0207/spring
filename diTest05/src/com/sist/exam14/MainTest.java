package com.sist.exam14;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/sist/exam14/beans.xml");
		OrderGoods orderGoods = (OrderGoods)context.getBean("orderGoods");
		orderGoods.order();
	}
}
