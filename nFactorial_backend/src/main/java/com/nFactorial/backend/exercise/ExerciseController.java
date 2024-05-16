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

	@RequestMapping(value = "/weight", method = RequestMethod.GET)
	public void registerWeight(String email, String date, ExerciseVo exercisevo) {
		System.out.println("register weight성공");
		exerciseService.registerWeight(email, date, exercisevo);
	}

	@RequestMapping(value = "/weight/delete", method = RequestMethod.GET)
	public void deleteWeight(String email, String date) {
		System.out.println("delete weight 성공");
		exerciseService.deleteWeight(email, date);
	}

	@RequestMapping(value = "/count", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ExerciseVo ExerciseLevel(String email, String date) {
		System.out.println("ExerciseLevel 성공");
		int count = exerciseService.countFinishedExercises(email, date);
		ExerciseVo exerciseVos = new ExerciseVo();
		exerciseVos.setCount(count);
		System.out.println(exerciseVos.getCount());
		return exerciseVos;
	}
	
	@RequestMapping(value = "/count/percent", method = RequestMethod.GET, produces = "application/json")
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
