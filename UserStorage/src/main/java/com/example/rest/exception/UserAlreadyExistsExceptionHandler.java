package com.example.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import static com.example.rest.config.Constants.USER_ALREADY_EXIST_CODE;

@ControllerAdvice
public class UserAlreadyExistsExceptionHandler {

    @ExceptionHandler(UserAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    @ResponseBody
    public ExceptionResponse handleException(Exception ex){
        return ExceptionResponse.with()
                .httpStatus(HttpStatus.CONFLICT)
                .error(USER_ALREADY_EXIST_CODE)
                .errorDescription(ex.getMessage())
                .build();
    }
}
