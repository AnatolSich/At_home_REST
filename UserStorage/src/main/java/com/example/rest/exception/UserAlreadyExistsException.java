package com.example.rest.exception;

import static com.example.rest.config.Constants.USER_ALREADY_EXIST_DESCRIPTION;

public class UserAlreadyExistsException extends RuntimeException {
    public UserAlreadyExistsException() {
        super(USER_ALREADY_EXIST_DESCRIPTION);
    }
}
