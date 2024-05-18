package com.nFactorial.backend.community;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommunityService {
	@Autowired
	CommunityDao communityDao;
	
	public void registerWriting(String email, String date, CommunityVo communityVo) {
		communityDao.registerWriting(email, date, communityVo);
	}
	
	public void deleteWriting(String email, String date, String title) {
		communityDao.deleteWriting(email, date, title);
	}
	
}
