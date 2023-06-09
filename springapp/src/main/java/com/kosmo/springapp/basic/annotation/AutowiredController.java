package com.kosmo.springapp.basic.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //요청한 클라이언트에 템플릿 뷰 페이지를 전송할 때
public class AutowiredController {
	
	/*
	 * 테스트 시나리오
	 * 1. Type 기반
	 * 	1-1.SpringBeanConfig파일에 Command객체 하나 등록(value속성/@Qualifier 생략)
	 * 		@Autowired //데이타 소스 주입받기
			private Command fCommand;
			@Autowired
			private Command sCommand;
			
			fCommand와 sCommand는 같은 객체가 주입된다
			
	    1-2.빈 설정파일 혹은 자바코드로 빈 등록시에 Command객체 또 하나 등록
			500에러
			
	    1-3.@Autowired(required = false) 빈 설정파일 혹은 자바코드로 등록한 두 개의 빈을 주석처리
	       주입이 필수가 아니기때문에 객체가 없으면 주입이 안됨으로
	       fCommand와 sCommand는 null
	      
	 2. id 기반
	    SpringBeanConfig파일에서 id속성은 주입대상 클래스의 멤버필드명(변수명)과 일치시켜라
	    
	    [자바코드로 빈 등록시 ID부여 방법]
	    1.@Bean("id명") : 인스턴스 변수 역할(우선한다)
	    2.@Bean : id명 미부여 시 메소드명이 id(식별자)가 된다
	    
	 3. Qualifier기반
	 	@Qualifier : 여러 개의 동일한 타입의 빈(Bean) 중에서 어떤 빈을 주입해야 하는지 명시적으로 지정하는데 사용
	    3-1. SpringBeanConfig파일에서 id속성 제거 및  @Qualifier("식별자1") 추가
	    3-2. 필드에 @Qualifier("식별자1")
	 *
	 * ※ 타입 -> ID -> Qualifier
	 * 
	 * @Resource 어노테이션은 ID -> 타입 -> Qualifier이다
	 */
	
	/*
	//[필드에 부착]-필드 인젝션
	@Autowired(required = false)
	@Qualifier("command1")
	private Command fCommand;
	
	@Autowired(required = false)
	@Qualifier("command2")
	private Command sCommand;
	*/
	/*
	//[세터에 부착]-추가적인 로직이 필요할 때(세터 인젝션)
	//***이 때는 SpringBeanConfig 파일의 id 속성값이 세터의 매개변수명과 일치시켜야 한다
	private Command firstCommand;
	private Command secondCommand;
	
	@Autowired
	public void setFirstCommand(Command firstCommand) {
		this.firstCommand = firstCommand;
	}

	@Autowired
	public void setSecondCommand(Command secondCommand) {
		this.secondCommand = secondCommand;
	}
	*/
	
	//[생성자에 부착]-단, @Qualifier 부착 불가-생성자 인젝션
	//***이 때는 SpringBeanConfig 파일의 id 속성값이 생성자의 매개변수명과 일치시켜야 한다
	private Command firstCommand;
	private Command secondCommand;
	
	//@Autowired //생성자가 1개 일 때는 생략가능
	public AutowiredController(Command firstCommand, Command secondCommand) {
		this.firstCommand = firstCommand;
		this.secondCommand = secondCommand;
	}


	@RequestMapping("/Annotation/Autowired.do")
	public String execute(Model model) {
		//데이타 저장
		model.addAttribute("message", String.format("fCommand:%s,sCommand:%s", firstCommand,secondCommand));
		
		//뷰정보 반환
		return "04_annotation/Annotation";
	}
}
