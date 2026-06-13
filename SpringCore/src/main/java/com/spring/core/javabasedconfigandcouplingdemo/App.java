package com.spring.core.javabasedconfigandcouplingdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
	
	
    public static void main(String[] args) {

        //creating spring IOC Container
        //Read the configuration class
        //create and manager spring bean
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(AppConfig.class);

        Vehicle vehicle=applicationContext.getBean(Car.class);

    	//we instantiate with desired vehicle
    	//Vehicle vehicle = new Car(); // in real-time project; there will 100s of such objects we cannot insantiate each
    								// every object; there should be a framework which does this for us and here come Spring
    	
    	Traveller traveller=applicationContext.getBean(Traveller.class);

    	
       traveller.startJourney();
    } 
}
 