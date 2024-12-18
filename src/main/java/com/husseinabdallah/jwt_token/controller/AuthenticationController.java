package com.husseinabdallah.jwt_token.controller;

import com.husseinabdallah.jwt_token.model.dtos.ApiResponse;
import com.husseinabdallah.jwt_token.model.dtos.LoginResponse;
import com.husseinabdallah.jwt_token.model.dtos.LoginUserDto;
import com.husseinabdallah.jwt_token.model.dtos.RegisterUserDto;
import com.husseinabdallah.jwt_token.model.entities.User;
import com.husseinabdallah.jwt_token.service.implementation.AuthenticationService;
import com.husseinabdallah.jwt_token.service.JwtService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/signup")
    public ResponseEntity<ApiResponse<User>> register(@RequestBody RegisterUserDto registerUserDto) {
        return authenticationService.signup(registerUserDto);

    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<LoginResponse>> authenticate(@RequestBody LoginUserDto loginUserDto) {
        return authenticationService.authenticate(loginUserDto);
    }

}
