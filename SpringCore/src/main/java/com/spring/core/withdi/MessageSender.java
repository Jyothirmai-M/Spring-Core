package com.spring.core.withdi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MessageSender {

    //this section shows loose coupling
    //no matter which service type, sms , email... we dont have to change message sender now

    MessageService messageService;
      @Autowired
    public MessageSender(@Qualifier("email") MessageService messageService){

        this.messageService=messageService;
    }

    public void sendMessage(){
        this.messageService.message();
    }

}
