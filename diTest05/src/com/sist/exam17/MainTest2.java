package com.sist.exam17;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest2 {

	public static void main(String[] args) {
		ApplicationContext context =
				new ClassPathXmlApplicationContext("com/sist/exam17/beans18.xml");
		
		Person hong1 = (Person) context.getBean("hong");
		Person hong2 = (Person) context.getBean("hong");
	/*
	 * scope="prototype"
 	매개변수지닌 생성자 동작
	매개변수지닌 생성자 동작
	서로 다른 메모리 참조
	 */
		if(hong1 == hong2) {
			System.out.println("서로 같은 메모리를 참조");
		}else {
			System.out.println("서로 다른 메모리 참조");
		}
	}

}
