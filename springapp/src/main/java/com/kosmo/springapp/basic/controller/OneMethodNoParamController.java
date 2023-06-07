package com.kosmo.springapp.basic.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

//컨트롤러 클래스
@Controller
public class OneMethodNoParamController {
	
	//컨트롤러 메소드
	/*
	 * URL패스에 파라미터를 포함시켜 값을 전달하는 방식
	 * 설정 : URL패턴의 변하는 부분을 {변수명}로 변수처리
	 * 읽기 : 패스 파라미터로 값을 받을 때는 @PathVariable 타입 String 변수명으로 받는다
	*/
	@RequestMapping("/Controller/OneClass/{path}") //변수에 담음
	public String noparam(@PathVariable String path, Map map) {
		//System.out.println(path);
		
		//모델계열(Map)에 데이타 저장
		switch(path.toUpperCase()) {
			case "LIST.DO": map.put("message", "목록요청 입니다"); break;
			case "EDIT.DO": map.put("message", "수정요청 입니다"); break;
			case "DELETE.DO": map.put("message", "삭제요청 입니다"); break;
			default:  map.put("message", "상세보기요청 입니다");
		}
		
		//디스패처 서블릿에게 뷰정보 반환
		return "01_controller/Controller"; //포워딩
	}
}
