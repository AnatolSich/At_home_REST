package com.example.repeatuserstoragemy.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;


@Data
@Builder(builderMethodName = "of", buildMethodName = "create")
final public class UserDto {
    @JsonProperty(value = "id")
    private Long id;

    @JsonProperty(value = "name")
    private String name;

    @JsonProperty(value = "plainTextPassword")
    private String plainTextPassword;
}
