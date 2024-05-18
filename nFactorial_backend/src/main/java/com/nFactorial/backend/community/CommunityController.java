package com.nFactorial.backend.community;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping(value = "/community")
public class CommunityController {
	@Autowired
	CommunityService communityService;
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registerWriting(String email, String date, CommunityVo communityVo) {
		System.out.println("register 성공");
		communityService.registerWriting(email, date, communityVo);
	}
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public void deleteWriting(String email, String date, String title) {
		System.out.println("delete 성공");
		communityService.deleteWriting(email, date, title);
	}
	
}
