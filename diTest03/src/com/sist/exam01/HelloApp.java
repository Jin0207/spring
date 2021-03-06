package com.sist.exam01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.MemberDAO;

public class HelloApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/sist/exam01/member.xml");
		MemberDAO dao = (MemberDAO)context.getBean("dao");
		dao.insert();
	}

}
