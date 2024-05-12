package com.nFactorial.backend.food;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FoodController {

	@Autowired
	FoodService foodService;
	
//	@RequestMapping(value = "/food/search", method = RequestMethod.GET)
//	public JSONObject searchFood(JSONObject jObject) {
//		String foodName = jObject.getString("name");
//		
//		JSONObject searchedFoodsJson = foodService.searchFood(foodName);
//		
//		return searchedFoodsJson;
//	}
	
	@RequestMapping(value = "/food/search", method = RequestMethod.GET)
	public String searchFood(@RequestParam("foodName") String name, Model model) {
		String foodName = name;
		
		JSONObject searchedFoodsJson = foodService.searchFood(foodName);
		
		
		model.addAttribute("foodJson", searchedFoodsJson);
		String nextPage = "result";
		return nextPage;
	}
}
