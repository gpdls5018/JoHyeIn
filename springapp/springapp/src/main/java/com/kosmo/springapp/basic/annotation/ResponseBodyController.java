package com.kosmo.springapp.basic.annotation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/*
	@ResponseBody : 뷰 리졸버를 거치지 않고 직접 브라우저로 출력시 사용.
					페이지가 아닌 데이타 전송시에 사용한다
	                반환 타입은 String으로 한다.
	                데이타 전송 예는 ReturnTypeController.java 참조
	                ※반환되는 문자열이 응답바디에 쓰인다
	@Controller + @ResponseBody는 @RestController와 같다
*/

@Controller
public class ResponseBodyController {
	//레거시에서는 한글이 깨지므로 produces = "text/html; charset=UTF-8" 추가
	//@RequestMapping(value = "/Annotation/ResponseBody.do",produces = "text/html; charset=UTF-8")
	@RequestMapping("/Annotation/ResponseBody.do")
	@ResponseBody
	public String exec() {
		
		return "<script>alert('@ResponseBody로 직접 출력합니다');history.back();</script>";
	}
}
