package com.kosmo.springapp.basic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OneMethodParamController {
	
	@RequestMapping("Controller/OneClassParam/Crud.do")
	public String param(Model model, @RequestParam String crud) {
		
		//데이타 저장
		switch(crud.toUpperCase()) {
			case "LIST": model.addAttribute("message", "Read All request"); break;
			case "EDIT": model.addAttribute("message", "Update request"); break;
			case "DELETE": model.addAttribute("message", "Delete request"); break;
			default:  model.addAttribute("message", "Read One request");
		}
		
		//디스패처 서블릿에게 뷰정보 반환
		return "01_controller/Controller"; //포워딩
	}
}
