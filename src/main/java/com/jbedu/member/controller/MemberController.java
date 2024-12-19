package com.jbedu.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller  //어노테이션 Controller->컨트롤러 클래스로 지정
@RequestMapping("/sports")
public class MemberController {
		
	@RequestMapping(value = "/")   // root 요청
	public String index() {
		return "index";
	}
	
	@RequestMapping(value = "/baseball")   // value값 -> 요청(request) 값
	public String baseball() {
		return "sports/baseball";
	}

	@RequestMapping(value = "/soccer")   // value값 -> 요청(request) 값
	public String soccer() {
		return "sports/soccer";
	}	
}




















