package com.kosmo.springapp.basic.injection;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class InjectionController {
	
	//@Autowired
	private Person person;
	//new로 객체화가 아닌 주입한다
	//객체화는 스프링 철학에 어긋남(결합도가 높아지므로)
	
	@Autowired //데이타 소스 주입받기
	public InjectionController(Person person) {
		this.person = person;
	}
	
	
	@RequestMapping("/Injection/Injection.do")
	public String execute(@RequestParam Map<String, String> map, Map model) {
		//데이타 저장
		//사용자 입력값으로 person을 설정
		person.setAddr(map.get("addr"));
		person.setAge(map.get("age"));
		person.setName(map.get("name"));
		
		model.put("personInfo", person);
		
		//뷰정보 반환
		return "03_injection/Injection";//페이지는 변환
	}
	
}
