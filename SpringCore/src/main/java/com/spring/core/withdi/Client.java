package com.spring.core.withdi;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.spring.core.withdi"})
public class Client {
    public static void main(String[] args) {


//no need to create object ourselves - take from applciation context
       // MessageService messageService=new SmsService();

        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(Client.class);
//        MessageService messageService=applicationContext.getBean(SmsService.class);
//        messageService.message();

    //we are injecting the dependency ourselves here - no need fot that now;
        //spring automatically injects into message sender with @autowired.
//        MessageSender messageSender=applicationContext.getBean(MessageSender.class);
//        messageSender.sendMessage();

        MessageSenderFI messageSenderFI=applicationContext.getBean(MessageSenderFI.class);
        messageSenderFI.sendMessage();
    }
}
