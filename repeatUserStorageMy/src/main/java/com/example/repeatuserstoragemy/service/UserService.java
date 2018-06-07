package com.example.repeatuserstoragemy.service;

import com.example.repeatuserstoragemy.dto.UserDto;
import com.example.repeatuserstoragemy.model.User;
import com.example.repeatuserstoragemy.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentMap;

@Service
public interface UserService extends UserRepository {

    UserDto persistUserDto(User user);

    ConcurrentMap<Long, UserDto> getAllUserDtos();

    UserDto getUserDtoById(Long id);
}
