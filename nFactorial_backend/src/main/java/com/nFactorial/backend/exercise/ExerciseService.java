package com.nFactorial.backend.exercise;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExerciseService {

	@Autowired
	ExerciseDao exerciseDao;
	
	public List<ExerciseVo> searchExercise(String exerciseName) {
		JSONObject searchedExerciseJson = new JSONObject();
		JSONObject exerciseJson;
		int cnt = 1;
		
		List<ExerciseVo> searchedExercises = exerciseDao.searchExercise(exerciseName);
		return searchedExercises;
	}
}
