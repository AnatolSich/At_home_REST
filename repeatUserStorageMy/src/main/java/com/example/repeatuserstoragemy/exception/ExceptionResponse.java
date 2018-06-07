package com.example.repeatuserstoragemy.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

@Builder(builderMethodName = "of", buildMethodName = "create")
public class ExceptionResponse implements Serializable {

    @JsonProperty
    HttpStatus httpStatus;

    @JsonProperty
    String error;

    @JsonProperty
    String errorDescription;
}
