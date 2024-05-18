package com.auth.user.service.impl;

import com.auth.user.dto.UserCreateDto;
import com.auth.user.dto.UserDto;
import com.auth.user.dto.UserUpdateDto;
import com.auth.user.mapper.UserMapper;
import com.auth.user.model.User;
import com.auth.user.repository.UserRepository;
import com.auth.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper mapper;


    @Override
    public UUID createUser(UserCreateDto userCreateDto) {
        User user = new User();
        BeanUtils.copyProperties(userCreateDto, user);
        userRepository.save(user);
        return user.getId();
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
