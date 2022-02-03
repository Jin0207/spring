package com.example.demo;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AopConfig {
	
	@Pointcut("execution(public * com.example.demo.controller..*(..))")
	private void mypoint() {}
	
	@Before("mypoint()")
	public void before() {
		System.out.println("타깃메소드 동작하기 전 실행되는 메소드 @Before");
	}
}
