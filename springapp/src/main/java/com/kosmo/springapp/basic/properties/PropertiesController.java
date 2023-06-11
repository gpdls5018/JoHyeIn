package com.kosmo.springapp.basic.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Properties")
public class PropertiesController {
	
	//디폴트 속성에서 읽기(application.properties)
	@Value("${spring.mvc.static-path-pattern}")
	private String staticPathPattern;
	
	@Value("${nickname}")
	private String nickname;
	
	//디폴트 속성파일: application.properties 에서 읽기
	@GetMapping("/ValueDefault")
	public String valueDefault(Model model) {
		//데이타 저장
		model.addAttribute("message", String.format("정적파일 패스:%s<br/>닉네임:%s", staticPathPattern, nickname));
		
		//뷰정보 반환
		return "05_properties/Properties";
	}
	
	
	@Value("${driver-class-name}")
	private String driver;
	
	@Value("${oracle-url}")
	private String url;
	
	@Value("${user}")
	private String user;
	
	@Value("${password}")
	private String password;
	
	//디폴트 속성파일이 아닌 src/main/resources/config/database.properties 에서 읽기
	//1.PropertySourcesPlaceholderConfigurer 빈 등록
	//2.@PropertySource()에 속성 파일 위치 설정
	@GetMapping("/ValueCustom")
	public String valueCustom(Model model) {
		//데이타 저장
		model.addAttribute("message", String.format("드라이버:%s<br/>URL:%s<br/>아이디:%s<br/>비밀번호:%s", driver,url,user,password ));
		
		//뷰정보 반환
		return "05_properties/Properties";
	}
}
