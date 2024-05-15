package com.nFactorial.backend.food;

import com.nFactorial.backend.PlanVo;

public class FoodVo extends PlanVo{

	public String foodName;
	public int kcal;
	public int ml_g;
	public float protein;
	public float fat;
	public float carbs;
	
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public int getKcal() {
		return kcal;
	}
	public void setKcal(int kcal) {
		this.kcal = kcal;
	}
	public int getMl_g() {
		return ml_g;
	}
	public void setMl_g(int ml_g) {
		this.ml_g = ml_g;
	}
	public float getCarbs() {
		return carbs;
	}
	public void setCarbs(float carbs) {
		this.carbs = carbs;
	}
	public float getProtein() {
		return protein;
	}
	public void setProtein(float protein) {
		this.protein = protein;
	}
	public float getFat() {
		return fat;
	}
	public void setFat(float fat) {
		this.fat = fat;
	}
	
}
