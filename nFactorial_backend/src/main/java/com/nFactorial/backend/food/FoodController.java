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

	
	@RequestMapping(value = "/search", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<FoodVo> searchFood(String name) {
        System.out.println("searchFood up! " + name);
        
        List<FoodVo> searchedFoods = foodService.searchFood(name);
        return searchedFoods;
    }
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registerFoodPlan(String email, String date, int ammount, FoodVo foodvo) {
		System.out.println("registerFoodplan up!");
		System.out.println("Date: " + date + " ammount: " + ammount + " FoodVo: " + foodvo.getFoodName() + foodvo.getKcal());
		foodService.registerFoodPlan(email, date, ammount, foodvo);
	}
	
	@RequestMapping(value = "/load", method = RequestMethod.GET)
	@ResponseBody
	public List<FoodVo> loadFoodPlan(String email, String date) {
		List<FoodVo> foodvos = foodService.loadFoodPlan(email, date);
		
		return foodvos;
	}
	
}
