package com.nFactorial.backend.community;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommunityService {
	@Autowired
	CommunityDao communityDao;
	
	public String registerWriting(CommunityVo communityVo) {
		String result = "";
		result = communityDao.registerWriting(communityVo);
		return result;
	}
	
	public String deleteWriting(String email, String date, String title) {
		String result = "";
		result = communityDao.deleteWriting(email, date, title);
		return result;
	}
	public List<CommunityVo> loadWriting(){
		List<CommunityVo> communityVos = communityDao.loadWriting();
		return communityVos;
	}
	public List<CommunityVo> loadByPart(String part){
		List<CommunityVo> communityVos = communityDao.loadByPart(part);
		return communityVos;
	}
}
