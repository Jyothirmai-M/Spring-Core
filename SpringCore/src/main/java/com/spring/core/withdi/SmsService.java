package com.spring.core.withdi;

import org.springframework.stereotype.Component;

@Component("sms")
public class SmsService implements MessageService {

    @Override
    public void message(){
        System.out.println("sms message");
    }
}
