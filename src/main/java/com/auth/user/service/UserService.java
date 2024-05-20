package com.auth.user.service;

import com.auth.user.dto.UserCreateDto;
import com.auth.user.dto.UserDto;
import com.auth.user.dto.UserUpdateDto;

import java.util.UUID;

public interface UserService {

    UUID createUser(UserCreateDto userCreateDto);
    UserDto getUser(String email, String password);
    UserDto updateUser(String email, UserUpdateDto userUpdateDto);
    Boolean deleteUser(String email);

}
