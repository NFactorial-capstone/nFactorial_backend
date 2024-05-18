package com.nFactorial.backend.community;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class CommunityDao {
	 @Autowired
	 JdbcTemplate jdbcTemplate;
	 
	 //글 등록하기
	 public void registerWriting(String email, String date, CommunityVo communityVo) {
		 String sql = "INSERT INTO community(email, date, part, title, writing) VALUES (?, ?, ?, ?, ?);";
		 try {
				jdbcTemplate.update(sql, email, date, communityVo.getPart(), communityVo.getTitle(), communityVo.getWriting());

			} catch (Exception e) {
				e.printStackTrace();
			}
	 }

	 
	 //글 삭제하기
	 public void deleteWriting(String email, String date, String title) {
		 String sql = "DELETE FROM community WHERE email = ? AND date = ? AND title = ?";
		 try {
				jdbcTemplate.update(sql, email, date, title);
			} catch (Exception e) {
				e.printStackTrace();
			}
	 }
	 //게시글 전체 불러오기
	 
	 //파트별 리스트 불러오기
	 
	
}
