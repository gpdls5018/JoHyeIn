package com.kosmo.springapp.basic.injection;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FieldController {
	
	//필드 인젝션(private 이므로 외부에서 접근 불가능)
	//외부에서 변형이 불가능하다(접근지정자가 private 이므로)
	//Person이 싱글톤으로 생성되므로 ConstructorController 가 생성될 때 
	//초기화된 Person(이름,나이,주소) 객체가 필드로 주입된다
	@Autowired //필드에 @Autowired 어노테이션만 붙여주면 자동으로 의존성 주입됩니다.
	private Person person;
	
	@RequestMapping("/Injection/Field.do")
	public String execute(Map map) {
		
		//데이타 저장
		map.put("personInfo", person);
		
		//뷰정보 반환
		return "03_injection/Injection";
	}
}
