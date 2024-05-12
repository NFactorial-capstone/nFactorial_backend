package com.nFactorial.backend.member;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MemberController {

	@Autowired
	MemberService ms;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String kakaoLogin(@RequestParam(value = "code", required = false) String code) throws Exception {
		String access_Token = ms.getAccessToken(code);
		HashMap<String, Object> userInfo = ms.getUserInfo(access_Token);
		
		System.out.println("###access_Token#### : " + access_Token);
		System.out.println("###nickname#### : " + userInfo.get("nickname"));
		System.out.println("###email#### : " + userInfo.get("email"));
		
		MemberVo memberVo = new MemberVo();
		
        memberVo.setName((String) userInfo.get("nickname"));
        memberVo.setEmail((String) userInfo.get("email")); 
        
        ms.createAccountConfirm(memberVo);
        
        return "member/hi";
	}
}