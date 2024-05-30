package com.nFactorial.backend.community;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommunityService {
	@Autowired
	CommunityDao communityDao;
	
	public void registerWriting(CommunityVo communityVo) {
		communityDao.registerWriting(communityVo);
	}
	
	public void deleteWriting(String email, String date, String title) {
		communityDao.deleteWriting(email, date, title);
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
