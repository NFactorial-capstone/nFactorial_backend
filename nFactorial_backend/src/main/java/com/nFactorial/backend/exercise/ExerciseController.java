package com.nFactorial.backend.exercise;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ExerciseController {

	@Autowired
	ExerciseService exerciseService;

	@RequestMapping(value = "/exercise/search", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<ExerciseVo> searchFood(String name) {
		System.out.println("��������� ����!");

		List<ExerciseVo> searchedExercisesJson = exerciseService.searchExercise("���� ��ġ ������");
		return searchedExercisesJson;
	}
}
