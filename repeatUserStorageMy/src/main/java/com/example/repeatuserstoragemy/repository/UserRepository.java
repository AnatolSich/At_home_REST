package com.example.repeatuserstoragemy.repository;

import com.example.repeatuserstoragemy.dto.UserDto;
import com.example.repeatuserstoragemy.model.User;
import org.springframework.stereotype.Repository;

import java.util.concurrent.ConcurrentMap;

@Repository
public interface UserRepository {

    User persistUser(User user);

    ConcurrentMap<Long, User> getAllUsers();

    User getUserById(Long id);

}
