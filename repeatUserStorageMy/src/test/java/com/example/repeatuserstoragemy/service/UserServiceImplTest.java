package com.example.repeatuserstoragemy.service;

import com.example.repeatuserstoragemy.exception.UserAlreadyExistException;
import com.example.repeatuserstoragemy.model.User;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.DEFAULT)
public class UserServiceImplTest {

    @Autowired
    private UserServiceImpl userService;

    User standAloneUser = User.of()
            .name("Test")
            .userName("Test")
            .plainTextPassword("Test")
            .create();

    @Test
    public void userPersistingSuccess(){
        User firstUser = userService.persistUser(standAloneUser);
        Assert.assertEquals(userService.getUserById(firstUser.getId()),firstUser);
    }

    @Test(expected = UserAlreadyExistException.class)
    public void alreadyExistUserPersistingThrowsException(){
        userService.persistUserDto(standAloneUser);
    }
}