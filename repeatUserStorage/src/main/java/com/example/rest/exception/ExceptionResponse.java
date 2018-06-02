package com.example.rest.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

@Data
@Builder(builderMethodName = "of",buildMethodName = "make")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExceptionResponse implements Serializable {

    @JsonProperty(value = "httpStatus")
    HttpStatus httpStatus;
    @JsonProperty(value = "error")
    String error;
    @JsonProperty(value = "errorDescription")
    String errorDescription;

}
