package com.husseinabdallah.jwt_token.service.interfaces;

import com.husseinabdallah.jwt_token.model.dtos.ApiResponse;
import com.husseinabdallah.jwt_token.model.entities.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserInterface {

    ResponseEntity<ApiResponse<List<User>>>  getUsers();

}
