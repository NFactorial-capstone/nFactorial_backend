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
		List<ExerciseVo> searchedExercises = exerciseDao.searchExercise(exerciseName);
		return searchedExercises;
	}
	
	 public List<ExerciseVo> partExercise(String muscle) {
		 List<ExerciseVo> partExercises = exerciseDao.partExercise(muscle);
	        return partExercises;
	    }
	 public List<ExerciseVo> partRandomExercise(String muscle) {
		 List<ExerciseVo> partExercises = exerciseDao.partRandomExercise(muscle);
	        return partExercises;
	    }
}
