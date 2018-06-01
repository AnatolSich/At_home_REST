package com.example.rest.service;

import com.example.rest.exception.UserAlreadyExistsException;
import com.example.rest.model.User;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserServiceTest {

    @Resource
    UserService userService;

    User standaloneUser = User.with()
            .firstName("test")
            .lastName("test")
            .userName("test")
            .plainTextPassword("test")
            .create();

    @Test
    public void correctUserPersisting_success(){
        User firstPersistedUser = userService.save(standaloneUser);
        assertEquals(1L, firstPersistedUser.getId().longValue());
        assertNotNull(firstPersistedUser.getHashedPassword());
    }

    @Test(expected = UserAlreadyExistsException.class)
    public void saveThrowsUserAlreadyExistsExceptionForExistsUser(){
        userService.save(standaloneUser);
    }

}