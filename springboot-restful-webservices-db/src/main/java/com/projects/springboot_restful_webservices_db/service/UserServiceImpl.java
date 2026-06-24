package com.projects.springboot_restful_webservices_db.service;


import com.projects.springboot_restful_webservices_db.dto.UserDto;
import com.projects.springboot_restful_webservices_db.entity.User;
import com.projects.springboot_restful_webservices_db.mapper.UserMapper;
import com.projects.springboot_restful_webservices_db.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;


    @Override
    public UserDto createUser(UserDto userDto){

        //convery UserDto to User entity
        User user= UserMapper.mapToUser(userDto);
        //saving entity to db
       User savedUser=userRepository.save(user);

       //convert user JPA to user DTO
       UserDto savedUserDto=UserMapper.mapToUserDto(savedUser);
       return savedUserDto;
    }


    @Override
    public List<UserDto> findAllUsers(){
       List<User> users= userRepository.findAll();

       List<UserDto> userDtos=users.stream()
               .map(UserMapper::mapToUserDto)//using method reference
              // .map(user-> UserMapper.mapToUserDto(user))//using lambda expression
              // .collect(Collectors.toList());
               .toList();

       return userDtos;
    }

    @Override
    public UserDto findUserById(Long id){
        User user=userRepository.findById(id).get();
        UserDto userDto=UserMapper.mapToUserDto(user);
        return userDto;
    }

    @Override
    public UserDto updateUser(UserDto userdto){
        User user=UserMapper.mapToUser(userdto);
        User existingUser=userRepository.findById(user.getId()).get();

        existingUser.setId(user.getId());
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        User updatedUser=userRepository.save(existingUser);

        return UserMapper.mapToUserDto(updatedUser);
    }

    @Override
    public Boolean deleteUserById(Long id) {
        if(userRepository.existsById(id)){
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Boolean deleteAllUsers() {
        if(userRepository.count()>=1){
            userRepository.deleteAll();
            return true;
        }
        return false;
    }

}
