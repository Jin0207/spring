package com.sist.exam17;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {

	public static void main(String[] args) {
		//ȯ�漳�� ������ �о���϶� ��ü ������
		ApplicationContext context =
				new ClassPathXmlApplicationContext("com/sist/exam17/beans17.xml");
		
		Person hong1 = (Person) context.getBean("hong");
		Person hong2 = (Person) context.getBean("hong");
	
		//��ü�� �ϳ��� �����ؼ� ���� ������
		/*
		 * �Ű��������� ������ ����
			���� ���� �޸𸮸� ����

		 * */
		if(hong1 == hong2) {
			System.out.println("���� ���� �޸𸮸� ����");
		}else {
			System.out.println("���� �ٸ� �޸� ����");
		}
	}

}