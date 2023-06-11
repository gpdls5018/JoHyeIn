package com.kosmo.springapp.basic.validation;

import java.util.Arrays;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ValidationController {
	
	@PostMapping("/Validation/Validation.do")
	//매개변수 순서: ***FormCommand 다음에 Errors 순으로
	public String validate(@Valid FormCommand form, Errors errors, Model model) {
		//FormCommand의 필드 중 어느 하나라도 유효성에 실패한다면 
		//Errors 객체의 hasErrors() 메소드는 true를 반환한다
		
		//체크박스는 무조건 여러개 선택하더라도 첫번째 것만 포워드된다
		model.addAttribute("inter", form.getInter());  
		//System.out.println(Arrays.toString(form.getInter()));
		
		if(errors.hasErrors()) { //유효성 통과 하지 못할 때
			
			for(FieldError value : errors.getFieldErrors()) {
				System.out.println(value.getField()+" : "+value.getDefaultMessage());
			}
			
			//유효성 검증 실패 시 다시 입력 폼으로 포워드
			return "07_validation/Validation";
		}
		
		//유효성 검증 성공 시 결과 출력 페이지로 포워드
		return "07_validation/ValidationResult";
	}
}
