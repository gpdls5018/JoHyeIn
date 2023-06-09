package com.kosmo.springapp.basic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MultiMethodController {
	
	//컨트롤러 메소드(총 4개)
	//@RequestMapping : get,post 둘다 받는다
	@RequestMapping("Controller/MultiMethod/List.do")
	public String list(ModelMap model) {
		//데이타 저장
		model.addAttribute("message", "It request List");
		
		//디스패처 서블릿에게 뷰정보 반환
		return "01_controller/Controller"; //포워딩
	}
	
	@RequestMapping("Controller/MultiMethod/Edit.do")
	public String Edit(ModelMap model) {
		//데이타 저장
		model.addAttribute("message", "It request Edit");
		
		//디스패처 서블릿에게 뷰정보 반환
		return "01_controller/Controller"; //포워딩
	}
	
	@RequestMapping("Controller/MultiMethod/Delete.do")
	public String Delete(ModelMap model) {
		//데이타 저장
		model.addAttribute("message", "It Delete Delete");
		
		//디스패처 서블릿에게 뷰정보 반환
		return "01_controller/Controller"; //포워딩
	}
	
	@RequestMapping("Controller/MultiMethod/View.do")
	public String View(ModelMap model) {
		//데이타 저장
		model.addAttribute("message", "It request View");
		
		//디스패처 서블릿에게 뷰정보 반환
		return "01_controller/Controller"; //포워딩
	}
	
}
