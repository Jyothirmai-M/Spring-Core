package com.projects.springboot_restful_webservices_db.controller;

import com.projects.springboot_restful_webservices_db.dto.UserDto;
import com.projects.springboot_restful_webservices_db.entity.User;
import com.projects.springboot_restful_webservices_db.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto user){
       UserDto savedUser= userService.createUser(user);
       return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers(){
        List<UserDto> users=userService.findAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long userId){
        UserDto user=userService.findUserById(userId);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Long id,@RequestBody UserDto userdto){
        userdto.setId(id);
        UserDto updatedUser=userService.updateUser(userdto);
        return new ResponseEntity<>(updatedUser,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteUserById(@PathVariable Long id){
        Boolean result=userService.deleteUserById(id);
        return new ResponseEntity<>(result,HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<Boolean> deleteAllUsers(){
        Boolean result=userService.deleteAllUsers();
        return new ResponseEntity<>(result,HttpStatus.NO_CONTENT);
    }
}

