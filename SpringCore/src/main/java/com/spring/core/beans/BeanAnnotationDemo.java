package com.spring.core.beans;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

class Student{
    private Address address;

    public Student(Address address){
        this.address=address;
    }

    public void print(){
        System.out.println("Student method called...");
        address.print();
    }

    public void init(){
        System.out.println("Initialization Logic...");
    }
    public void destroy(){
        System.out.println("Destruction Logic");
    }

}

class Address{

    public void print(){
        System.out.println("Address method called...");
    }
}


@Configuration
class AppConfig{

    @Bean
    public Address address(){
        return new Address();
    }
    @Bean(name="StudentBean", initMethod="init", destroyMethod = "destroy")
    public Student student(){
        return new Student(address());
    }
}

public class BeanAnnotationDemo {
    public static void main(String[] args) {


        try(var applicationContext=new AnnotationConfigApplicationContext(AppConfig.class)) {

            Student student=(Student)applicationContext.getBean("StudentBean");
            student.print();

            String[] beanNames=applicationContext.getBeanDefinitionNames();

            for(String bean:beanNames){
                System.out.println(bean);
            }
        }
    }



}
