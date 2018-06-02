package com.example.rest.service;

import com.example.rest.exception.UserAlreadyExistException;
import com.example.rest.model.User;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;


@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserServiceTest {
    @Resource
    UserService userService;

    User standAloneUser = User.of()
            .name("test")
            .firstName("test")
            .lastName("test")
            .userName("test")
            .plainTextPassword("test")
            .create();

    @Test
    public void correctUserPersistingSuccess() {
        User firstUser = userService.save(standAloneUser);
        Assert.assertEquals(1L, firstUser.getId().longValue());
        Assert.assertNotNull(firstUser.getHashedTextPassword());
    }

    @Test(expected = UserAlreadyExistException.class)
    public void saveThrowsUserAlreadyExistExceptionForExistUser() {
        userService.save(standAloneUser);
    }

}