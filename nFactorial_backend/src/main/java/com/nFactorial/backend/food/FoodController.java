package com.nFactorial.backend.food;

import java.util.HashMap;
import java.util.List;

import org.json.JSONML;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FoodController {

	@Autowired
	FoodService foodService;

	
	@RequestMapping(value = "/food/search", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<FoodVo> searchFood(String name) {
        System.out.println("searchFood up!");
        
        List<FoodVo> searchedFoodsJson = foodService.searchFood(name);
        return searchedFoodsJson;
    }
	
	
	
}
