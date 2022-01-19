package com.sist.exam12;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {

	public static void main(String[] args) {
		// 스프링컨테이너가 제공하는 객체를 참조하기위하여 ApplicationContext객체를 생성
		ApplicationContext context = new ClassPathXmlApplicationContext("com/sist/exam12/beans.xml");
		//getBean()를 통해서 bean객체를 참조 Object반환 -> 타입캐스팅
		SystemMonitor sm = (SystemMonitor)context.getBean("systemMonitor");
		sm.monitor();
	}

}
