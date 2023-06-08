package com.kosmo.springapp.basic.injection;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SetterController {
	
	@Autowired
	private Person person;
	
	//세터 인젝션
	//주입받은 값을 가공해서 속성에 넣을 때 사용
	//단, 외부에서 변형 가능성이 있다(접근지정자 public 이므로)
	//싱글톤!!!!!!!!!!!!
	@Autowired //Setter 메소드에 @Autowired 어노테이션을 붙이는 방법입니다.
	public void setPerson(Person person) {
		System.out.println("SetterController 의 생성자");
		this.person = person;
		
		//주입받은 Person 객체 가공하자
		this.person.setName(this.person.getName()+" 님");
		this.person.setAge(this.person.getAge()+" 세");
		this.person.setAddr(this.person.getAddr()+" 거처");
	}

	@RequestMapping("/Injection/Setter.do")
	public String execute(Map map) {
		
		//데이타 저장
		map.put("personInfo", person);
		
		//뷰정보 반환
		return "03_injection/Injection";
	}
}
