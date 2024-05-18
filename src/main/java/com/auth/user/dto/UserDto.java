package com.auth.user.dto;

import java.util.UUID;

public record UserDto(
        UUID id,
        String firstName,
        String lastName,
        int age,
        String phoneNumber,
        String nationality
) {
}
