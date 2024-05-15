package com.nFactorial.backend.exercise;

public class ExerciseVo {
	public String name;
	public String muscle;
	public String equipment;
	public String guidelines;
	public String date;
	public float weight;
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMuscle() {
		return muscle;
	}
	public void setMuscle(String muscle) {
		this.muscle = muscle;
	}
	public String getEquipment() {
		return equipment;
	}
	public void setEquipment(String equipment) {
		this.equipment = equipment;
	}
	public String getGuidelines() {
		return guidelines;
	}
	public void setGuidelines(String guidelines) {
		this.guidelines = guidelines;
	}
}
