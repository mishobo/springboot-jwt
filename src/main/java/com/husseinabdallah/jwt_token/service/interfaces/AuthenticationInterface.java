package com.husseinabdallah.jwt_token.service.interfaces;

import com.husseinabdallah.jwt_token.model.dtos.ApiResponse;
import com.husseinabdallah.jwt_token.model.dtos.LoginResponse;
import com.husseinabdallah.jwt_token.model.dtos.LoginUserDto;
import com.husseinabdallah.jwt_token.model.dtos.RegisterUserDto;
import com.husseinabdallah.jwt_token.model.entities.User;
import org.springframework.http.ResponseEntity;

public interface AuthenticationInterface {

     ResponseEntity<ApiResponse<User>> signup(RegisterUserDto input);
     ResponseEntity<ApiResponse<LoginResponse>> authenticate(LoginUserDto input);


}
