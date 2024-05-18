package com.nFactorial.backend.community;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.nFactorial.backend.exercise.ExerciseVo;

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
	 public List<CommunityVo> loadWriting(){
		 List<CommunityVo> communityVos = new ArrayList<>();
		 String sql = "SELECT * FROM community";
		 try {
			 communityVos = jdbcTemplate.query(sql, new RowMapper<CommunityVo>() {
					@Override
					public CommunityVo mapRow(ResultSet rs, int rowNum) throws SQLException {
						CommunityVo communityVo = new CommunityVo();
						communityVo.setEmail(rs.getString("email"));
						communityVo.setDate(rs.getString("date"));
						communityVo.setPart(rs.getString("part"));
						communityVo.setTitle(rs.getString("title"));
						communityVo.setWriting(rs.getString("writing"));
						return communityVo;
					}
				});

			} catch (Exception e) {
				e.printStackTrace();
			}
			return communityVos;
	 }
	 //��Ʈ�� ����Ʈ �ҷ�����
	 public List<CommunityVo> loadByPart(String part){
		 List<CommunityVo> communityVos = new ArrayList<>();
		 String sql = "SELECT * FROM community WHERE part = ?";
		 try {
			 communityVos = jdbcTemplate.query(sql, new RowMapper<CommunityVo>() {
					@Override
					public CommunityVo mapRow(ResultSet rs, int rowNum) throws SQLException {
						CommunityVo communityVo = new CommunityVo();
						communityVo.setEmail(rs.getString("email"));
						communityVo.setDate(rs.getString("date"));
						communityVo.setPart(rs.getString("part"));
						communityVo.setTitle(rs.getString("title"));
						communityVo.setWriting(rs.getString("writing"));
						return communityVo;
					}
				},part);
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		 return communityVos;
	 }
	
}
