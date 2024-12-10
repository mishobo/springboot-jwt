package com.husseinabdallah.jwt_token.service.implementation;

import com.husseinabdallah.jwt_token.model.dtos.ApiResponse;
import com.husseinabdallah.jwt_token.model.entities.User;
import com.husseinabdallah.jwt_token.repository.UserRepository;
import com.husseinabdallah.jwt_token.service.interfaces.UserInterface;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserInterface {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public ResponseEntity<ApiResponse<List<User>>> getUsers() {
        var users = userRepository.findAllByOrderByCreatedAtDesc();

        ApiResponse<List<User>> response = new ApiResponse<>(
                true,
                "data fetched successfully",
                users,
                null
        );

        return ResponseEntity.ok(response);
    }
}
