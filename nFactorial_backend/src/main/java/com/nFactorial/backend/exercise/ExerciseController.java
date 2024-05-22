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

	@RequestMapping(value = "/search", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public List<ExerciseVo> searchFood(String name) {
		System.out.println("��������� ����!");

		List<ExerciseVo> searchedExercisesJson = exerciseService.searchExercise(name); // name
		return searchedExercisesJson;
	}

	@RequestMapping(value = "/part", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public List<ExerciseVo> getExercisesByPart(String muscle) {
		System.out.println("part ����");
		List<ExerciseVo> partExercisesJson = exerciseService.partExercise(muscle); // part
		return partExercisesJson;
	}

	@RequestMapping(value = "/part/random", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public List<ExerciseVo> getExercisesPartByRandom(String muscle) {
		System.out.println("random ����");
		List<ExerciseVo> partExercisesRandomJson = exerciseService.partRandomExercise(muscle); // part
		return partExercisesRandomJson;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public void registerExercise(String email, String date, ExerciseVo exercisevo) {
		System.out.println("register ����");
		exerciseService.registerExercise(email, date, exercisevo);
	}

	@RequestMapping(value = "/load", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public List<ExerciseVo> loadFoodPlan(String email, String date) {
		System.out.println("load ����");
		List<ExerciseVo> exerciseVos = exerciseService.loadExercisePlan(email, date);
		return exerciseVos;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public void deleteExercisePlan(String email, String date) {
		System.out.println("delete ����");
		exerciseService.deleteExercisePlan(email, date);
	}

	@RequestMapping(value = "/weight", method = RequestMethod.POST)
	public void registerWeight(String email, String date, ExerciseVo exercisevo) {
		System.out.println("register weight����");
		exerciseService.registerWeight(email, date, exercisevo);
	}

	@RequestMapping(value = "/weight/delete", method = RequestMethod.POST)
	public void deleteWeight(String email, String date) {
		System.out.println("delete weight ����");
		exerciseService.deleteWeight(email, date);
	}

	@RequestMapping(value = "/count", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public ExerciseVo ExerciseLevel(String email, String date) {
		System.out.println("ExerciseLevel ����");
		int count = exerciseService.countFinishedExercises(email, date);
		ExerciseVo exerciseVos = new ExerciseVo();
		exerciseVos.setCount(count);
		System.out.println(exerciseVos.getCount());
		return exerciseVos;
	}
	
	@RequestMapping(value = "/count/percent", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public ExerciseVo calculateFinishedExercisePercentage(String email, String date) {
		System.out.println("calculateFinishedExercisePercentage ����");
		double percent = exerciseService.calculateFinishedExercisePercentage(email, date);
		ExerciseVo exerciseVos = new ExerciseVo();
		exerciseVos.setPercent(percent);
		System.out.println(exerciseVos.getPercent());
		return exerciseVos;
	}
}
