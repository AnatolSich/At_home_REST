package com.example.repeatuserstoragemy.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder(builderMethodName = "of", buildMethodName = "create")
@ToString(exclude = {"id", "plainTextPassword", "hashedTextPassword"})
@EqualsAndHashCode(exclude = {"id", "plainTextPassword", "hashedTextPassword"})
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    @JsonProperty(value = "id")
    @NotNull
    private Long id;

    @JsonProperty(value = "name")
    @NotNull
    private String name;

    @JsonProperty(value = "userName")
    @NotNull
    @Size(min = 4, max = 8, message = "Length of username must be between 4 and 8 chars")
    private String userName;

    @JsonProperty(value = "plainTextPassword")
    @NotNull
    @Size(min = 6,max = 20, message = "Length of password must be between 6 and 20 chars")
    private String plainTextPassword;

    private String hashedTextPassword;
}
