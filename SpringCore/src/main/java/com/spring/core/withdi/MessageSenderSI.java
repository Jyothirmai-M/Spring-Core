package com.spring.core.withdi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


public class MessageSenderSI {

    private MessageService messageService;
    private SmsService smsService;

//    @Autowired
//    public void setMessageService(@Qualifier("email") MessageService messageService) {
//        this.messageService = messageService;
//    }
//
//    public void setSmsService(SmsService smsService) {
//        this.smsService = smsService;
//    }


    @Autowired
    public void setMessageService(@Qualifier("email") MessageService messageService) {
        this.messageService = messageService;
        System.out.println("setMessageService - Setter method");
    }

    @Autowired
    public void setSmsService(SmsService smsService) {
        this.smsService = smsService;
        System.out.println("setSMSService - Setter method");
    }

    public void sendMessage(){
        this.messageService.message();
        this.smsService.message();
    }
}
