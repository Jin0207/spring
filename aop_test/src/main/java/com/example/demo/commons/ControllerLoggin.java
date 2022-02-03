package com.example.demo.commons;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
//aop 설정입니다.
@Aspect
public class ControllerLoggin {

	/*
	 * //controller의 메소드들을 타깃으로 해당메소드들이 동작하기전에 동작하도록 //메소드의 반환값이 * : 어떤거라도 //해당클래스
	 * 어떤메소드라도 .. //(..) 매개변수가 있든 없든
	 * 
	 * @Pointcut("execution(public * com.example.demo.controller..*(..))") public
	 * void mypoint() { //포인트컷을 대표하는 아이디를 정해주는 것이므로 바디가 와도 의미가없고 리턴값은 항상 void }
	 * 
	 * 
	 * @Before("mypoint()") public void pro() { System.out.println("로깅입니다."); }
	 * 
	 * 
	 * //타겟이 동작하고 난다음에 실행
	 * 
	 * @After("mypoint()") public void pro2() {
	 * System.out.println("타겟 수정없이 환경설정파일만 수정하면 적용할 수 있다."); }
	 * 
	 * //타겟이 실행하기전 할일 + 타겟이 실행한후 할일 //ProceedingJoinPoint 라는 매개변수를 갖는다 (전과 후으 ㅣ기준을
	 * 갖기위해) //.proceed() 타겟을 실행시킴 //해당명령어 위에 쓰면 전에 할일, 아래쓰면 후에 할일 //getSignature
	 * 타깃이되는 메소드의 선언부 (public String list() -- 이것이 시그너처 //반드시 Joinpoint를 매개변수를
	 * 가져야한다.
	 * 
	 * @Around("mypoint()") public Object around(ProceedingJoinPoint joinPoint) {
	 * //타깃메소드호출 //이명령어 기준으로 위쪽 작성하면 타깃 동작전 수행 // 이 명령어 기준 아래쪽 작성하면 타깃 동작 후 수행
	 * //반환값은 Object, 이 오브젝트를 반환하고 끝내야함 //예외를 안고잇음 //String methodName =
	 * joinPoint.getSignature().toLongString(); //클래스명..메소드이름() 까지호출 String
	 * methodName = joinPoint.getSignature().toShortString();
	 * System.out.println(methodName + "동작하기 전"); long start =
	 * System.currentTimeMillis(); Object re = null; try { re = joinPoint.proceed();
	 * 
	 * } catch (Throwable e) {//Throwable // TODO: handle exception }
	 * 
	 * long end = System.currentTimeMillis();
	 * 
	 * System.out.println(methodName + "동작하기 후"); System.out.println("걸린시간:" +
	 * (end-start)); return re; }
	 */
}
