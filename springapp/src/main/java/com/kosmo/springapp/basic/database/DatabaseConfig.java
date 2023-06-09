package com.kosmo.springapp.basic.database;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DatabaseConfig {
	
	//데이타 베이스 연결정보
	@Value("${driver-class-name}")
	private String driver;
	
	@Value("${oracle-url}")
	private String url;
	
	@Value("${user}")
	private String user;
	
	@Value("${password}")
	private String password;
	
	@Bean
	public DataSource dataSource() {
		//HikariConfig 객체 생성 후에 데이타베이스 연결 및 커넥션 풀 정보 설정
		HikariConfig hikariConfig = new HikariConfig();
		
		hikariConfig.setDriverClassName(driver);
		hikariConfig.setJdbcUrl(url);
		hikariConfig.setUsername(user);
		hikariConfig.setPassword(password);
		
		//히카리 커넥션 풀 관련 설정 추가
		//자동 커밋 설정(기본값 true)
		hikariConfig.setAutoCommit(true);
		
		//IDLE상태에 있는 커넥션이 없을 때. 즉 모든 커넥션이 사용 중 일 때
		//connection-timeout이 지날 때까지 getConnection() 호출은 블록킹된다
		hikariConfig.setConnectionTimeout(30000);
		
		//커넥션 풀에 최대 커넥션 수. (기본값: 10)
		hikariConfig.setMaximumPoolSize(10);
		
		//DataSource를 상속받은 HikariDataSource 객체 반환
		//위의 HikariConfig 객체로 설정 후 
		return new HikariDataSource(hikariConfig);
	}
	
}
