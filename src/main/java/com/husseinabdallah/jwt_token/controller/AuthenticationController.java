package com.husseinabdallah.jwt_token.controller;

import com.husseinabdallah.jwt_token.model.dtos.LoginResponse;
import com.husseinabdallah.jwt_token.model.dtos.LoginUserDto;
import com.husseinabdallah.jwt_token.model.dtos.RegisterUserDto;
import com.husseinabdallah.jwt_token.model.entities.User;
import com.husseinabdallah.jwt_token.service.AuthenticationService;
import com.husseinabdallah.jwt_token.service.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/auth")
@RestController
public class AuthenticationController {
    private final JwtService jwtService;

    private final AuthenticationService authenticationService;


    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/signup")
    public ResponseEntity<User> register(@RequestBody RegisterUserDto registerUserDto) {
        System.out.println(registerUserDto);
        User registeredUser = authenticationService.signup(registerUserDto);

        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginUserDto loginUserDto) {
        User authenticatedUser = authenticationService.authenticate(loginUserDto);

        String jwtToken = jwtService.generateToken(authenticatedUser);

        LoginResponse loginResponse = new LoginResponse(
                jwtToken,
                jwtService.getExpirationTime()
        );
                //.setToken(jwtToken).setExpiresIn(jwtService.getExpirationTime());

        return ResponseEntity.ok(loginResponse);
    }

}
