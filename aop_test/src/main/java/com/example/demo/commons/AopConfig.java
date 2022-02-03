package com.example.demo.commons;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AopConfig {
	
	/*
	 * @Pointcut("execution(public * com.example.demo.dao..*(..))") public void
	 * daoPoint() {}
	 */
	
	//예외에 대한 정보도 알고 싶고
	//타깃메소드에 대한 정보도 알고싶을때
	//반드시 JointPoint를 맨 첫번째 매개변수로 두어야한다.
	@AfterThrowing(pointcut =  "execution(public * com.example.demo.dao..*(..))", throwing = "ex")
	public void afterError(JoinPoint joinPoint,Exception ex) {
		String methodName = joinPoint.getSignature().toShortString();
		System.out.println("타깃메소드에서 다음의 예외가 발생하였습니다.");
		System.out.println(ex.getMessage());
		System.out.println("타깃 "+ methodName +" 동작 후입니다."); 
		System.out.println("============================================");
	}
	
	//타깃이되는 메소드가 오류가 났을 때에
	//그 오류의 정보를 파악
	/*
	 * @AfterThrowing(pointcut = "execution(public * com.example.demo.dao..*(..))",
	 * throwing = "ex") public void afterError(Exception ex) {
	 * System.out.println("타깃메소드에서 다음의 예외가 발생하였습니다.");
	 * System.out.println(ex.getMessage());
	 * System.out.println("============================================"); }
	 */
	
	
	//타깃이 되는 메소드가 정상적으로 종료하든 오류가 나든
	//반드시 동작하는 어드바이스
	/*
	 * @After("daoPoint()") public void after(JoinPoint joinPoint) { String
	 * methodName = joinPoint.getSignature().toShortString();
	 * System.out.println(methodName + "메소드가 종료되었습니다."); }
	 */
	
	/*
	 * @AfterThrowing("daoPoint()") public void afterError(JoinPoint joinPoint) {
	 * String methodName = joinPoint.getSignature().toShortString();
	 * System.out.println(methodName+"타깃 메소드가 비정상 종료되었습니다."); }
	 */
	
	// 타깃이되는메소드가 오류없이 정상적으로 완료되었을때 동작하는 어드바이스
	/*
	 * @AfterReturning("daoPoint()") public void afterOK(JoinPoint joinPoint) {
	 * String methodName = joinPoint.getSignature().toShortString();
	 * System.out.println("타깃 "+ methodName +" 동작 후입니다."); }
	 */
}
/*
 * @Pointcut("execution(public int com.example.demo.dao..*(..))") public void
 * daoPoint() {}
 * 
 * @After("daoPoint()") public void after() {
 * System.out.println("타깃 메소드 동작 후입니다."); }
 */