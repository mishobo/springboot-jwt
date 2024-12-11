package com.husseinabdallah.jwt_token.service.interfaces;

import com.husseinabdallah.jwt_token.model.dtos.ApiResponse;
import com.husseinabdallah.jwt_token.model.entities.SubHeader;
import org.springframework.http.ResponseEntity;

public interface SubHeaderInterface {
    ResponseEntity<ApiResponse<SubHeader>> createSubHeader(SubHeader subHeader);
}
