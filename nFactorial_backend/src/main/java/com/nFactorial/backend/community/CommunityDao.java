package com.nFactorial.backend.community;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class CommunityDao {
	 @Autowired
	 JdbcTemplate jdbcTemplate;
	 
	 //�� ����ϱ�
	 public void registerWriting(String email, String date, CommunityVo communityVo) {
		 String sql = "INSERT INTO community(email, date, part, title, writing) VALUES (?, ?, ?, ?, ?);";
		 try {
				jdbcTemplate.update(sql, email, date, communityVo.getPart(), communityVo.getTitle(), communityVo.getWriting());

			} catch (Exception e) {
				e.printStackTrace();
			}
	 }

	 
	 //�� �����ϱ�
	 public void deleteWriting(String email, String date, String title) {
		 String sql = "DELETE FROM community WHERE email = ? AND date = ? AND title = ?";
		 try {
				jdbcTemplate.update(sql, email, date, title);
			} catch (Exception e) {
				e.printStackTrace();
			}
	 }
	 //�Խñ� ��ü �ҷ�����
	 
	 //��Ʈ�� ����Ʈ �ҷ�����
	 
	
}
