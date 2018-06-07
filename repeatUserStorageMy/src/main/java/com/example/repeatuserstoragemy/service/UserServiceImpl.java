package com.example.repeatuserstoragemy.service;

import com.example.repeatuserstoragemy.dto.UserDto;
import com.example.repeatuserstoragemy.dto.UserDtoManager;
import com.example.repeatuserstoragemy.model.User;
import com.example.repeatuserstoragemy.repository.UserRepository;
import com.example.repeatuserstoragemy.storage.UserStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Service
public class UserServiceImpl implements UserService , UserRepository {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private UserStorage userStorage;

    @Override
    public UserDto persistUserDto(User user) {
        user.setHashedTextPassword(passwordEncoder.encode(user.getPlainTextPassword()));
        return UserDtoManager.userToUserDto(userStorage.persist(user));
    }

    @Override
    public ConcurrentMap<Long, UserDto> getAllUserDtos() {
        ConcurrentMap<Long,UserDto> usersDtoMap = new ConcurrentHashMap<>();
        for (Map.Entry<Long, User> entry : userStorage.getAllUsers().entrySet()) {
            usersDtoMap.put(entry.getKey(),UserDtoManager.userToUserDto(entry.getValue()));
        }
        return usersDtoMap;
    }

    @Override
    public UserDto getUserDtoById(Long id) {
        return UserDtoManager.userToUserDto(userStorage.getAllUsers().get(id));
    }

    @Override
    public User persistUser(User user) {
        user.setHashedTextPassword(passwordEncoder.encode(user.getPlainTextPassword()));
        return userStorage.persist(user);
    }

    @Override
    public User getUserById(Long id) {
        return userStorage.getAllUsers().get(id);
    }

    @Override
    public ConcurrentMap<Long, User> getAllUsers() {
       return userStorage.getAllUsers();
    }
}
