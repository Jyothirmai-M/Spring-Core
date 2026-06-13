package com.spring.core.javabasedconfigandcouplingdemo;

public class Bike implements Vehicle {
	
	@Override
	public void move() {
		System.out.println("Bike is moving...");
	}
}
