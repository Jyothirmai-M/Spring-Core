package com.spring.core.annotationbasedconfign;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.spring.core.annotationbasedconfign"})
public class Client {

    public static void main(String[] args){
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(Client.class);


        Traveller traveller=applicationContext.getBean(Traveller.class);
        traveller.startJourney();
    }
}
