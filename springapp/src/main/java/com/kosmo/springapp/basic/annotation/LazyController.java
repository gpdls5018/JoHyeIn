package com.kosmo.springapp.basic.annotation;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/*
	프로젝트 최초 실행시 스프링이 관리하는 빈(스프링 컨테이너에 등록된 빈)은 하나가 생성된다(싱글톤)
	(스프링 프레임웍의 기본 동작)
	즉 해당 빈을 사용할 때가 아닌 프로젝트 최초 실행시에 생성된다
	빈을 사용할 때가 아닌 프로젝트 최초 실행시 문제점을 파악할 수 있다는
	장점이 있다.
	
	-프로젝트 최초 실행시가 아닌 빈을 사용할 때 생성하고자 하는 경우(Lazy loading이라한다-JSP 모델2 방식의 서블릿처럼)
	
	1. 빈 설정 파일에 빈을 등록하여 생성하는 경우(레거시)
		lazy-init속성 추가
		default : 스프링의 관리 사이클(최초 실행시)에 맞게 bean 을 생성한다.(false와 같다)
		true : 필요한 시점에 빈 을 생성한다.
		
		※단,lazy-init="true" 로 설정해도 해당 빈이 lazy-init="false" 인 빈에서 참조 된다면
		 의존성 관계(DI)로 인해 프로젝트 최초 실행시에 생성되게 된다.
	
	2. 어노테이션으로 빈을 생성하는 경우
		@Lazy 어노테이션 사용.디폴트는 value=true 즉 지연로딩이다
 */

@Controller
@Lazy
public class LazyController {
	
	public LazyController() {
		System.out.println("LazyController의 생성자");
	}
	
	@RequestMapping("/LazyLoading/Lazy.do")
	public String exec(Model model) {
		//데이타 저장
		model.addAttribute("message", "최초 요청 시 LazyController가 한 번만 생성됩니다");//싱글톤이므로
				
		//뷰정보 반환
		return "04_annotation/Annotation";
	}
}
