package com.nFactorial.backend.member;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MemberController {

	@Autowired
	MemberService ms;
	
	MemberVo membervo = new MemberVo();
//	@RequestMapping(value = "/login", method = RequestMethod.GET)
//	public void kakaoLogin(@RequestParam(value = "code", required = false) String code, HttpSession session) throws Exception {
//		String access_Token = ms.getAccessToken(code);
//		HashMap<String, Object> userInfo = ms.getUserInfo(access_Token);
//
//		System.out.println("###nickname#### : " + userInfo.get("nickname"));
//		System.out.println("###email#### : " + userInfo.get("email"));
//		
//		MemberVo memberVo = new MemberVo();
//        memberVo.setName((String) userInfo.get("nickname"));
//        memberVo.setEmail((String) userInfo.get("email")); 
//        
//        session.setAttribute("userinfo",  memberVo);
//        
//        session.setMaxInactiveInterval(60 * 30);
//        
//        ms.createAccountConfirm(memberVo);
//        
//	}
	@RequestMapping(value = "/member/load", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public MemberVo loadMember(@RequestParam("sessionId") String sessionId, HttpSession session) {
		System.out.println("load ¼º°ø");
		membervo = (MemberVo) session.getAttribute("member");
		return membervo;
	}
	
	@RequestMapping(value = "member/login", method = RequestMethod.POST)
	@ResponseBody
	public String login(MemberVo membervo) {
		int result = ms.loginCheck(membervo);
		if(result == 1) {
			return "pass";
		} else {
			return "fail";
		}
	}
	
	@RequestMapping(value = "/member/register", method = RequestMethod.POST) 
	@ResponseBody
	public String register(MemberVo memberVo) {
		int result = ms.createAccountConfirm(memberVo);
		if(result == 1)
			return "Pass";
		else if(result == 0)
			return "Fail";
		else
			return "Account already exist";
	}
}