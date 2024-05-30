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
	 
	 //글 등록하기
	 public String registerWriting(CommunityVo communityVo) {
		 String sql = "INSERT INTO community(email, date, part, title, writing) VALUES (?, ?, ?, ?, ?);";
		 try {
				jdbcTemplate.update(sql, communityVo.getEmail(), communityVo.getDate(), communityVo.getPart(), communityVo.getTitle(), communityVo.getWriting());
				return "Success";
			} catch (Exception e) {
				e.printStackTrace();
				return "Fail";
			}
	 }

	 
	 //글 삭제하기
	 public String deleteWriting(String email, String date, String title) {
		 String sql = "DELETE FROM community WHERE email = ? AND date = ? AND title = ?";
		 try {
				jdbcTemplate.update(sql, email, date, title);
				return "Success";
			} catch (Exception e) {
				e.printStackTrace();
				return "Fail";
			}
	 }
	 //게시글 전체 불러오기
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
	 //파트별 리스트 불러오기
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
