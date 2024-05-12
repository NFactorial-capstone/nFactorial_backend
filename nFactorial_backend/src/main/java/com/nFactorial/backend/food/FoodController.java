package com.nFactorial.backend.food;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FoodController {

	
	@RequestMapping(value = "/food/search", method = RequestMethod.GET)
	public String searchFood() {
		
		return "";
	}
}
