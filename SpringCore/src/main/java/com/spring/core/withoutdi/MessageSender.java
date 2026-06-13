package com.spring.core.withoutdi;

public class MessageSender {

//    below section shows message sender using sms service
//    SmsService sms;
//
//    MessageSender(SmsService sms){
//        this.sms=sms;
//    }
//
//    public void sendMessage(){
//        this.sms.message();
//    }


    //this section shows message sender using email service for which we had to change the code
    //because the objects are tightly coupled with each other
//    EmailService emailService;
//    MessageSender(EmailService emailService){
//        this.emailService=emailService;
//    }
//
//    public void sendMessage(){
//        this.emailService.message();
//    }

    //this section shows loose coupling
    //no matter which service type, sms , email... we dont have to change message sender now
    MessageService messageService;
    public MessageSender(MessageService messageService){
        this.messageService=messageService;
    }

    public void sendMessage(){
        this.messageService.message();
    }

}
