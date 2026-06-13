package com.spring.core.withdi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MessageSenderFI {

    @Autowired
    @Qualifier("email")
    private MessageService messageService;

    public void sendMessage(){
        this.messageService.message();
    }
}
