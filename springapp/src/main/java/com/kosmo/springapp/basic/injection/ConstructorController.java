package com.kosmo.springapp.basic.injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ConstructorController {
	//현재 클래스가 Person 객체 필요. 즉, Person 객체에 의존한다 
	//new 하지 않고 생성자를 통해서 주입 받자
	private Person person;

	//인젝션 순서: 생성자 인젝션 -> 세터 인젝션 -> 필드 인젝션
	
	//생성자 인잭션 -@Autowired(주입) 생략가능(생성자가 하나인 경우)
	//권장: 외부에서 변형 가능성이 없음
	//외부의 다른 빈????
	
	@Autowired
	public ConstructorController(Person person) { //싱글톤!!!!!!!!!!
		System.out.println("ConstructorController 의 생성자");
		this.person = person;
		//초기화(기본 생성자로 먼저 생성되므로-@Component, 필드에 주입해준다)
		this.person.setAddr("가산동");
		this.person.setAge("20");
		this.person.setName("가길동");
	}
	
	//생성자 인젝션
	@RequestMapping("/Injection/Constructor.do")
	public String execute(Model model) {
		
		//데이타 저장
		model.addAttribute("personInfo", person);
		
		//뷰정보 반환
		return "03_injection/Injection";
	}
}
