package com.example.rest.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

@Data
@Builder(builderMethodName = "with", buildMethodName = "build")
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ExceptionResponse implements Serializable{

    @JsonProperty(value = "httpStatus")
    private HttpStatus httpStatus;
    @JsonProperty(value = "error")
    private String error;
    @JsonProperty(value = "errorDescription")
    private String errorDescription;
}
