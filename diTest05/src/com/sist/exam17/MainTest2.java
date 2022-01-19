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
 	�Ű��������� ������ ����
	�Ű��������� ������ ����
	���� �ٸ� �޸� ����
	 */
		if(hong1 == hong2) {
			System.out.println("���� ���� �޸𸮸� ����");
		}else {
			System.out.println("���� �ٸ� �޸� ����");
		}
	}

}
