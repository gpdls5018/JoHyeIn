package com.kosmo.springapp.basic.returntype;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Member;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.InternalResourceView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller //페이지 반환할 때(이동할 때) 사용
public class ReturnTypeController {
	/*
	 ***주로 뷰정보(HTML 페이지) 반환 시는 반환 타입을 String.
	 HTML 페이지가 아닌 데이타 반환 시는 반환 타입을 객체(자바빈 혹은 컬렉션)로 한다
	 
	[컨트롤러 메소드] 반환타입-ModelAndView : ModelAndView에 뷰 정보와 데이타 정보 저장해서 반환
	뷰 정보 설정시 : ModelAndView객체.setViewName(String)일 때 접두어/접미어가 붙는다
	              ModelAndView객체.setView(View)일 때는 접두어/접미어가 붙지 않는다
	 */
	
	@RequestMapping("ReturnType/ModelAndView.do")
	public ModelAndView modelAndView(@RequestParam Map map, Model model) {
		/* 
		//방법1. ModelAndView 객체에 뷰 정보만 저장해서 반환
		//데이타 저장-Model에 데이타 저장
		model.addAllAttributes(map); //파라미터명이 속성명이 되서 리퀘스트 영역에 저장된다
		model.addAttribute("message", map.get("returnType")); 
		
		return new ModelAndView("02_returntype/ReturnType");
		 */
		
		//방법2. ModelAndView 객체에 뷰 정보와 데이타 저장해서 반환 - Model 인자는 필요없다
		ModelAndView mav = new ModelAndView();
		
		//데이타 저장
		mav.addAllObjects(map);
		mav.addObject("message", map.get("returnType"));
		
		//뷰 정보 저장
		//mav.setViewName("02_returntype/ReturnType"); //접두어,접미어가 붙는다
		
		//InternalResourceView 뷰 객체로 뷰 정보 설정 시에는 반드시 뷰 템플릿(JSP)의 풀 경로를 설정해야한다
		//즉 뷰 리졸버의 접두어,접미어가 붙지 않기 때문에
		mav.setView(new InternalResourceView("/WEB-INF/views/02_returntype/ReturnType.jsp")); //디폴트 뷰(.jsp) //스프링부트에서는 잘 사용하지 않는다
		
		return mav;
	}/////////////
	
	//[컨트롤러 메소드]반환타입-String : 뷰 정보만 반환. 즉 HTML페이지를 브라우저로 전송
	//무조건 접두어,접미어가 붙는다
	@RequestMapping("/ReturnType/String.do")
	public String string(@RequestParam String returnType, Map map) {
		//데이타 저장
		map.put("message", returnType);
		map.put("returnType", returnType);
		
		//뷰 정보 반환
		return "02_returntype/ReturnType";
	}/////////////
	
	//[컨트롤러 메소드] 반환타입-void : @Controller 어노테이션 사용 시 페이지가 아닌 데이타를 보낼 때
	//디스패처 서블릿에게 뷰 및 데이타 정보 반환하지 않으므로 뷰 리졸버가 동작하지 않는다
	//컨드롤러에서 바로 브라우저로 데이타 전송 시
	
	@RequestMapping("/ReturnType/Void.do")
	public void noreturn(@RequestParam String returnType, HttpServletResponse resp) throws IOException {
		/*
		 Ajax나 Rest API 구현 시 주로 사용(단, void 보다는 객체 반환을 주로 사용한다)
		 디스패처 서블릿에게 뷰 및 데이타 정보 반환하지 않으므로 뷰 리졸버가 동작하지 않는다
		 웹브라우저에 바로 출력시 사용
		 즉 Http 응답바디에 데이타 출력시 사용
		 */
		resp.setContentType("application/json");//Json 으로 응답을 받을 땐 ContentType을 'application/json'으로 설정하자
		
		//웹브라우저에 출력하기 위한 출력 스트림 얻기
		PrintWriter out = resp.getWriter();
		out.print(String.format("{\"%s\":\"%s\",\"%s\":\"%s\",\"%s\":\"%s\"}",
						"username","KOSMO",
						"password","1234",
						"parameter",returnType));
		
		//스트림 닫기
		out.close();
	}////////////////
	
	/*
	[컨트롤러 메소드]반환타입-객체 혹은 String(JSON으로 자동으로 변환해서 브라우저로 전송) : @Controller 어노테이션과 @ResponseBody - ***페이지가 아닌 데이타를 보낼때
	뷰리졸버가 동작하지 않는다
	컨트롤러에서 바로 브라우저로 데이타 전송시
	뷰 리졸버 대신 HttpMessageConverter가 작동한다
	String반환시는  StringHttpMessageConverter가 작동해서 JSON으로 변환 처리
	객체 반환시는 JSON으로 변환하는 라이브러리가 작동해서 JSON으로 변환 처리(단, 스프링부트는 JACKSON이 포함되어 있음)
	예를들면 MappingJackson2HttpMessageConverter
	 */
	
	@RequestMapping("/ReturnType/Object.do")
	@ResponseBody //응답바디에서 바로 브라우저로 데이타 전송한다
	//1.String 타입 반환 시 - StringHttpMessageConverter 가 처리
	//public String object(@RequestParam String returnType) throws JsonProcessingException { //뷰 정보가 아니다
		//만약에 자바 객체(자바빈 혹은 컬렉션)를 JSON으로 변환해주는 라이브러리(GSON 혹은 JACKSON)를 사용한다면
		//아래처럼 불편하게 문자열로 JSON형식을 만들 필요가 없다
	/*
		return String.format("{\"%s\":\"%s\",\"%s\":\"%s\",\"%s\":\"%s\"}",
				"username","JACKSON",
				"password","JACKSON1234",
				"parameter",returnType);
	*/
	/*
		ObjectMapper mapper = new ObjectMapper();
		Map<String,String> map = new HashMap<>();
		map.put("username", "GSON");
		map.put("password", "GSON1234");
		map.put("parameter", returnType);
		
		return mapper.writeValueAsString(map);
	*/
	
	/*
	//2.객체 타입 반환 시 -자바빈
	public Member object(@RequestParam String returnType) {
		
		return new Member("BEAN", "BEAN1234", returnType);
	}
	*/
	/*
	//3.객체 타입 반환 시 -컬렉션
	public Map<String, Member> object(@RequestParam String returnType) {
		Map<String, Member> map = new HashMap<>();
		map.put("first", new Member("MAP1", "MAP1234", returnType));
		map.put("second", new Member("MAP2", "MAP5678", returnType));
		
		return map;
		//{"first":{"username":"MAP1","password":"MAP1234","parameter":"Object!!!"},"second":{"username":"MAP2","password":"MAP5678","parameter":"Object!!!"}}
	}
	*/
	
	//4.객체 타입 반환 시 -컬렉션(list)
	public List<Member> object(@RequestParam String returnType) {
		List<Member> list = new Vector<>();
		list.add(new Member("MAP1", "MAP1234", returnType));
		list.add(new Member("MAP2", "MAP5678", returnType));
		
		return list; //자바스크립트의 JSON 배열([])
		//[{"username":"MAP1","password":"MAP1234","parameter":"Object!!!"},{"username":"MAP2","password":"MAP5678","parameter":"Object!!!"}]
	}
	
	static class Member{
		private String username;
		private String password;
		private String parameter;
		
		public Member(String username, String password, String parameter) {
			this.username = username;
			this.password = password;
			this.parameter = parameter;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getParameter() {
			return parameter;
		}

		public void setParameter(String parameter) {
			this.parameter = parameter;
		}
		
	}
	
}
