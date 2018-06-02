package com.example.rest.exception;

import static com.example.rest.config.Constants.USER_ALREADY_EXIST_DESCRIPTION;

public class UserAlreadyExistException extends RuntimeException {
    public UserAlreadyExistException() {
        super(USER_ALREADY_EXIST_DESCRIPTION);
    }
}
