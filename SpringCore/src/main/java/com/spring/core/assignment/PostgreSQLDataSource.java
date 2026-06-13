package com.spring.core.assignment;

import org.springframework.stereotype.Component;

@Component
public class PostgreSQLDataSource implements DataSource{

    @Override
    public String[] getEmails(){
        return new String[]{"laddu@gmail.com","chinni@gmail.com","mery@gmail.com"};
    }
}
