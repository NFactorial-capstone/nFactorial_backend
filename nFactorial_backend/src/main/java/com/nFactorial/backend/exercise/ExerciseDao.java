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

	public List<ExerciseVo> partRandomExercise(String muscle) { // 부위별 랜덤 리스트 출력
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
	//아이디별 계획짜기(DB에 데이터 넣기)
	public void registerExercisePlan(String email, String date, ExerciseVo exercisevo) {

      String sql = "INSERT INTO exerciseplan(email, date, name, muscle) VALUES (?, ?, ?, ?);";

      try {
          jdbcTemplate.update(sql, email, date, exercisevo.getName(), exercisevo.getMuscle());

      } catch(Exception e) {
          e.printStackTrace();
      }
  }
	//아이디별 날짜를 통한 계획 조회
	public List<ExerciseVo> loadExercisePlan(String email, String date) {
		String sql = "Select * from exerciseplan where email=? && date=?";
		List<ExerciseVo> exerciseVos = new ArrayList<ExerciseVo>();
		try {
			exerciseVos = jdbcTemplate.query(sql, new RowMapper<ExerciseVo>() {
				
				@Override
				public ExerciseVo mapRow(ResultSet rs, int rowNum) throws
				SQLException {
					ExerciseVo exerciseVo = new ExerciseVo();
					exerciseVo.setDate(rs.getString("date"));
					exerciseVo.setName(rs.getString("name"));
					exerciseVo.setMuscle(rs.getString("muscle"));
					
					
					return exerciseVo;
				}
			},email, date);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return exerciseVos;
	}
	//해당 날짜 계획 삭제
	public void deleteExercisePlan(String email, String date) {
	    String sql = "DELETE FROM exerciseplan WHERE email = ? AND date = ?";
	    try {
	        jdbcTemplate.update(sql, email, date);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}
