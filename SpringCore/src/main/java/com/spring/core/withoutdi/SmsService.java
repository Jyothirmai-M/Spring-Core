package com.spring.core.withoutdi;

public class SmsService implements MessageService {

    @Override
    public void message(){
        System.out.println("sms message");
    }
}
