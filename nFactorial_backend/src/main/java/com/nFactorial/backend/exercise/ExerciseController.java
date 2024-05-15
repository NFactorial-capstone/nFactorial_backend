package com.nFactorial.backend.exercise;

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

	@RequestMapping(value = "/search", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<ExerciseVo> searchFood(String name) {
		System.out.println("여기까지는 성공!");

		List<ExerciseVo> searchedExercisesJson = exerciseService.searchExercise("덤벨"); // name
		return searchedExercisesJson;
	}

	@RequestMapping(value = "/part", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<ExerciseVo> getExercisesByPart(String muscle) {
		System.out.println("part 성공");
		List<ExerciseVo> partExercisesJson = exerciseService.partExercise("{복부}"); // part
		return partExercisesJson;
	}

	@RequestMapping(value = "/part/random", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<ExerciseVo> getExercisesPartByRandom(String muscle) {
		System.out.println("random 성공");
		List<ExerciseVo> partExercisesRandomJson = exerciseService.partRandomExercise("{복부}"); // part
		return partExercisesRandomJson;
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registerExercise(String email, String date, ExerciseVo exercisevo) {
		System.out.println("register 성공");
		exerciseService.registerExercise(email, date, exercisevo);
	}

	@RequestMapping(value = "/load", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<ExerciseVo> loadFoodPlan(String email, String date) {
		System.out.println("load 성공");
		List<ExerciseVo> exerciseVos = exerciseService.loadExercisePlan(email, date);
		return exerciseVos;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public void deleteExercisePlan(String email, String date) {
		System.out.println("delete 성공");
		exerciseService.deleteExercisePlan(email, date);
	}
}
