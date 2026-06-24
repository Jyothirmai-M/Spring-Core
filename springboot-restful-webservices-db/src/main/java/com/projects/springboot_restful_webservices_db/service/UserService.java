package com.projects.springboot_restful_webservices_db.service;

import com.projects.springboot_restful_webservices_db.dto.UserDto;
import com.projects.springboot_restful_webservices_db.entity.User;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto user);
    List<UserDto> findAllUsers();
    UserDto findUserById(Long id);
    UserDto updateUser(UserDto user);
    Boolean deleteUserById(Long id);
    Boolean deleteAllUsers();


}
