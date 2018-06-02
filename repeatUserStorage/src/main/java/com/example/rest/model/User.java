package com.example.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import static com.example.rest.config.Constants.USERNAME_OR_PASSWORD_REGEXP;

@Data
@Builder(builderMethodName = "of", buildMethodName = "create")
@EqualsAndHashCode(exclude = {"id", "plainTextPassword", "hashedTextPassword"})
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    @JsonProperty(value = "id")
    private Long id;

    @JsonIgnore
    @NotNull
    private String name;

    @JsonProperty(value = "firstName")
    @NotNull
    private String firstName;

    @JsonProperty(value = "lastName")
    @NotNull
    private String lastName;

    @JsonProperty(value = "userName")
    @NotNull
    @Size(min = 4, max = 20, message = "Username length must be between 4 and 20 chars!")
    @Pattern(regexp = USERNAME_OR_PASSWORD_REGEXP, message = "Username can't contain any special char or space")
    private String userName;

    @JsonProperty(value = "plainTextPassword")
    @NotNull
    @Size(min = 8, message = "Username length must be greater then 8 chars!")
    @Pattern(regexp = USERNAME_OR_PASSWORD_REGEXP, message = "Password can't contain any special char or space")
    private String plainTextPassword;

    private String hashedTextPassword;
}
