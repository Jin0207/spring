package com.example.demo.advice;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.example.demo.dao.ExceptionLogDAO;
import com.example.demo.vo.ExceptionLog;

import lombok.Setter;

@Component
@Aspect
@Setter
public class ControllerErrorAdvice {
	
	@Autowired
	private ExceptionLogDAO dao;
		//어떤 핵심관심사항을 타겟으로 하는지
		//어떤 메소드든지 ( 어떤 매개변수를 갖더라도)
	
	
	@AfterThrowing( pointcut = "execution(public * com.example.demo.controller..*(..))", throwing = "e")
	public void pro(JoinPoint joinPoint, Exception e) {
		HttpServletRequest request = (HttpServletRequest)joinPoint.getArgs()[0];
		String uri = request.getRequestURI();
		String ip = request.getRemoteAddr();
		String msg = e.getMessage();
		int start = msg.indexOf("ORA");
		int end = msg.indexOf(":", start);
		String error_code=msg.substring(start, end);
		
		ExceptionLog log = new ExceptionLog();
		log.setUri(uri);
		log.setIp(ip);
		log.setError_code(error_code);
		
		dao.insert(log);
	}
	/*public void pro(JoinPoint joinPoint, Exception e) {
		System.out.println("타깃 메소드에서 오류가 발생하였고 종료되었습니다.");
		HttpServletRequest request = (HttpServletRequest)joinPoint.getArgs()[0];
		String uri = request.getRequestURI();
		String ip = request.getRemoteAddr();
		
		System.out.println("uri: " + uri);
		System.out.println("ip: " + ip);
		
		String msg = e.getMessage();
		int start = msg.indexOf("ORA");
		int end = msg.indexOf(":", start);
		String errorCode = msg.substring(start, end);
		
//		System.out.println(msg);
		System.out.println("=============================================================");
		System.out.println("errorCode:" + errorCode);
		System.out.println("=============================================================");
	}*/

}
