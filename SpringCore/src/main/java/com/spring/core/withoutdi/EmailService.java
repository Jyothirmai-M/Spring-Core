package com.spring.core.withoutdi;

public class EmailService implements MessageService {

    @Override
    public void message(){
        System.out.println("Email Message...");
    }
}
