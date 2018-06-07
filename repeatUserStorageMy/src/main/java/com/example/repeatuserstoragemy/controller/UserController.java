package com.example.repeatuserstoragemy.controller;

import com.example.repeatuserstoragemy.dto.UserDto;
import com.example.repeatuserstoragemy.model.User;
import com.example.repeatuserstoragemy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ConcurrentMap;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    //save user to storage and return userDto as response
    @PostMapping(value = "api/addUserDto", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public UserDto addUserDto(@RequestBody User user) {
        return userService.persistUserDto(user);
    }

    //save user to storage and return user as response
    @PostMapping(value = "/api/addUser", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public User addUser(@RequestBody User user) {
        return userService.persistUser(user);
    }

    //get all users from storage and return they as userDtos in response
    @GetMapping(value = "/api/getUserDtos", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ConcurrentMap<Long, UserDto> getAllUserDtos() {
        return userService.getAllUserDtos();
    }

    //get all users from storage and return they as users in response
    @GetMapping(value = "/api/getUsers", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ConcurrentMap<Long, User> getAllUsers() {
        return userService.getAllUsers();
    }

    //get user by id from storage and return as userDto in response
    @GetMapping(value = "/api/getUser/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public UserDto getUserDtoById(@PathVariable Long id) {
        return userService.getUserDtoById(id);
    }

    //get user by id from storage and return as user in response
    @GetMapping(value = "/api/getUserDto/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }
}
