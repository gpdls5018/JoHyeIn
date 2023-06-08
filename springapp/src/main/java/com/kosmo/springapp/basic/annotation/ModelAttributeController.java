package com.kosmo.springapp.basic.annotation;

import java.util.Arrays;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ModelAttributeController {
	/*
	방법1]
	맵으로 받기:커맨드 객체(DTO계열 클래스) 생성 불필요
	단, 체크박스처럼 하나의 파라미터명 (키값이 됨)으로 여러 값이 넘어올 때는
	Map으로 받기 때문에 하나만 받을 수 있다
	*/
	/*
	@RequestMapping("/Annotation/ModelAttribute.do")
	public String map(@RequestParam Map paramMap, Model model, @RequestParam String[] inter) {
		
		//데이타 저장
		paramMap.put("inter", Arrays.toString(inter)); //덮어쓰기
		model.addAllAttributes(paramMap);
		
		//뷰정보 반환
		return "04_annotation/ModelAttribute";
	}
	*/
	
	/*
	 방법2]커맨드객체로 받기 : @ModelAttribute 사용(생략 가능)
	 파라미터가 많은 경우 서블릿 API(HttpServletRequest)보다는
	 커맨드 객체 혹은 맵으로 받는게 유리
	 -단, 커맨드 객체(DTO계열)의 속성명과 파라미터명을 일치시켜야 한다.
	
	 예]
	 @ModelAttribute 커맨드 객체타입 매개변수명
	
	 ※@SessionAttribute와 함께 세션처리(인증)에서 주로 사용
	 */
	
	//해당 요청이 있을 때마다 컨테이너가 Command 객체를 매번 생성해서 세팅한다
	//이 Command 객체의 스프링 컨테이너가 생명주기를 관리하지 않는다(싱글톤 X)
	@RequestMapping("/Annotation/ModelAttribute.do")
	//public String command(@ModelAttribute Command cmd, Model model) {//@ModelAttribute 생략가능
	public String command(Command cmd, Model model) {
		
		//데이타 저장
		model.addAttribute("cmd", cmd); //디스패처 서블릿이 "cmd"로 찾는다
		System.out.println("관심사항:"+cmd.getInter());
		
		//뷰정보 반환
		return "04_annotation/ModelAttribute";
	}
}
