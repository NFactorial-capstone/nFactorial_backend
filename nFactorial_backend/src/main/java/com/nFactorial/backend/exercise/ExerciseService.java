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

	public void registerExercise(String email, ExerciseVo exercisevo) {
		exerciseDao.registerExercisePlan(email, exercisevo);
	}

	public List<ExerciseVo> loadExercisePlan(String email, String date) {
		List<ExerciseVo> exerciseVos = exerciseDao.loadExercisePlan(email, date);

		return exerciseVos;
	}
	
	public void deleteExercisePlan(String email, String date) {
	    exerciseDao.deleteExercisePlan(email, date);
	}
	public void registerWeight(String email, ExerciseVo exercisevo) {
		exerciseDao.registerWeight(email, exercisevo);
	}
	public void deleteWeight(String email, String date) {
	    exerciseDao.deleteWeight(email, date);
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
