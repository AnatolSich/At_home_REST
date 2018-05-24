package com.example.rest.repository;

import com.example.rest.exception.UserAlreadyExistsException;
import com.example.rest.model.User;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface UserRepository {

    User save(User user) throws UserAlreadyExistsException;

    Map<Long, User> get();

}
