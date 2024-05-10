package com.nFactorial.backend.workout;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WorkoutController {

	
	@RequestMapping(value = "/searchWorkout", method = RequestMethod.GET)
	public String searchWorkout(Model model) {
		
		model.addAttribute("");
		
		return "";
	}
	
	@RequestMapping(value = "/weekelyPlan", method = RequestMethod.GET)
	public String weekelyPlan(Model model) {
		
		model.addAttribute("");
		
		return "";
	}
}
