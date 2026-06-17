package com.projects.springboot_restapi.beans;


public class Student {
	private Integer id;
	private String fristName;
	private String lastName;
	public Student(Integer id, String fristName, String lastName) {
		super();
		this.id = id;
		this.fristName = fristName;
		this.lastName = lastName;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFristName() {
		return fristName;
	}
	public void setFristName(String fristName) {
		this.fristName = fristName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	

}
