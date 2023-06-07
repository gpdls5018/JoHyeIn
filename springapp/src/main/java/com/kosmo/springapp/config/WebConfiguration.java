package com.kosmo.springapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration //@Configuration 를 붙여야 생성됨(설정파일을 생성하는 어노테이션)
public class WebConfiguration implements WebMvcConfigurer{
	//기존 리소스 핸들러는 그대로 유지되며 원하는 리소스 핸들러만 추가 가능
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
		registry.addResourceHandler("/virtual/**") //spring.mvc.static-path-pattern=/static/**
			.addResourceLocations("classpath:/mystatic/"); //#spring.web.resources.static-locations=classpath:/static/ #생략가능(디폴트값)
				//클래스패스 설정 시 끝에 반드시 '/' 붙이자!!!
		
	}
}
