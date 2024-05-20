package com.auth.user.controller;

import com.auth.user.api.UserApi;
import com.auth.user.dto.UserCreateDto;
import com.auth.user.dto.UserDto;
import com.auth.user.dto.UserUpdateDto;
import com.auth.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
public class UserController implements UserApi {

    private final UserService userService;

    @Override
    public ResponseEntity<UUID> signUp(UserCreateDto userCreateDto) {
        return ResponseEntity.ok(userService.createUser(userCreateDto));
    }

    @Override
    public ResponseEntity<UserDto> login(String email, String password) {
        return ResponseEntity.ok(userService.getUser(email, password));
    }

    @Override
    public ResponseEntity<UserDto> updateUser(String email, UserUpdateDto userUpdateDto) {
        return ResponseEntity.ok(userService.updateUser(email, userUpdateDto));
    }

    @Override
    public ResponseEntity<Boolean> deleteUser(String email) {
        return ResponseEntity.ok(userService.deleteUser(email));
    }
}
