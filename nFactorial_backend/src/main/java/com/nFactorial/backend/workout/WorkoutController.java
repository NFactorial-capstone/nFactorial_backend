package com.nFactorial.backend.workout;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WorkoutController {

	
	@RequestMapping(value = "workout/search", method = RequestMethod.GET)
	public String searchWorkout(Model model) {
		
		model.addAttribute("");
		
		return "";
	}
	
	@RequestMapping(value = "workout/saveWeekelyPlan", method = RequestMethod.GET)
	public String saveWeekelyPlan(Model model) {
		
		model.addAttribute("");
		
		return "";
	}
	
	@RequestMapping(value = "workout/loadWeekelyPlan", method = RequestMethod.GET)
	public String loadWeekelyPlan(Model model) {
		
		model.addAttribute("");
		
		return "";
	}
	
	@RequestMapping(value = "workout/recommend", method = RequestMethod.GET)
	public String recommendWorkout(Model model) {
		
		model.addAttribute("");
		
		return "";
	}
}
