package com.example.rest.storage;

import com.example.rest.exception.UserAlreadyExistsException;
import com.example.rest.model.User;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class UserStorage {

    private static final AtomicInteger ID_SEQUENCE = new AtomicInteger(1);
    private static final ConcurrentMap<Long, User> userStorage = new ConcurrentHashMap<>();

    public User save(User user){
        Optional<User> persistedUser = findByUserName(user.getUserName());
        if(persistedUser.isPresent()){
            throw new UserAlreadyExistsException(); // TODO: 19.05.2018
        }
        Long userId = generateId();
        user.setId(userId);
        userStorage.put(userId, user);
        return userStorage.get(userId);
    }

    private Optional<User> findByUserName(String userName){
        return userStorage.values().stream()
                .filter(user -> user.getUserName().equals(userName))
                .findFirst();
    }

    private Long generateId(){
        int id = ID_SEQUENCE.getAndIncrement();
        return (long) id;
    }

    public ConcurrentMap<Long, User> getUserStorage(){
        return userStorage;
    }
}
