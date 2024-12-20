package com.husseinabdallah.jwt_token.service.interfaces;

import com.husseinabdallah.jwt_token.model.dtos.ApiResponse;
import com.husseinabdallah.jwt_token.model.dtos.NavBarDto;
import com.husseinabdallah.jwt_token.model.entities.Header;
import org.springframework.http.ResponseEntity;

public interface HeaderInterface {

    ResponseEntity<ApiResponse<Header>> createHeader(NavBarDto header);
    ResponseEntity<ApiResponse<Header>> getHeader(int headerId);

}
