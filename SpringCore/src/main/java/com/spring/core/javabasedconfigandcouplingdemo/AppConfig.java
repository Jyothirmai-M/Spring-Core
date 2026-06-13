package com.spring.core.javabasedconfigandcouplingdemo;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	@Bean
	public Vehicle returnBike() {
		return new Bike();
	}
	

	@Bean
	public Vehicle returnCar() {
		return new Car();
	}
	
	@Bean
	public Traveller returnTraveller() {
		return new Traveller(this.returnCar());
	}
}
