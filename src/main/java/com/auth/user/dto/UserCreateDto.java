package com.auth.user.dto;

import jakarta.validation.constraints.NotNull;

public record UserCreateDto(
        @NotNull
        String firstName,
        @NotNull
        String lastName,
        @NotNull
        String email,
        @NotNull
        String password,
        @NotNull
        int age,
        @NotNull
        String phoneNumber,
        @NotNull
        String nationality
) {
}
