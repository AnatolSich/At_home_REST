package com.example.repeatuserstoragemy.exception;

import static com.example.repeatuserstoragemy.config.Constants.ERROR_DESCRIPTION;

public class UserAlreadyExistException extends RuntimeException{
    public UserAlreadyExistException() {
        super(ERROR_DESCRIPTION);
    }
}
