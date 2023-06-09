package com.kosmo.springapp.basic.annotation;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/*
	@RestController : 주로 데이타만 보낼때(@Controller + @ResponseBody와 같다)
	@Controller : 주로 페이지를 보낼때
	@RequestBody : 클라이언트로부터 'JSON 형식의 데이타' 받을 때 사용.
					스프링 부트는 내장되어 있다(Jackson 라이브러리)
				   	스프링 레거시는 내장되어 있지 않다
				   	
	Jackson 라이브러리 : 자바 객체(DTO계열 혹은 컬렉션)를 JSON형식(자스 객체)으로
	                  JSON형식(자스 객체)을 자바객체로 변환시켜주는 라이브러리

	※****************************************
	1) @RequestParam 혹은 커맨드 객체로 데이타 받기
			- Form 및 A링크로 보내는 데이타(KEY=VALUE형태:id=KIM&pwd=1234) : 정상적으로 받는다
		  	
		  	- 자바스크립트로 JSON형식을 보내는 데이타({"id":"KIM","pwd":"1234"})(key=value 쌍이 아닌):
		  								파라미터를 받지 못한다.
		                                클라이언트에서 보내는 JSON 데이타를 정상적으로 받지 못하므로 null이다
	  
	1) @RequestBody 커맨드객체 변수 
			혹은 
	   @RequestBody Map 변수
	  
	  형식으로 데이터 받기(단, @RequestBody String 변수(문자열)로 받아도 되나 파싱해야 한다)
	   
		   - Form 및 A링크로 보내는 데이타 : 
		   			415에러(Content type 'application/x-www-form-urlencoded;charset=UTF-8' not supported)
		   			
		   - JSON 형식데이타 : 
		   			정상적으로 받는다. 
		   			*****즉 JSON 형식데이타는 무조건 @RequestBody 사용하자.
*/

@Controller
public class RequestBodyController {
	
	@RequestMapping("/Annotation/RequestBody.do")
	@ResponseBody
	/*
	1.@RequestParam 으로 받을 때
	form 태그: 정상
	자바스크립트의 JSON 형식의 데이타:
			받지 못한다
			단, key=value 형식은 잘 받는다
	*/
	/*
	public String requestParam(@RequestParam Map paramMap) throws JsonProcessingException {
		
		ObjectMapper mapper = new ObjectMapper();
		Map jmap = new HashMap();
		
		jmap.put("id", paramMap.get("id"));
		jmap.put("pwd", paramMap.get("pwd"));
		
		return mapper.writeValueAsString(jmap); //무조건 ""로 감싸자
	}
	*/
	
	/*
	2.커맨드 객체로 받을 때
	form 태그: 정상
	자바스크립트의 JSON 형식의 데이타:
			받지 못한다
			단, key=value 형식은 잘 받는다
	*/
	/*
	public String command(AuthenticationCommand auth) throws JsonProcessingException {
		
		System.out.println("아이디:"+auth.getId());
		ObjectMapper mapper = new ObjectMapper();
		Map jmap = new HashMap();
		
		jmap.put("id", auth.getId());
		jmap.put("pwd", auth.getPwd());
		
		return mapper.writeValueAsString(jmap); //무조건 ""로 감싸자
	}
	*/
	/*
	3.@ResponseBody로 받을 때
	form 태그: 415에러
	자바스크립트의 JSON 형식의 데이타:
			정상적으로 잘 받는다.
	*/
	/*
	//커맨드 객체
	public String responseBody(@RequestBody AuthenticationCommand auth) throws JsonProcessingException {
		
		System.out.println("아이디:"+auth.getId());
		ObjectMapper mapper = new ObjectMapper();
		Map jmap = new HashMap();
		
		jmap.put("id", auth.getId());
		jmap.put("pwd", auth.getPwd());
		
		return mapper.writeValueAsString(jmap); //무조건 ""로 감싸자
	}
	*/
	/*
	public String responseBody(@RequestBody Map paramMap) throws JsonProcessingException {
		
		ObjectMapper mapper = new ObjectMapper();
		Map jmap = new HashMap();
		
		jmap.put("id", paramMap.get("id"));
		jmap.put("pwd", paramMap.get("pwd"));
		
		return mapper.writeValueAsString(jmap); //무조건 ""로 감싸자
	}
	*/
	/*
	//***String으로 반환할 필요 없이 바로 커맨드 객체나 맵 컬렉션을 반환하면 된다
	//jackson 라이브러리가 변환한다
	
	public Map responseBody(@RequestBody Map paramMap) {
		
		return paramMap; //무조건 ""로 감싸자
	}
	*/
	
	
	public AuthenticationCommand responseBody(@RequestBody AuthenticationCommand auth) {
		
		return auth; //무조건 ""로 감싸자
	}
}
