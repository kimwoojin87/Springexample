package com.kitri.member.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.kitri.member.model.MemberDetailDto;
import com.kitri.member.model.MemberDto;
import com.kitri.member.model.service.MemberService;


@Controller
@RequestMapping("/user")
@SessionAttributes("userInfo")
//@SessionAttributes(names = {"userInfo","b","c"}) 세션처리할 게 많을때는 이런 식으로.
public class MemberController {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	//@Qualifier("Impl")
	@Autowired
	private MemberService memberService;
	
	//데이터를 가져갈 필요없는 단순 페이지 이동시 Setview에 해당하는 view페이지 이름String만 리턴
	@RequestMapping(value = "/register.kitri", method=RequestMethod.GET)
	public String register() {
		return "user/member/member";
	}
	
	@RequestMapping(value = "/register.kitri", method=RequestMethod.POST)
	public String register(MemberDetailDto memberDetailDto, Model model) {
		int cnt = memberService.registerMember(memberDetailDto);
		if(cnt != 0) {
			model.addAttribute("registerInfo", memberDetailDto);
			return "user/member/registerok";
		}
		return "user/member/registerfail";
	}
	
	@RequestMapping(value = "/idcheck.kitri", method=RequestMethod.GET)
	public @ResponseBody String idCheck(@RequestParam(name = "checkid", defaultValue = "") String id) {
		logger.info("검색아이디 : " + id);
		String json = memberService.idCheck(id);
		return json;//WEB-INF/views/{"idcount":0}.jsp
	}
	
	@RequestMapping("/zipsearch.kitri")
	@ResponseBody
	public String zipsearch(@RequestParam("doro") String doro) {
		//logger.info("검색아이디 : " + doro);
		String json = memberService.zipSearch(doro);
		return json;
	}
	
	
	@RequestMapping(value = "/login.kitri", method = RequestMethod.GET)
	public String login() {
		return "user/login/login";
	}
	
//	@RequestMapping(value = "/login.kitri", method = RequestMethod.POST)
//	public String login(@RequestParam("id") String id ,
//			@RequestParam("pass") String pass , HttpSession session) {
//		MemberDto memberDto = memberService.loginMember(id, pass);
//		if(memberDto != null) {
//			session.setAttribute("userInfo", memberDto);
//			return "user/login/loginok";
//		}else {
//			return "user/login/loginfail";
//		}
//	}
	
	@RequestMapping(value = "/login.kitri", method = RequestMethod.POST)
	public String login(@RequestParam Map<String, String> map, Model model) {
		MemberDto memberDto = memberService.loginMember(map);
		if(memberDto != null) {
			model.addAttribute("userInfo", memberDto);
			return "user/login/loginok";
		}else {
			return "user/login/loginfail";
		}
	}
	
//	@RequestMapping("/logout.kitri")
//	public String logout(HttpSession session) {
//		session.removeAttribute("userInfo");
//		return "redirect:/index.jsp";
//	} 세션정보를 모델에 담았으므로 스프링에 있는 SessionStatus의 setComplete()를 이용해야 세션처리를 할 수있다.
	
	@RequestMapping("/logout.kitri")
	public String logout(@ModelAttribute("userInfo") MemberDto memberDto, SessionStatus sessionStatus) {
			sessionStatus.setComplete();
			return "redirect:/index.jsp";
	}
}







