package com.husseinabdallah.jwt_token.service.implementation;

import com.husseinabdallah.jwt_token.model.dtos.ApiResponse;
import com.husseinabdallah.jwt_token.model.entities.SubHeader;
import com.husseinabdallah.jwt_token.repository.SubHeaderRepository;
import com.husseinabdallah.jwt_token.service.interfaces.SubHeaderInterface;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SubHeaderService implements SubHeaderInterface {

    private final SubHeaderRepository subHeaderRepository;

    public SubHeaderService(SubHeaderRepository subHeaderRepository) {
        this.subHeaderRepository = subHeaderRepository;
    }


    @Override
    public ResponseEntity<ApiResponse<SubHeader>> createSubHeader(SubHeader subHeader) {
        System.out.println(subHeader);
        var savedSubHeader = subHeaderRepository.save(subHeader);

        ApiResponse<SubHeader> response = new ApiResponse<>(
                true,
                "SubHeader saved successfully",
                savedSubHeader,
                null
        );

        return ResponseEntity.ok(response);
    }
}
