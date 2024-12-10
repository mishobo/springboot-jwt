package com.husseinabdallah.jwt_token.service;

import com.husseinabdallah.jwt_token.model.dtos.LoginUserDto;
import com.husseinabdallah.jwt_token.model.dtos.RegisterUserDto;
import com.husseinabdallah.jwt_token.model.entities.User;
import com.husseinabdallah.jwt_token.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(
            UserRepository userRepository,
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder
    ) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User signup(RegisterUserDto input) {
        User user = new User(
                input.fullName(),
                input.email(),
                passwordEncoder.encode(input.password())
        );
        return userRepository.save(user);
    }

    public User authenticate(LoginUserDto input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.email(),
                        input.password()
                )
        );
        return userRepository.findByEmail(input.email()).orElseThrow();
    }


}
