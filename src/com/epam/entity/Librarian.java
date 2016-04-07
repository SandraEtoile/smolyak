package com.epam.entity;

public class Librarian {
	private String name;
	private int workId;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getWorkId() {
		return workId;
	}
	public void setWorkId(int workId) {
		this.workId = workId;
	}
	public Librarian(String name, int workId) {
		this.name = name;
		this.workId = workId;
	}
	
	

}
