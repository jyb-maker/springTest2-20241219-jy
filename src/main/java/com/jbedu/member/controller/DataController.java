package com.jbedu.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DataController {

	@RequestMapping(value = "/data")
	public String data(Model model) {  //Model 클래스를 이용한 데이터 전달 
		String name = "홍길동";
		
		model.addAttribute("memberName",name); // name 값을 model객체에 담음 -> name 값이 data.jsp에 전달 
		
		
		return "data";
	}
	
	@RequestMapping(value = "/datamodel")
	public ModelAndView datamodel() { //ModelAndView 클래스를 이용한 데이터 전달 
		// ModelAndView -> view에 전달해줄 값과 view(jsp)파일 이름을 동시에 전달해주는 객체 
		int age = 27; //홍길동의 나이 
		
		ModelAndView mv = new ModelAndView(); // ModelAndView 객체 생성
		mv.addObject("age", age);  // Model 객체에 데이터 담기 
		mv.setViewName("datamodel"); // view 이름(jsp 이름)
		
		return mv;
		
		
	}
	
}
