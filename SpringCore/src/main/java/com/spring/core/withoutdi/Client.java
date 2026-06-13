package com.spring.core.withoutdi;

public class Client {
    public static void main(String[] args) {
//        SmsService smsService=new SmsService();
//        MessageSender messageSender=new MessageSender(smsService);

//        EmailService emailService=new EmailService();
//        MessageSender messageSender=new MessageSender(emailService);
//        messageSender.sendMessage();


        MessageService messageService=new SmsService();
    //we are injecting the dependency ourselves here
        MessageSender messageSender=new MessageSender(messageService);
        messageSender.sendMessage();
    }
}
