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
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String kakaoLogin(@RequestParam(value = "code", required = false) String code, HttpSession session) throws Exception {
		String access_Token = ms.getAccessToken(code);
		HashMap<String, Object> userInfo = ms.getUserInfo(access_Token);

		System.out.println("###nickname#### : " + userInfo.get("nickname"));
		System.out.println("###email#### : " + userInfo.get("email"));
		
		MemberVo memberVo = new MemberVo();
        memberVo.setName((String) userInfo.get("nickname"));
        memberVo.setEmail((String) userInfo.get("email")); 
        
        session.setAttribute("email",  userInfo.get("email"));
        session.setMaxInactiveInterval(60 * 30);
        
        System.out.println(session.getAttribute("email"));
        ms.createAccountConfirm(memberVo);
        
        return "member/hi";
	}
	@RequestMapping(value = "/login/load", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<MemberVo> loadMember(String email) {
		System.out.println("load ¼º°ø");
		List<MemberVo> memberVo = ms.loadMember(email);
		return memberVo;
	}
}