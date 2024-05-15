package com.nFactorial.backend.exercise;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class ExerciseDao {
	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<ExerciseVo> searchExercise(String exerciseName) {
		List<ExerciseVo> exerciseVos = new ArrayList<ExerciseVo>();
		String sql = "SELECT * FROM exercisedata WHERE name like CONCAT('%', ? , '%');";

		try {
			exerciseVos = jdbcTemplate.query(sql, new RowMapper<ExerciseVo>() {

				@Override
				public ExerciseVo mapRow(ResultSet rs, int rowNum) throws SQLException {
					ExerciseVo exerciseVo = new ExerciseVo();

					exerciseVo.setName(rs.getString("name"));
					exerciseVo.setMuscle(rs.getString("muscle"));
					exerciseVo.setEquipment(rs.getString("equipment"));
					exerciseVo.setGuidelines(rs.getString("guidelines"));

					return exerciseVo;
				}
			}, exerciseName);
			System.out.println("ExerciseName : " + exerciseName);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return exerciseVos;
	}

	public List<ExerciseVo> partExercise(String muscle) { // muscle의 부위 별로 다른 리스트 출력
		List<ExerciseVo> exerciseVos = new ArrayList<ExerciseVo>();
		String sql = "SELECT * FROM exercisedata WHERE muscle = ?";
		try {
			exerciseVos = jdbcTemplate.query(sql, new RowMapper<ExerciseVo>() {
				@Override
				public ExerciseVo mapRow(ResultSet rs, int rowNum) throws SQLException {
					ExerciseVo exerciseVo = new ExerciseVo();
					exerciseVo.setName(rs.getString("name"));
					return exerciseVo;
				}
			}, muscle);
			System.out.println("ExercisePart: " + muscle);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return exerciseVos;
	}

	public List<ExerciseVo> partRandomExercise(String muscle) {
		List<ExerciseVo> exerciseVos = new ArrayList<>();
		String sql = "SELECT * FROM exercisedata WHERE muscle = ?";
		try {
			exerciseVos = jdbcTemplate.query(sql, new RowMapper<ExerciseVo>() {
				@Override
				public ExerciseVo mapRow(ResultSet rs, int rowNum) throws SQLException {
					ExerciseVo exerciseVo = new ExerciseVo();
					exerciseVo.setName(rs.getString("name"));
					return exerciseVo;
				}
			}, muscle);
			System.out.println("ExercisePart: " + muscle);

			if (exerciseVos.size() > 4) {
				Collections.shuffle(exerciseVos);
				exerciseVos = exerciseVos.subList(0, 4);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return exerciseVos;
	}

}
