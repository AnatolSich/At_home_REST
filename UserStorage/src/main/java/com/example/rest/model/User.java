package com.example.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import static com.example.rest.config.Constants.USERNAME_OR_PASSWORD_REGEXP;

@Data
@Builder(builderMethodName = "with", buildMethodName = "create")
@EqualsAndHashCode(exclude = {"id", "plainTextPassword", "hashedPassword"})
@ToString(exclude = {"id", "plainTextPassword", "hashedPassword"})
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    @JsonProperty(value = "id")
    private Long id;

    @NotNull
    @JsonProperty(value = "firstName")
    private String firstName;

    @NotNull
    @JsonProperty(value = "lastName")
    private String lastName;

    @NotNull
    @JsonProperty(value = "userName")
    @Size(min = 4, max = 20, message = "Username length must be between 4 and 20 characters!")
    @Pattern(regexp = USERNAME_OR_PASSWORD_REGEXP, message = "Username can't contain any special char or spaces!")
    private String userName;

    @NotNull
    @JsonProperty(value = "plainTextPassword")
    @Size(min = 8, message = "Password length must be bigger then 8 char")
    @Pattern(regexp = USERNAME_OR_PASSWORD_REGEXP, message = "Password can't contain any special char or spaces!")
    private String plainTextPassword;

    private String hashedPassword;
}
