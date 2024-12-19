package com.jbedu.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jbedu.member.dto.MemberDto;

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
	
	@RequestMapping(value = "/join")
	public String join() {
		return "join";
	}
	
	@RequestMapping(value = "/join2")
	public String join2() {
		return "join2";
	}
	
	@RequestMapping(value = "/joinOk")
	public String joinOk(HttpServletRequest request, Model model) {
		
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		String mname = request.getParameter("mname");
		String memail = request.getParameter("memail");
		
		MemberDto memberDto = new MemberDto(mid, mpw, mname, memail);
		
		model.addAttribute("memberDto", memberDto); //model에 dto 실어 보내기
		
//		model.addAttribute("mid", mid);
//		model.addAttribute("mpw", mpw);
//		model.addAttribute("mname", mname);
//		model.addAttribute("memail", memail);
		
		return "joinOk";
	}
	
//	@RequestMapping(value = "/joinOk2")
//	public String joinOk2(MemberDto memberDto, Model model) {		
//		
//		//model.addAttribute("memberDto", memberDto); //model에 dto 실어 보내기
//		
//		return "joinOk";
//	}
	
	@RequestMapping(value = "/joinOk2")
	public String joinOk2(@ModelAttribute("dto") MemberDto memberDto, Model model) {		
		//memberDto 객체의 이름을 dto로 변경하여 model 객체에도 dto 이름으로 memberDto객체를 실어 보냄
		//DTO 클래스의 이름이 너무 길어서 불편할 때 이름 변경 
		
		return "joinOk2";
	}
	
	@RequestMapping(value = "/page/{pagevalue}") //javascript 등으로 넘어오는 매개 변수 형식 
	public String pagevalue(@PathVariable String pagevalue, Model model) {
		model.addAttribute("page", pagevalue);
		return "page";
	}
	
	@RequestMapping(value = "/redirect")
	public String redirect() {
		return "redirect";
	}
	
	@RequestMapping(value = "/redirectGood")
	public String redirectOk(@RequestParam("number") String number, Model model) {
		
		int number_int = Integer.parseInt(number);//문자->정수 변환
		
		if(number_int > 10) {
			model.addAttribute("number", number);
			return "redirectOk";//jsp 파일을 실행시켜라!
			//return "redirect:redirectOk" -> 새로운 요청으로 redirectOk 요청이 서버에 전달됨
		} else {
			model.addAttribute("number", "0000");
			return "redirectNo";
		}
	}
	
	@RequestMapping(value = "/redirectOk") //redirectOk.jsp 매핑
	public String redirectGood(Model model) {
		
		model.addAttribute("number", "안녕하세요!!");
		
		return "redirectOk";
	}
	
	
}