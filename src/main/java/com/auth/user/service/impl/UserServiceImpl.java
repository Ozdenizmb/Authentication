package com.auth.user.service.impl;

import com.auth.user.dto.UserCreateDto;
import com.auth.user.dto.UserDto;
import com.auth.user.dto.UserUpdateDto;
import com.auth.user.exception.ErrorMessages;
import com.auth.user.exception.UserException;
import com.auth.user.mapper.UserMapper;
import com.auth.user.model.User;
import com.auth.user.repository.UserRepository;
import com.auth.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;
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
    public UserDto getUser(String email, String password) {
        Optional<User> response = userRepository.findByEmail(email);

        if(response.isPresent()) {
            User user = response.get();
            if(Objects.equals(user.getPassword(), password)) {
                return mapper.toDto(user);
            }
            else {
                throw UserException.withStatusAndMessage(HttpStatus.UNAUTHORIZED, ErrorMessages.INCORRECT_LOGIN);
            }
        }
        else {
            throw UserException.withStatusAndMessage(HttpStatus.BAD_REQUEST, ErrorMessages.EMAIL_NOT_FOUND);
        }
    }

    @Override
    public UserDto updateUser(String email, UserUpdateDto userUpdateDto) {
        Optional<User> response = userRepository.findByEmail(email);

        if(response.isEmpty()) {
            throw UserException.withStatusAndMessage(HttpStatus.BAD_REQUEST, ErrorMessages.USER_NOT_FOUND);
        }

        User existUser = response.get();
        BeanUtils.copyProperties(userUpdateDto, existUser);

        return mapper.toDto(userRepository.save(existUser));
    }

    @Override
    public Boolean deleteUser(String email) {
        return null;
    }
}
