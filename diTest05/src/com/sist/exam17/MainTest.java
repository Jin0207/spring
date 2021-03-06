package com.sist.exam17;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {

	public static void main(String[] args) {
		//환경설정 파일을 읽어들일때 객체 생성됨
		ApplicationContext context =
				new ClassPathXmlApplicationContext("com/sist/exam17/beans17.xml");
		
		Person hong1 = (Person) context.getBean("hong");
		Person hong2 = (Person) context.getBean("hong");
	
		//객체를 하나만 생성해서 같이 참조함
		/*
		 * 매개변수지닌 생성자 동작
			서로 같은 메모리를 참조

		 * */
		if(hong1 == hong2) {
			System.out.println("서로 같은 메모리를 참조");
		}else {
			System.out.println("서로 다른 메모리 참조");
		}
	}

}
