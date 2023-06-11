package com.kosmo.springapp.basic.properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration //설정파일을 만들기 위한 어노테이션
@PropertySource({"classpath:config/database.properties"})
public class PlaceHolderConfig {
	
	//[@Bean 등록할 메소드를 static으로 설정한 이유]
	//아래 propertySourcesPlaceholderConfigurer() 메서드는 빈 생성 이전에 호출되어야 하므로, 
	//정적(static) 메서드로 선언하여 스프링 컨테이너에 등록됩니다.
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer(); //컨테이너에 등록이 된다
	}
}
