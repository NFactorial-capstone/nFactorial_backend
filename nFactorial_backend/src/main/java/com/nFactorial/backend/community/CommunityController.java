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
	public void registerWriting(String email, String date, CommunityVo communityVo) {
		System.out.println("register ����");
		communityService.registerWriting(email, date, communityVo);
	}
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public void deleteWriting(String email, String date, String title) {
		System.out.println("delete ����");
		communityService.deleteWriting(email, date, title);
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
		List<CommunityVo> writings = communityService.loadByPart("2");//part����
		return writings;
	}
}
