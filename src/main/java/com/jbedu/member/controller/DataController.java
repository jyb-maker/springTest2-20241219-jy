package com.jbedu.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DataController {
	
	@RequestMapping(value = "/data")
	public String data(Model model) { //Model 클래스를 이용한 데이터 전달
		String name = "홍길동";
		
		model.addAttribute("memberName", name); //name 값을 model객체에 담음 -> data.jsp에 전달
		
		return "data";
	}
	
	@RequestMapping(value = "/datamodel")
	public ModelAndView datamodel() { //ModelAndView 클래스를 이용한 데이터 전달
		//ModelAndView->view에 전달해줄 값과 view(jsp)파일 이름을 동시에 전달해주는 객체
		int age = 27;//홍길동의 나이
		
		ModelAndView mv = new ModelAndView(); //ModelAndView 객체 생성
		mv.addObject("age", age);//Model 객체에 데이터 담기
		mv.setViewName("datamodel");//view 이름(jsp 이름)
		
		return mv;
		
	}
	
	@RequestMapping(value = "/login") //login.jsp를 실행시켜주는 역할만!
	public String login() {
		
		return "login";
	}
	
	@RequestMapping(value = "/login2") //login2.jsp를 실행시켜주는 역할만!
	public String login2() {
		
		return "login2";
	}
	
	@RequestMapping(value = "/login3") //login3.jsp를 실행시켜주는 역할만!
	public String login3() {
		
		return "login3";
	}
	
	@RequestMapping(value = "/confirmID") //클라이언트의 로그인 요청을 여기서 catch!(파라미터 값도 함께)
	public String confirmID(HttpServletRequest request, Model model) {
		
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		
//		if(mid.equals("tiger") && mpw.equals("12345")) {
//			model.addAttribute("idcheck", "memberOk");
//		} else {
//			model.addAttribute("idcheck", "memberNo");
//		}
		
		model.addAttribute("loginid", mid);
		model.addAttribute("loginpw", mpw);
		
		return "confirmID";
	}
	
	@RequestMapping(value = "/checkID", method = RequestMethod.POST) //클라이언트의 로그인 요청을 여기서 catch!(파라미터 값도 함께)
	public String checkID(HttpServletRequest request, Model model) {
		
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		
		if(mid.equals("tiger") && mpw.equals("12345")) { //로그인 성공
			model.addAttribute("idcheck", "memberOk");
			model.addAttribute("loginid", mid);
			model.addAttribute("loginpw", mpw);
		} else { //로그인 실패
			model.addAttribute("idcheck", "memberNo");
		}
		return "checkID";
	}
	
	@RequestMapping(value = "/checkID2") //클라이언트의 로그인 요청을 여기서 catch!(파라미터 값도 함께)
	public String checkID2(@RequestParam("mid") String mid, @RequestParam("mpw") String mpw, Model model) {
		
//		String mid = request.getParameter("mid");
//		String mpw = request.getParameter("mpw");
		
		if(mid.equals("tiger") && mpw.equals("12345")) { //로그인 성공
			model.addAttribute("idcheck", "memberOk");
			model.addAttribute("loginid", mid);
			model.addAttribute("loginpw", mpw);
		} else { //로그인 실패
			model.addAttribute("idcheck", "memberNo");
		}
		return "checkID";
	}
	
	
	
	
	
	
	
	
	

}