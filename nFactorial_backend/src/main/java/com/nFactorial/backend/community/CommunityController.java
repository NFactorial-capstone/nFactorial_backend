package com.nFactorial.backend.community;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(value = "/community")
public class CommunityController {
	@Autowired
	CommunityService communityService;
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
	public String registerWriting(CommunityVo communityVo) {
		String result = "";
		System.out.println("register ����");
		result = communityService.registerWriting(communityVo);
		return result;
	}
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public String deleteWriting(String email, String date, String title) {
		String result = "";
		System.out.println("delete ����");
		result = communityService.deleteWriting(email, date, title);
		return result;
	}
	
	@RequestMapping(value = "/load", method = RequestMethod.POST)
	@ResponseBody
	public List<CommunityVo> loadWriting(){
		System.out.println("load ����");
		List<CommunityVo> writings = communityService.loadWriting();
		return writings;
	}
	@RequestMapping(value = "/load/part", method = RequestMethod.POST)
	@ResponseBody
	public List<CommunityVo> loadByPart(String part){
		System.out.println("loadByPart ����");
		List<CommunityVo> writings = communityService.loadByPart(part);//part����
		return writings;
	}
}
