package com.nFactorial.backend.food;

public class MyData {
	public String name;
	public String value;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public MyData(String name, String value) {
		this.name = name;
		this.value = value;
	}
}
