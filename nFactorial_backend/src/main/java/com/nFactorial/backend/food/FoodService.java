package com.nFactorial.backend.food;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodService {

	@Autowired
	FoodDao foodDao;
	
	public List<FoodVo> searchFood(String foodName) {
		
		List<FoodVo> searchedFoods = foodDao.searchFood(foodName);
		
		return searchedFoods;
	}
	
	public int registerFoodPlan(FoodVo foodvo) {
		
		int result = 0;
		foodDao.registerFoodPlan(foodvo);
		
		
		return result;
	}
	
	public List<FoodVo> loadFoodPlan(String email, String date) {
		List<FoodVo> foodvos = foodDao.loadFoodPlan(email, date);
		
		return foodvos;
	}
	
	public int deleteFoodData(FoodVo foodvo) {
		
		int delResult = foodDao.deleteData(foodvo);
		
		return delResult ;
	}
}
