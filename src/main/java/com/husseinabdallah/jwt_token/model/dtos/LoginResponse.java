package com.husseinabdallah.jwt_token.model.dtos;

public record LoginResponse(
        String token,
        long expiresIn
) {
}
