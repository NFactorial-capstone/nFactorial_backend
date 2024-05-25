package com.nFactorial.backend.food;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class FoodDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<FoodVo> searchFood(String foodName) {
		
		String sql = "SELECT * FROM fooddata WHERE name like CONCAT('%', ? , '%');";
		
		List<FoodVo> foodVos = new ArrayList<FoodVo>();
		
		try {
			foodVos = jdbcTemplate.query(sql, new RowMapper<FoodVo>() {
				
				@Override
				public FoodVo mapRow(ResultSet rs, int rowNum) throws
				SQLException {
					FoodVo foodVo = new FoodVo();
					
					foodVo.setFoodName(rs.getString("name"));
					foodVo.setKcal(rs.getInt("kcal"));
					foodVo.setProtein(rs.getFloat("protein"));
					foodVo.setFat(rs.getFloat("fat"));
					foodVo.setCarbs(rs.getFloat("carbs"));
					
					return foodVo;
				}
			}, foodName);
			System.out.println("foodName : " + foodName);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return foodVos;
	}
	
	public int registerFoodPlan(FoodVo foodvo) {
//		(email, date, name, ml_g, kcal, protein, fat, carbs)
		String sql = "INSERT INTO foodPlan(email, date, name, ml_g, kcal, protein, fat, carbs) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
		
		try {
			jdbcTemplate.update(sql, foodvo.getEmail(), foodvo.getDate(), foodvo.getFoodName(), foodvo.getMl_g(), foodvo.getKcal(), foodvo.getProtein(), foodvo.getFat(), foodvo.getCarbs());
			return 1;
		} catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public List<FoodVo> loadFoodPlan(String email, String date) {
		String sql = "Select * from foodPlan where email=? && date=?";
		List<FoodVo> foodvos = new ArrayList<FoodVo>();
		try {
			foodvos = jdbcTemplate.query(sql, new RowMapper<FoodVo>() {
				
				@Override
				public FoodVo mapRow(ResultSet rs, int rowNum) throws
				SQLException {
					FoodVo foodVo = new FoodVo();
					foodVo.setEmail(rs.getString("email"));
					foodVo.setDate(rs.getString("date"));
					foodVo.setFoodName(rs.getString("name"));
					foodVo.setKcal(rs.getInt("kcal"));
					foodVo.setMl_g(rs.getInt("ml_g"));
					foodVo.setProtein(rs.getFloat("protein"));
					foodVo.setFat(rs.getFloat("fat"));
					foodVo.setCarbs(rs.getFloat("carbs"));
					
					return foodVo;
				}
			},email, date);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return foodvos;
	}
	
	public int deleteData(FoodVo foodvo) {
		String sql = "DELETE FROM foodplan WHERE email = ? AND date = ? AND name = ?";
		
		try {
			jdbcTemplate.update(sql, foodvo.getEmail(), foodvo.getDate(), foodvo.getFoodName());
			return 1;
		} catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
}
