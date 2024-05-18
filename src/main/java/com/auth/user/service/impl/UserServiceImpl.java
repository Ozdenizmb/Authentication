package com.auth.user.service.impl;

import com.auth.user.dto.UserCreateDto;
import com.auth.user.dto.UserDto;
import com.auth.user.dto.UserUpdateDto;
import com.auth.user.repository.UserRepository;
import com.auth.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    @Override
    public UserDto createUser(UserCreateDto userCreateDto) {
        return null;
    }

    @Override
    public UserDto getUser(String email) {
        return null;
    }

    @Override
    public UserDto updateUser(UserUpdateDto userUpdateDto) {
        return null;
    }

    @Override
    public Boolean deleteUser(String email) {
        return null;
    }
}
