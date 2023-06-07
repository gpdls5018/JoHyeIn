package com.kosmo.springapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kosmo.springapp.basic.injection.Person;

//[일반 자바 클래스 형태. 즉 POJO(Plain Old Java Object)]

//컨트롤러 클래스
@Controller //컴파일러에게 "아래 클래스는 사용자 요청을 처리하는 클래스야" 라고 알려주는 역할
public class IndexController {
	
	@Autowired //항상 주입을 먼저하자
	private Person person;
	
	//컨트롤러 메소드
	@RequestMapping("/controller.do") //a태그로 넘긴 쿼리스트링을 request.getParameter()로 받듯이 request영역 공유함
	public String controller() {
		
		//뷰정보 반환
		return "01_controller/Controller";
	}
	
	@RequestMapping("/returntype.do")
	public String returntype() {
		//뷰정보 반환
		return "02_returntype/ReturnType";
	}
	
	@RequestMapping("/injection.do")
	public String injection() {
		
		//System.out.println("person(IndexController):"+person);
		
		//뷰정보 반환
		return "03_injection/Injection";
	}
}
