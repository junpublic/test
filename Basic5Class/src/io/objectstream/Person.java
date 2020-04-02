package io.objectstream;

import java.io.Serializable;

public class Person implements Serializable{//오버라이딩 필요없음의 신호를 보내줘야함.직렬화를 해줘야한다.
	private String name;
	private int age;
	private double height;
	private char bloodType;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public char getBloodType() {
		return bloodType;
	}
	public void setBloodType(char bloodType) {
		this.bloodType = bloodType;
	}
}
