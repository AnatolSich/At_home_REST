package com.example.repeatuserstoragemy.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import static com.example.repeatuserstoragemy.config.Constants.ERROR_CODE;
import static com.example.repeatuserstoragemy.config.Constants.ERROR_DESCRIPTION;

@ControllerAdvice
public class UserAlreadyExistExceptionHandler {

    @ExceptionHandler(UserAlreadyExistException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.CONFLICT)
    public ExceptionResponse handlerException(Exception ex) {
        return ExceptionResponse.of()
                .httpStatus(HttpStatus.CONFLICT)
                .error(ERROR_CODE)
                .errorDescription(ERROR_DESCRIPTION)
                .create();
    }
}
