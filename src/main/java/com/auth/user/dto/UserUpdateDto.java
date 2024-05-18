package com.auth.user.dto;

public record UserUpdateDto(
        String firstName,
        String lastName,
        String password,
        int age,
        String phoneNumber,
        String nationality
) {
}
