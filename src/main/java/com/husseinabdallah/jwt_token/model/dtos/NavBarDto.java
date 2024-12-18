package com.husseinabdallah.jwt_token.model.dtos;


import java.util.List;

public record NavBarDto(
        String headerName, List<SubHeaders> subHeader
) {
}
