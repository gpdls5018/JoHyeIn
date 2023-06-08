package com.kosmo.springapp.basic.annotation;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/*
	스프링 컨테이너에 빈으로 등록하는 방법
	1.@Controller/ @Component/ @Service 등의 어노테이션을 클래스 위에 붙인다
		(어노테이션으로 빈 등록)
	2.스프링 빈 설정파일인 xml 파일에 작성한 자바 클래스를 태그로 등록
		단, 스프링 부트는 xml 설정과 같은 것을 최소화하는 것이 철학이라
		xml 설정이 없다 (xml 설정으로 빈 등록)
	3.@Configuration 과 @Bean 어노테이션을 사용(자바코드로 빈 등록)
		주로 외부 라이브러리의 클래스를 빈으로 등록할 때 사용 
 */

@Configuration //어떤 구성을 하는 빈이다
public class SpringBeanConfig {

	public SpringBeanConfig() {
		System.out.println("@Configuration 붙은 SpringBeanConfig의 생성자");
		
	}
	
	//@Bean 어노테이션에 의해 아래 2개의 Command 객체는 스프링 컨테이너에 등록된다(즉 싱글톤이다)
	@Bean //: 빈의 아이디 미 부여(이 때는 메소드명이 id가 된다)
	@Qualifier("command1") //꼭 주입받는 대상의 필드명과 일치하지 않아도 된다
	//@Bean("fCommand") //빈의 아이디 부여
	public Command firstCommand() {//메소드명이 식별자가 된다       
		
		return new Command("김길동", "KIM", "KIM1234");
	}

	@Bean
	@Qualifier("command2")
	//@Bean("sCommand")
	public Command secondCommand() {
		
		return new Command("박길동", "PARK", "PARK1234");
	}
	
	@Bean
	@Lazy //최초 요청 시 생성하자(Lazy 로딩). 단, Lazy로딩이 아닌 컨트롤러에도 @Lazy를 붙여야한다
	public ExternalBean externalBean() {
		
		return new ExternalBean();
	}
}
