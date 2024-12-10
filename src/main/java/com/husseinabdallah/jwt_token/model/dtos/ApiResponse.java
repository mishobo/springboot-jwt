package com.husseinabdallah.jwt_token.model.dtos;

public record ApiResponse<T>(
        Boolean status,
        String message,
        T data,
        Object metadata
) {
}
