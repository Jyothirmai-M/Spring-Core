package com.spring.core.assignment;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class MySQLDataSource implements DataSource{

    @Override
    public String[] getEmails(){
        String[] emails={"jyothirmai@gmail.com","jyothsna@gmail.com","jyothisri@gmail.com"};
        return emails;
    }

}
