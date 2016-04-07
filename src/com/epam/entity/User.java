package com.epam.entity;

public class User {
	private String name;
	private int userId;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getUserId() {
		return userId;
	}
	public User(String name, int userId) {
		this.name = name;
		this.userId = userId;
	}
	public User(String name) {
		this.name = name;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public User() {
		
	}
}
