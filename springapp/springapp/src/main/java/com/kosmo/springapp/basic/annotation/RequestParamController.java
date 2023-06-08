package com.kosmo.springapp.basic.annotation;

import java.util.Arrays;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.yaml.snakeyaml.error.MissingEnvironmentVariableException;

@Controller
@RequestMapping("/Annotation/")
public class RequestParamController {
	
	/*[ 파라미터 받기 ]*/	
	 /*
	  *  파라미터를 받기 위해 HttpServletRequest 사용 안하고
	  *  @RequestParam어노테이션 사용
	  *
	  * -파라미터의 자료형으로 받을 수 있다(String이나 int로 즉 형변환 불필요)
	  * -파라미터가 여러개일때는
	  *  @ModelAttribute어노테이션이나 @RequestParam Map map이 유리
	  *  단,Map으로 받을 때 체크박스류는 여러 개 값 중 하나만	 
	  *
	  * -사용자가 전달한 파라미터 값이 매개변수에 저장됨
	  *  즉 매개변수명=리퀘스트객체.getParameter("파라미터명")와 같다
	  *
	  * -required속성은 디폴트가 true이다
	  *  만약 파라미터명이 매개변수 명과 다르다면
	  *
	  *  방법1]
	  *  @RequestParam(value="파라미터명") 자료형 매개변수명 -
	  *  required가 true
	  *  해당 파라미터명으로 전달이 안되면 에러(400에러)
	  *
	  *  방법2]
	  *   @RequestParam(value="파라미터명",required=false) 자료형 매개변수명
	  *   해당 파라미터명으로 전달이 안되도 필수가 아니기때문에
	  *   에러안남  *
	  */
	
	@ExceptionHandler(Exception.class)//반드시 .class 해야한다
	public String error(Model model, Exception e) {
		if(e instanceof MissingEnvironmentVariableException) {
			model.addAttribute("error", "파라미터가 전달되지 않았어요:"+e.getMessage());
		}
		else if(e instanceof MethodArgumentTypeMismatchException) {
			model.addAttribute("error", "나이는 숫자만...:"+e.getMessage());
		}
		else
			model.addAttribute("error", "관리자에게 문의...:"+e.getMessage());
		
		//뷰정보 반환
		return "04_annotation/Annotation";
	}
	
	//컨트롤러 메소드-파라미터명과 변수 일치 시
	@RequestMapping("RequestParamEqual.do")
	public String equals(@RequestParam() String name, @RequestParam int age, Model model) {//형변환할 필요 X
		//데이타 저장
		model.addAttribute("name", name);
		model.addAttribute("age", age+10);
		
		//뷰정보 반환
		return "04_annotation/Annotation";
	}
	
	//컨트롤러 메소드-파라미터명과 변수 불일치 시
	@RequestMapping("RequestParamDiff.do")
	public String diff(@RequestParam(value = "username",required = false, defaultValue = "파라미터가 안 넘어옴") String name, @RequestParam(value = "years") int age, Model model) {//형변환할 필요 X
		//데이타 저장
		model.addAttribute("name", name);
		model.addAttribute("age", age+10);
			
		//뷰정보 반환
		return "04_annotation/Annotation";
	}
	
	//컨트롤러 메소드-Map으로 파라미터 받기
	//단, 체크박스는 여러 개 선택해도 하나만 받는다(이 때는 @RequestParam String[] 변수 하나 더 추가)
	@RequestMapping("RequestParamMap.do")
	public String map(@RequestParam Map paramMap, Model model, @RequestParam String[] inter) {
		//맵으로 파라미터를 받을 시 
		//폼의 파라미터명이 KEY값이 되고 입력하거나 선택한 값이 VALUE가 된다
		//단, 체크박스류는 무조건 첫번째 선택한 것만 저장된다
		System.out.println("관심사항(Map으로 받을 때):"+paramMap.get("inter"));
		System.out.println("관심사항(String[]으로 받을 때):"+Arrays.toString(inter));
		
		//데이타 저장
		paramMap.put("inter", Arrays.toString(inter)); //덮어쓰기
		model.addAllAttributes(paramMap);
		
		//뷰정보 반환
		return "04_annotation/Annotation";
	}
}
