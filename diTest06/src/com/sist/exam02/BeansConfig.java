package com.sist.exam02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//클래스 헤더에 @환경설정대신하는 클래스라고 알림
@Configuration
public class BeansConfig {
	
	@Bean
	public MemberService member1() {
		return new MemberService();
	}
}
