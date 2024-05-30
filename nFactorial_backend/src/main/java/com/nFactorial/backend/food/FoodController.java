package com.nFactorial.backend.food;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/food")
public class FoodController {

	@Autowired
	FoodService foodService;

	
	@RequestMapping(value = "/search", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public List<FoodVo> searchFood(String name) {
        System.out.println("searchFood up! " + name);
        
        List<FoodVo> searchedFoods = foodService.searchFood(name);
        return searchedFoods;
    }
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
	public String registerFoodPlan(FoodVo foodvo) {
		String result = "";
		
		System.out.println("registerFoodplan up! " +  foodvo.toString());
		
		System.out.println("Date: " + foodvo.getDate() + " ammount: " + foodvo.getMl_g() + " FoodVo: " + foodvo.getFoodName() + foodvo.getKcal());
		result = foodService.registerFoodPlan(foodvo);
		return result;
	}
	
	@RequestMapping(value = "/load", method = RequestMethod.POST)
	@ResponseBody
	public List<FoodVo> loadFoodPlan(String email, String date) {
		List<FoodVo> foodvos = foodService.loadFoodPlan(email, date);
		
		return foodvos;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public String deleteData(FoodVo foodvo) {
		String result = "";
		System.out.println("changeDataCon!");
		System.out.println(foodvo.getEmail() + foodvo.getDate() + foodvo.getFoodName());
		
		result = foodService.deleteFoodData(foodvo);
		return result;
	}
	
}
