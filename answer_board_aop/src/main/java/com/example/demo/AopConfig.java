package com.example.demo;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
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
	public void before(JoinPoint joinpoint) {
		String methodName = joinpoint.getSignature().toShortString();
		System.out.println("타깃메소드"+methodName+" 동작하기 전 실행되는 메소드 @Before");
		
		//타겟이되는 메소드의 매개변수들을 가져오는 메소드
		//[0] 그 중 첫번째 매개변수를 가져온다 반환되는 타입은 OBject
		HttpServletRequest request = (HttpServletRequest)joinpoint.getArgs()[0];
		
		String uri = request.getRequestURI();
		String ip = request.getRemoteAddr();
		
		System.out.println("uri:" + uri);
		System.out.println("ip:" + ip);
		System.out.println("-------------------------------------------------------");
	}
}
