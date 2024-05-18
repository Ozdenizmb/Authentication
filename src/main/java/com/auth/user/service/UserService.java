package com.auth.user.service;

import com.auth.user.dto.UserCreateDto;
import com.auth.user.dto.UserDto;
import com.auth.user.dto.UserUpdateDto;

public interface UserService {

    UserDto createUser(UserCreateDto userCreateDto);
    UserDto getUser(String email);
    UserDto updateUser(UserUpdateDto userUpdateDto);
    Boolean deleteUser(String email);

}
