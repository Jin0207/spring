package com.sist.exam03;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

public class HelloApp {
	public static void main(String[] args) {
		//流立按眉 积己
		//MessageBean mb = new MessageBeanEn();
		//MessageBean mb = new MessageBeankr();
		
		Resource resource = new FileSystemResource("beans.xml");
		BeanFactory factory = new XmlBeanFactory(resource);
		
		MessageBean mb = (MessageBean)factory.getBean("mb");
		
		mb.sayHello("Tiger");
		
	}
}
