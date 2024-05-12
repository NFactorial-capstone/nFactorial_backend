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
					foodVo.setKcal(rs.getInt("ml_g"));
					foodVo.setProtein(rs.getFloat("protein"));
					foodVo.setFat(rs.getFloat("fat"));
					foodVo.setCarbs(rs.getFloat("carbs"));
					
					System.out.println(foodVo.getCarbs());
					return foodVo;
				}
			}, foodName);
			System.out.println("foodName : " + foodName);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return foodVos;
	}
}
