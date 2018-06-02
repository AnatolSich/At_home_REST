package com.example.rest.controller;

import com.example.rest.dto.UserDto;
import com.example.rest.model.User;
import com.example.rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ConcurrentMap;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/api/user", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDto addUser(@RequestBody User user){
        User savedUser = userService.save(user);
        return UserDto.UserDtoManager.toUserDto(savedUser);
    }

    @GetMapping(value = "api/get", produces = MediaType.APPLICATION_JSON_VALUE)
    public ConcurrentMap<Long,User> getUsers(){
        return userService.get();
    }

}
