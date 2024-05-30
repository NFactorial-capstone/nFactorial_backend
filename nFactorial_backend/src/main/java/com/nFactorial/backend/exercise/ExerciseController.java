package com.nFactorial.backend.exercise;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/exercise")
public class ExerciseController {

	@Autowired
	ExerciseService exerciseService;

	@RequestMapping(value = "/search", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public List<ExerciseVo> searchFood(String name) {
		System.out.println("여기까지는 성공!");

		List<ExerciseVo> searchedExercisesJson = exerciseService.searchExercise(name); // name
		return searchedExercisesJson;
	}

	@RequestMapping(value = "/part", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public List<ExerciseVo> getExercisesByPart(String muscle) {
		System.out.println("part 성공");
		List<ExerciseVo> partExercisesJson = exerciseService.partExercise(muscle); // part
		return partExercisesJson;
	}

	@RequestMapping(value = "/part/random", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public List<ExerciseVo> getExercisesPartByRandom(String muscle) {
		System.out.println("random 성공");
		List<ExerciseVo> partExercisesRandomJson = exerciseService.partRandomExercise(muscle); // part
		return partExercisesRandomJson;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
	public String registerExercise(String email, ExerciseVo exercisevo) {
		String result = "";
		System.out.println("register 성공");
		result = exerciseService.registerExercise(email, exercisevo);
		
		return result;
	}

	@RequestMapping(value = "/load", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public List<ExerciseVo> loadFoodPlan(String email, String date) {
		System.out.println("load 성공");
		List<ExerciseVo> exerciseVos = exerciseService.loadExercisePlan(email, date);
		return exerciseVos;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public String deleteExercisePlan(String email, String date) {
		String result = "";
		System.out.println("delete 성공");
		result = exerciseService.deleteExercisePlan(email, date);
		return result;
	}

	@RequestMapping(value = "/weight", method = RequestMethod.POST)
	@ResponseBody
	public String registerWeight(String email, ExerciseVo exercisevo) {
		String result = "";
		System.out.println("register weight성공");
		result = exerciseService.registerWeight(email, exercisevo);
		return result;
	}

	@RequestMapping(value = "/weight/delete", method = RequestMethod.POST)
	@ResponseBody
	public String deleteWeight(String email, String date) {
		String result = "";
		System.out.println("delete weight 성공");
		result = exerciseService.deleteWeight(email, date);
		return result;
	}
	
	@RequestMapping(value = "/weight/load", method = RequestMethod.POST)
	public List<ExerciseVo> loadWeight(String email, String date) {
		System.out.println("load weight 성공");
		List<ExerciseVo> exercisevos = new ArrayList<ExerciseVo>();
		exercisevos = exerciseService.loadWeight(email, date);
		return exercisevos;
	}

	@RequestMapping(value = "/count", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public ExerciseVo ExerciseLevel(String email, String date) {
		System.out.println("ExerciseLevel 성공");
		int count = exerciseService.countFinishedExercises(email, date);
		ExerciseVo exerciseVos = new ExerciseVo();
		exerciseVos.setCount(count);
		System.out.println(exerciseVos.getCount());
		return exerciseVos;
	}
	
	@RequestMapping(value = "/count/percent", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public ExerciseVo calculateFinishedExercisePercentage(String email, String date) {
		System.out.println("calculateFinishedExercisePercentage 성공");
		double percent = exerciseService.calculateFinishedExercisePercentage(email, date);
		ExerciseVo exerciseVos = new ExerciseVo();
		exerciseVos.setPercent(percent);
		System.out.println(exerciseVos.getPercent());
		return exerciseVos;
	}
}
