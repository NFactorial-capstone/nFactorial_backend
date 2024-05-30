package com.nFactorial.backend.exercise;

import java.util.ArrayList;
import java.util.List;

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

	public String registerExercise(String email, ExerciseVo exercisevo) {
		String result ="";
		result = exerciseDao.registerExercisePlan(email, exercisevo);
		
		return result;
	}

	public List<ExerciseVo> loadExercisePlan(String email, String date) {
		List<ExerciseVo> exerciseVos = exerciseDao.loadExercisePlan(email, date);

		return exerciseVos;
	}
	
	public String deleteExercisePlan(String email, String date) {
		String result = "";
	    result = exerciseDao.deleteExercisePlan(email, date);
	    return result;
	}
	public String registerWeight(String email, ExerciseVo exercisevo) {
		String result = "";
		result = exerciseDao.registerWeight(email, exercisevo);
		return result;
	}
	public String deleteWeight(String email, String date) {
		String result = "";
		result = exerciseDao.deleteWeight(email, date);
		return result;
	}
	public List<ExerciseVo> loadWeight(String email, String date) {
		List<ExerciseVo> exercisevo = new ArrayList<ExerciseVo>();
		exercisevo = exerciseDao.loadWeight(email, date);
		return exercisevo;
	}
	
	public int countFinishedExercises(String email, String date) {
        return exerciseDao.countFinishedExercises(email, date);
    }
	
	public double calculateFinishedExercisePercentage(String email, String date) {
        return exerciseDao.calculateFinishedExercisePercentage(email, date);
    }
}
