package com.sist.exam02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainTest {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(BeansConfig.class);
		MemberService m = (MemberService)context.getBean(MemberService.class);
		m.updata("tiger");
		
	
	}

}
