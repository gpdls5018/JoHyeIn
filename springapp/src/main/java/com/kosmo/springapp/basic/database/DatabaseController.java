package com.kosmo.springapp.basic.database;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DatabaseController {
	
	@Autowired //데이타 주입
	private DataSource dataSource;
	
	@GetMapping("/Database/HikariConnectionPool.do")
	public String connectionPool(Model model) throws SQLException {
		System.out.println("dataSource:"+dataSource);
		
		//주입받은 DataSource 객체로 Connection 객체 얻기
		Connection conn = dataSource.getConnection();
		
		//데이타 저장
		model.addAttribute("message", conn==null?"[데이타베이스 연결실패]":"[데이타베이스 연결 성공]");
		
		//커넥션 객체 풀에 반납
		if(conn != null) conn.close();
		
		//뷰정보 반환
		return "06_database/Database";
	}
	
}
