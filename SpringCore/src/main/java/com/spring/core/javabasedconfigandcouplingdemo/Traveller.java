package com.spring.core.javabasedconfigandcouplingdemo;

public class Traveller {
	//this has a major problem in the code
	//it is tightly coupled if traveller wants to use another vehicle like bike or van the entire code needs a change
//	Car car=null;
//	
//	//constructor
//	public Traveller(){
//		this.car=new Car();
//	}
//	
//	public void startJourney() {
//		this.car.move();
//	}
	
	
	// now traveller wants to use bike; see how the code changes
//	Bike bike=null;
//	
//	public Traveller() {
//		this.bike=new Bike();
//	}
//	
//	public void startJourney() {
//		this.bike.move();
//	}
//	
	
	// this tight coupling can be solved with using interface or abstract class and now we see how its done down below
	// we create an interface called vehicle and we supply car/bike/van/cycle to traveller dynamically which creates loose coupling
	
	Vehicle vehicle=null;
	
	public Traveller(Vehicle vehicle){
		this.vehicle=vehicle;
	}
	
	public void startJourney() {
		this.vehicle.move();
	}
	
	
}
