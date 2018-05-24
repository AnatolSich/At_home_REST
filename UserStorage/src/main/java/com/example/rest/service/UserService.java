package com.example.rest.service;

import com.example.rest.exception.UserAlreadyExistsException;
import com.example.rest.model.User;
import com.example.rest.repository.UserRepository;
import com.example.rest.storage.UserStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserService implements UserRepository{

    @Autowired
    private UserStorage userStorage;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User save(User user) throws UserAlreadyExistsException {
        user.setHashedPassword(passwordEncoder.encode(user.getPlainTextPassword()));
        return userStorage.save(user);
    }

    @Override
    public Map<Long, User> get() {
        return userStorage.getUserStorage();
    }
}
