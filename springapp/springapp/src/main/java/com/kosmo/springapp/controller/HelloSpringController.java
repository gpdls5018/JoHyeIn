package com.kosmo.springapp.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //controller가 우선. 요청을 처리하는 controller가 없다면 static에서 찾는다
public class HelloSpringController {
	
	//@GetMapping("/")은 루트 URL에 대한 GET 요청을 처리하는 메소드를 매핑하겠다는 의미
	//사용자가 웹 애플리케이션의 루트 URL을 방문하면, 이 메소드가 실행되어 해당 요청을 처리하게 된다.
	@GetMapping("/") //루트 URL("/")은 웹 애플리케이션의 최상위 경로(기본 홈페이지)
	public String index(Model model) {
		/*
		Controller의 메서드는 Model이라는 타입의 객체를 파라미터로 받을 수 있다.
		순수하게 JSP Servlet으로 웹 어플리케이션을 만들 때 
		보통 request나 session 내장객체에 정보를 담아 jsp에 넘겼는데 
		Spring에서는 Model이라는 녀석을 쓴다.
		즉 request.setAttribute() 와 비슷한 역할을 하는 것.
		
		편리한 점은 개발자는 직접 model을 생성할 필요는 없다. 
		다만 파라미터로 선언만 해주면 스프링이 알아서 만들어준다.
		*/
		
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		model.addAttribute("today", dateformat.format(new Date()));
		return "index"; //뷰 정보 반환 //index라는 이름으로 포워드된다
		
		//기본적으로 src/main/resources의 templates에서 index.html을 찾는다
        //반드시 '/'는 생략한다
	}
}
