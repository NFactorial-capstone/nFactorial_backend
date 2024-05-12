package com.nFactorial.backend.food;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodService {

	@Autowired
	FoodDao foodDao;
	
	public JSONObject searchFood(String foodName) {
		// JSONObject made of variety of food json datas.
		JSONObject searchedFoodsJson = new JSONObject();
		// JSONObject with a single food data.
		JSONObject foodJson;
		int cnt = 1;
		
		List<FoodVo> searchedFoods = foodDao.searchFood(foodName);
		
		searchedFoodsJson.put("count", searchedFoods.size());
		System.out.println("searchedFoods length : " + searchedFoods.size());
		System.out.println(searchedFoods);
		
		for(FoodVo foodVo: searchedFoods) {
			foodJson = new JSONObject();
			foodJson.put("foodName", foodVo.getFoodName());
			foodJson.put("kcal", foodVo.getKcal());
			foodJson.put("protein", foodVo.getProtein());
			foodJson.put("fat", foodVo.getFat());
			foodJson.put("carbs", foodVo.getCarbs());
			searchedFoodsJson.put(Integer.toString(cnt), foodJson);
			cnt ++;
		}
		return searchedFoodsJson;
	}
}
