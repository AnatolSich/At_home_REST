package com.example.repeatuserstoragemy.dto;

import com.example.repeatuserstoragemy.model.User;

public interface UserDtoManager {
    static UserDto userToUserDto(User user) {
        return UserDto.of()
                .id(user.getId())
                .name(user.getName())
                .plainTextPassword(user.getPlainTextPassword())
                .create();
    }
}
