package com.nFactorial.backend.food;

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
	
	public void registerFoodPlan(String email, String date, int ammount, FoodVo foodvo) {
		
		foodDao.registerFoodPlan(email, date, ammount, foodvo);
	}
	
	public List<FoodVo> loadFoodPlan(String email, String date) {
		List<FoodVo> foodvos = foodDao.loadFoodPlan(email, date);
		
		return foodvos;
	}
}
