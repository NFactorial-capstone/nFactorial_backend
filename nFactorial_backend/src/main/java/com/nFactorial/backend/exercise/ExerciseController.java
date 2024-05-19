package com.nFactorial.backend.exercise;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ExerciseController {

	
	@RequestMapping(value = "/searchExercise", method = RequestMethod.GET)
	public String searchExerciset(Model model) {
		
		model.addAttribute("");
		
		return "";
	}
	
	@RequestMapping(value = "/saveExercisePlan", method = RequestMethod.GET)
	public String saveExercisePlan(Model model) {
		
		model.addAttribute("");
		
		return "";
	}
	
	@RequestMapping(value = "/loadExercisePlan", method = RequestMethod.GET)
	public String loadExercisePlan(Model model) {
		
		model.addAttribute("");
		
		return "";
	}
	
	@RequestMapping(value = "/recommendExercise", method = RequestMethod.GET)
	public String recommendExercise(Model model) {
		
		model.addAttribute("");
		
		return "";
	}
}
