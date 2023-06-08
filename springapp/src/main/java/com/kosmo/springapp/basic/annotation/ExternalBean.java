package com.kosmo.springapp.basic.annotation;

/*
	 스프링 철학에 맞게 DI를 통해서 주입받자
	 주입 받으려면 주입 받으려는 빈은 반드시 스프링 컨테이너에 등록되야 한다
	 
	 [스프링 컨테이너에 빈 등록방법 3가지]
	 1.@Component 어노테이션을 붙이거나(컴포넌트 스캔) 아니면
	 2.@Configuration 어노테이션이 붙은 클래스에서 @Bean으로 등록한다(자바코드로 등록)
	 3.빈 설정파일(XML 파일)에 등록해주거나
	 
	 즉 내가 만든 빈은 @Component를 붙이면 된다
	 외부 라이브러리에서 제공하는 클래스를 스프링 컨테이너에 등록하려면
	 2번이나 3번을 사용한다
	 
	 스프링부트는 2번을 사용한다
 */

//내가 만든 빈이 아니라고 가정하자(어노테이션이 붙지 않으므로 절대 출력되지 않는다)
//아래는 ConfigurationController 에서 주입받는 외부 라이브러리라고 하자
public class ExternalBean {
	
	public ExternalBean() {
		System.out.println("ExternalBean의 생성자");
	}

	@Override
	public String toString() {
		return "ExternalBean 객체이다";
	}
	
}
