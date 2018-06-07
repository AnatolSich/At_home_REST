package com.example.repeatuserstoragemy.storage;

import com.example.repeatuserstoragemy.exception.UserAlreadyExistException;
import com.example.repeatuserstoragemy.model.User;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class UserStorage {

    private final static AtomicInteger INCREMENT = new AtomicInteger(1);
    private final static ConcurrentMap<Long, User> users = new ConcurrentHashMap<>();

    //save user to UserStorage
    private Long generateId() {
        return (long) INCREMENT.incrementAndGet();
    }

    private User findUserByName(String name) {
        for (User user : users.values()) {
            if (name.equals(user.getName())) {
                return user;
            }
        }
        return null;
    }

    public User persist(User user) {
        if (findUserByName(user.getName()) != null) {
            throw new UserAlreadyExistException();
        } else {
            Long id = generateId();
            user.setId(id);
            users.put(id, user);
        }
        return users.get(user.getId());
    }

    //get users from UserStorage
    public ConcurrentMap <Long, User> getAllUsers(){
        return users;
    }
}
