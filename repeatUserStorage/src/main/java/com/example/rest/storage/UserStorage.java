package com.example.rest.storage;

import com.example.rest.exception.UserAlreadyExistException;
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

    public User save(User user) {
        Optional<User> persistedUser = findByUserName(user.getUserName());
        if (persistedUser.isPresent()) {
            throw new UserAlreadyExistException();
        }
        Long id = generateId();
        user.setId(id);
        userStorage.put(id, user);
        return userStorage.get(id);
    }

    private Optional<User> findByUserName(String userName) {
        return userStorage.values().stream().filter(user -> user.getUserName().equals(userName)).findFirst();
    }

    private Long generateId() {
        int id = ID_SEQUENCE.getAndIncrement();
        return Long.parseLong(String.valueOf(id));
    }

    public ConcurrentMap<Long, User> getUserstorage() {
        return userStorage;
    }
}
