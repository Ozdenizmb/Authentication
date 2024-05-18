package com.auth.user.controller;

import com.auth.user.api.UserApi;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserController implements UserApi {
}
