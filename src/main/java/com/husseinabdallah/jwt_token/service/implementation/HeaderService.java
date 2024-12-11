package com.husseinabdallah.jwt_token.service.implementation;

import com.husseinabdallah.jwt_token.model.dtos.ApiResponse;
import com.husseinabdallah.jwt_token.model.entities.Header;
import com.husseinabdallah.jwt_token.repository.HeaderRepository;
import com.husseinabdallah.jwt_token.service.interfaces.HeaderInterface;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class HeaderService implements HeaderInterface {

    private final HeaderRepository headerRepository;

    public HeaderService(HeaderRepository headerRepository) {
        this.headerRepository = headerRepository;
    }

    @Override
    public ResponseEntity<ApiResponse<Header>> createHeader(Header header) {
        var savedHeader = headerRepository.save(header);

        ApiResponse<Header> response = new ApiResponse<>(
                true,
                "Menu Header saved successfully",
                savedHeader,
                null
        );

        return ResponseEntity.ok(response);
    }
}
