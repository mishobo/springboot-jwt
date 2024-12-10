package com.husseinabdallah.jwt_token.model.dtos;

public record RegisterUserDto(
        String email,
        String password,
        String fullName
) {
}
