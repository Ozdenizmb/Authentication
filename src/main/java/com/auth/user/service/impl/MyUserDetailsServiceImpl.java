package com.auth.user.service.impl;

import com.auth.user.exception.ErrorMessages;
import com.auth.user.exception.UserException;
import com.auth.user.model.User;
import com.auth.user.repository.UserRepository;
import com.auth.user.service.MyUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MyUserDetailsServiceImpl implements MyUserDetailsService {

    private final UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> response = repository.findByEmail(email);

        if(response.isPresent()) {
            User existUser = response.get();

            return org.springframework.security.core.userdetails.User.builder()
                    .username(existUser.getEmail())
                    .password(existUser.getPassword())
                    .roles("USER")
                    .build();
        }
        else {
            throw UserException.withStatusAndMessage(HttpStatus.BAD_REQUEST, ErrorMessages.EMAIL_NOT_FOUND);
        }
    }

}
