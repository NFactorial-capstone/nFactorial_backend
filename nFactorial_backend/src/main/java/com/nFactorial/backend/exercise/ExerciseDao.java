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

	public List<ExerciseVo> partExercise(String muscle) { // muscle�� ���� ���� �ٸ� ����Ʈ ���
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

	public List<ExerciseVo> partRandomExercise(String muscle) { // ������ ���� ����Ʈ ���
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

	// ���̵� ��ȹ¥��(DB�� ������ �ֱ�)
	public void registerExercisePlan(String email, ExerciseVo exercisevo) {

		String sql = "INSERT INTO exerciseplan(email, date, name, muscle) VALUES (?, ?, ?, ?);";

		try {
			jdbcTemplate.update(sql, email, exercisevo.getDate(), exercisevo.getName(), exercisevo.getMuscle());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ���̵� ��¥�� ���� ��ȹ ��ȸ
	public List<ExerciseVo> loadExercisePlan(String email, String date) {
		String sql = "Select * from exerciseplan where email=? && date=?";
		List<ExerciseVo> exerciseVos = new ArrayList<ExerciseVo>();
		try {
			exerciseVos = jdbcTemplate.query(sql, new RowMapper<ExerciseVo>() {

				@Override
				public ExerciseVo mapRow(ResultSet rs, int rowNum) throws SQLException {
					ExerciseVo exerciseVo = new ExerciseVo();
					exerciseVo.setDate(rs.getString("date"));
					exerciseVo.setName(rs.getString("name"));
					exerciseVo.setMuscle(rs.getString("muscle"));

					return exerciseVo;
				}
			}, email, date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return exerciseVos;
	}

	// �ش� ��¥ ��ȹ ����
	public void deleteExercisePlan(String email, String date) {
		String sql = "DELETE FROM exerciseplan WHERE email = ? AND date = ?";
		try {
			jdbcTemplate.update(sql, email, date);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ü�� ���
	public void registerWeight(String email, ExerciseVo exercisevo) {
		String sql = "INSERT INTO weight(email, date, weight) VALUES (?, ?, ?);";

		try {
			jdbcTemplate.update(sql, email, exercisevo.getDate(), exercisevo.getWeight());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ü�� ����
	public void deleteWeight(String email, String date) {
		String sql = "DELETE FROM weight WHERE email = ? AND date = ?";
		try {
			jdbcTemplate.update(sql, email, date);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<ExerciseVo> loadWeight(String email, String date) {
		String sql = "SELECT * FROM weight WHERE email = ? && date = ?";
		List<ExerciseVo> exercisevos = new ArrayList<ExerciseVo>();
		try {
			exercisevos = jdbcTemplate.query(sql, new RowMapper<ExerciseVo>() {

				@Override
				public ExerciseVo mapRow(ResultSet rs, int rowNum) throws SQLException {
					ExerciseVo exerciseVo = new ExerciseVo();
					exerciseVo.setDate(rs.getString("date"));
					exerciseVo.setWeight(rs.getFloat("weight"));

					return exerciseVo;
				}
			}, email, date);
			return exercisevos;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// �ش� ���� ��ȹ����Ʈ���� � � �Ϸ��ߴ���
	public int countFinishedExercises(String email, String date) {
		String sql = "SELECT COUNT(*) FROM exerciseplan WHERE email=? AND date=? AND finished=true";
		try {
			return jdbcTemplate.queryForObject(sql, Integer.class, email, date);
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	// �Ϸ��� � �ۼ�Ʈ
	public double calculateFinishedExercisePercentage(String email, String date) {
		try {
			String totalSql = "SELECT COUNT(*) FROM exerciseplan WHERE email=? AND date=?";
			int totalExercises = jdbcTemplate.queryForObject(totalSql, Integer.class, email, date);

			String finishedSql = "SELECT COUNT(*) FROM exerciseplan WHERE email=? AND date=? AND finished=true";
			int finishedExercises = jdbcTemplate.queryForObject(finishedSql, Integer.class, email, date);

			double percentage = 0.0;
			if (totalExercises > 0) {
				percentage = ((double) finishedExercises / totalExercises) * 100.0;
			}

			return Double.parseDouble(String.format("%.1f", percentage));
		} catch (Exception e) {
			e.printStackTrace();
			return -1.0;
		}
	}

}
