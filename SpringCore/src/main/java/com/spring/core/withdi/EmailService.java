package com.spring.core.withdi;

import org.springframework.stereotype.Component;

@Component("email")
public class EmailService implements MessageService {

    @Override
    public void message(){
        System.out.println("Email Message...");
    }
}
