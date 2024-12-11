package com.husseinabdallah.jwt_token.service.implementation;

import com.husseinabdallah.jwt_token.model.dtos.ApiResponse;
import com.husseinabdallah.jwt_token.model.dtos.LoginResponse;
import com.husseinabdallah.jwt_token.model.dtos.LoginUserDto;
import com.husseinabdallah.jwt_token.model.dtos.RegisterUserDto;
import com.husseinabdallah.jwt_token.model.entities.User;
import com.husseinabdallah.jwt_token.repository.UserRepository;
import com.husseinabdallah.jwt_token.service.JwtService;
import com.husseinabdallah.jwt_token.service.interfaces.AuthenticationInterface;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService implements AuthenticationInterface {

    private final JwtService jwtService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(
            JwtService jwtService,
            UserRepository userRepository,
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder
    ) {
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public ResponseEntity<ApiResponse<User>> signup(RegisterUserDto input) {
        User user = new User(
                input.fullName(),
                input.email(),
                passwordEncoder.encode(input.password())
        );

        userRepository.save(user);

        ApiResponse<User> response = new ApiResponse<>(
                true,
                "data saved successfully",
                user,
                null
        );

        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<ApiResponse<LoginResponse>> authenticate(LoginUserDto input) {
        var auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.email(),
                        input.password()
                )
        );
        System.out.println("isAuthenticated: " + auth.isAuthenticated());
        var authenticatedUser = userRepository.findByEmail(input.email()).orElse(null);

        String jwtToken = jwtService.generateToken(authenticatedUser);

        LoginResponse loginResponse = new LoginResponse(jwtToken, jwtService.getExpirationTime());

        ApiResponse<LoginResponse> response = new ApiResponse<>(
                true,
                "authorization successful",
                loginResponse,
                null
        );

        return ResponseEntity.ok(response);
    }


}
